package service.desidimeservice.manager;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;
import java.util.SortedMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import service.desidimeservice.service.IconService;
import service.desidimeservice.utility.Constants;

public class PackageSniffer {

    private Context mContext;
    private Timer mTimer;
    public PackageSniffer(Context context) {
        mContext = context;
    }

    public void startSniffingForPackage() {
        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                String currentApp = "NULL";
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES
                        .LOLLIPOP) {
                    UsageStatsManager usageStatsManager = (UsageStatsManager) mContext
                            .getSystemService
                                    (Context.USAGE_STATS_SERVICE);
                    List<UsageStats> appList = usageStatsManager.queryUsageStats
                            (UsageStatsManager.INTERVAL_DAILY, 0, System.currentTimeMillis());
                    if (appList != null && appList.size() > 0) {
                        SortedMap<Long, UsageStats> mySortedMap = new TreeMap<>();
                        for (UsageStats usageStats : appList) {
                            mySortedMap.put(usageStats.getLastTimeUsed(), usageStats);
                        }
                        if (mySortedMap != null && !mySortedMap.isEmpty()) {
                            currentApp = mySortedMap.get(mySortedMap.lastKey())
                                    .getPackageName();
                        }
                    }
                    Log.d(PackageSniffer.class.getSimpleName(), "Current app in for loop  " +
                            currentApp);

                } else {
                    ActivityManager am = (ActivityManager) mContext.getSystemService(Context
                            .ACTIVITY_SERVICE);
                    List<ActivityManager.RunningAppProcessInfo> tasks = am
                            .getRunningAppProcesses();
                    currentApp = tasks.get(0).processName;

                }
                startIconService(currentApp);
            }
        }, 2000, 3000);
    }

    private void startIconService(String processName) {
        Intent intent = new Intent(mContext, IconService.class);
        switch (processName) {
            case Constants.Package.AMAZON_PACKAGE_NAME: {
                intent.putExtra(Constants.PACKAGE_NAME, processName);
                mContext.startService(intent);
            }
            break;

            case Constants.Package.FLIPKART_PACKAGE_NAME: {
                intent.putExtra(Constants.PACKAGE_NAME, processName);
                mContext.startService(intent);
            }
            break;

            case Constants.Package.CALCULATOR_PACKAGE_NAME: {
                intent.putExtra(Constants.PACKAGE_NAME, processName);
                mContext.startService(intent);
            }
            break;
        }
    }


    public void destroyTimer() {
        if (mTimer != null) {
            mTimer.purge();
            mTimer.cancel();
            mTimer = null;
        }
    }
}
