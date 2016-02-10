package service.desidimeservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import service.desidimeservice.manager.PackageSniffer;

public class PackageSnifferService extends Service {

    private PackageSniffer mPackageSniffer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mPackageSniffer = new PackageSniffer(getApplicationContext());
        mPackageSniffer.startSniffingForPackage();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPackageSniffer != null) {
            mPackageSniffer.destroyTimer();
        }
    }
}
