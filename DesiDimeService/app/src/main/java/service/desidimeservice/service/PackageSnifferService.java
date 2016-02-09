package service.desidimeservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import service.desidimeservice.manager.PackageSniffer;

public class PackageSnifferService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        PackageSniffer packageSniffer = new PackageSniffer(getApplicationContext());
        packageSniffer.startSniffingForPakage();

        return START_STICKY;
    }
}
