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

    public PackageSniffer(Context context) {
        mContext = context;
    }

    public void startSniffingForPakage() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                ActivityManager am = (ActivityManager) mContext.getSystemService(Context
                        .ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am
                        .getRunningAppProcesses();

                for (ActivityManager.RunningAppProcessInfo appProcess : runningAppProcessInfo) {
                    Log.d(appProcess.processName.toString(), "is running");

                    String currentApp = "NULL";
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES
                            .LOLLIPOP) {
                        UsageStatsManager usm = (UsageStatsManager) mContext.getSystemService
                                (Context.USAGE_STATS_SERVICE);
                        long time = System.currentTimeMillis();
                        List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager
                                .INTERVAL_DAILY, time - 1000 * 1000, time);
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
                    } else {
                        List<ActivityManager.RunningAppProcessInfo> tasks = am
                                .getRunningAppProcesses();
                        currentApp = tasks.get(0).processName;
                    }
                    startIconService(currentApp);


                }
            }
        }, 2000, 3000);

    }

    private void startIconService(String processName) {

        String currentPackage;

        switch (processName) {
            case Constants.AMAZON: {
                currentPackage = Constants.AMAZON;
                Intent intent = new Intent(mContext, IconService.class);
                intent.putExtra(Constants.PACKAGE_NAME, currentPackage);
                mContext.startService(intent);
            }
            break;

            case Constants.FLIPKART: {
                currentPackage = Constants.FLIPKART;
                Intent intent = new Intent(mContext, IconService.class);
                intent.putExtra(Constants.PACKAGE_NAME, currentPackage);
                mContext.startService(intent);
            }
            break;

            case Constants.LATEX_MOBILE: {
                currentPackage = Constants.LATEX_MOBILE;
                Intent intent = new Intent(mContext, IconService.class);
                intent.putExtra(Constants.PACKAGE_NAME, currentPackage);
                mContext.startService(intent);
            }
            break;

        }

    }


}
