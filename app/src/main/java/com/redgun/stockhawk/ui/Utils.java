package com.redgun.stockhawk.ui;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.redgun.stockhawk.R;

/**
 * Created by Ravindra on 13-02-2017.
 */
public class Utils {
    /**
     * Method to display Toast message
     */
    public static void showToast(Context _context, String value) {
        if (value != null)
            Toast.makeText(_context, value, Toast.LENGTH_LONG).show();
    }

    public static boolean isOnline(Context _context) {
        ConnectivityManager cm =
                (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            new AlertDialog.Builder(_context)
                    .setTitle(_context.getResources().getString(R.string.app_name))
                    .setMessage(
                            _context.getResources().getString(
                                    R.string.internet_error))
                    .setPositiveButton("OK", null).show();
        }
        return false;
    }
}
