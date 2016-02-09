package service.desidimeservice.manager;

import android.app.Application;
import android.content.Intent;

import service.desidimeservice.service.PackageSnifferService;

public class DesiDimeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, PackageSnifferService.class));
    }
}
