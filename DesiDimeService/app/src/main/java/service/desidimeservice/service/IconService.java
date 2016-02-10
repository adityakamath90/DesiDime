package service.desidimeservice.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import service.desidimeservice.R;
import service.desidimeservice.manager.PackageSniffer;
import service.desidimeservice.ui.MainActivity;
import service.desidimeservice.utility.Constants;

public class IconService extends Service {

    private WindowManager mWindowManager;
    private ImageView mChatHead;
    private String mPackageName;

    public IconService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(IconService.class.getSimpleName(), "I con service started");

        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mChatHead = new ImageView(this);
        mChatHead.setImageResource(R.mipmap.ic_launcher);

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;

        mWindowManager.addView(mChatHead, params);

        mChatHead.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;
            private boolean mIsMoving;

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mIsMoving = false;
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (!mIsMoving && (initialX - initialTouchX) < 10 && (initialY -
                                initialTouchY) < 10) {
                            launchActivity();
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        mIsMoving = true;
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        mWindowManager.updateViewLayout(mChatHead, params);
                        return true;
                }
                return false;
            }
        });
    }

    private void launchActivity() {
        Intent intent = new Intent(IconService.this, MainActivity.class);
        intent.putExtra(Constants.PACKAGE_NAME, mPackageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(PackageSniffer.class.getSimpleName(), "OnStart command");

        mPackageName = readIntent(intent);
        Log.d(PackageSniffer.class.getSimpleName(), "Package name OnStart command " +
                "-------------->" + mPackageName);
        sendLocalBroadcast(mPackageName);
        return START_NOT_STICKY;
    }

    private void sendLocalBroadcast(String packageName) {
        Intent broadCastIntent = new Intent(Constants.PACKAGE_NAME_BROADCAST);
        broadCastIntent.putExtra(Constants.PACKAGE_NAME, packageName);
        LocalBroadcastManager.getInstance(this).sendBroadcast(broadCastIntent);
    }

    private String readIntent(Intent intent) {
        String packageName = null;
        if (intent != null) {
            if (intent.hasExtra(Constants.PACKAGE_NAME)) {
                mPackageName = intent.getStringExtra(Constants.PACKAGE_NAME);
            }
        }
        return packageName;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(PackageSniffer.class.getSimpleName(), "OnDestroy");
        if (mChatHead != null) {
            mWindowManager.removeView(mChatHead);
        }
    }


}
