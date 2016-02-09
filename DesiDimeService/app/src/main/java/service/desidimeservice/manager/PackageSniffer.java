package service.desidimeservice.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
            int phonelaunched = 0, phoneclosed = 0;
            int phonelaunches = 1;

            @Override
            public void run() {
                ActivityManager am = (ActivityManager) mContext.getSystemService(Context
                        .ACTIVITY_SERVICE);
                List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am
                        .getRunningAppProcesses();

                for (ActivityManager.RunningAppProcessInfo appProcess : runningAppProcessInfo) {
                    Log.d(appProcess.processName.toString(), "is running");

                    for (int packageCounter = 0; packageCounter < Constants.PACKAGES.length;
                         packageCounter++) {
                        if (appProcess.processName.equals(Constants.PACKAGES[packageCounter])) {
                            if (appProcess.importance == ActivityManager.RunningAppProcessInfo
                                    .IMPORTANCE_FOREGROUND) {
                                if (phonelaunched == 0) {
                                    phonelaunched = 1;
                                    startIconService(appProcess.processName);
                                } else if (phoneclosed == 1) {
                                    phonelaunches++;
                                    phoneclosed = 0;
                                }
                            } else {
                                phoneclosed = 1;
                            }
                        }
                    }


                }
            }
        }, 2000, 3000);
    }

    private void startIconService(String processName) {

        String currentPackage = null;

        switch (processName) {
            case Constants.AMAZON: {
                currentPackage = Constants.AMAZON;
            }
            break;

            case Constants.FLIPKART: {
                currentPackage = Constants.FLIPKART;
            }
            break;

            case Constants.LATEX_MOBILE: {
                currentPackage = Constants.LATEX_MOBILE;
            }
            break;

        }
        Intent intent = new Intent(mContext, IconService.class);
        intent.putExtra(Constants.PACKAGE_NAME, currentPackage);
        mContext.startService(intent);
    }

}
