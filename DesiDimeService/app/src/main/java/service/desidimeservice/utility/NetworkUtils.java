package service.desidimeservice.utility;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

import service.desidimeservice.R;

public class NetworkUtils {

    public static boolean isAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static void displayNetworkDialog(final Context ctx) {
        try {
            new AlertDialog.Builder(ctx).setTitle(R.string.app_name).setMessage(R.string
                    .no_internet)
                    .setPositiveButton(ctx.getResources().getString(R.string.ok_text), new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ((Activity) ctx).finish();
                                }
                            }).create().show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }
}