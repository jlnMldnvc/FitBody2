package com.link.fitbody.utils;

import android.text.Spannable;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SnackbarHelper {
    public static void showError(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.show();
    }

    public static void showResult(View view, Spannable spannable) {
        Snackbar snackbar = Snackbar.make(view, spannable, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.show();
    }
}
