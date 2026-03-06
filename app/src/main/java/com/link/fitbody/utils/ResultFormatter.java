package com.link.fitbody.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;

public class ResultFormatter {
    public static Spannable formatResult(Context context, String message, int colorResId) {
        Spannable spannable = new SpannableString(message);

        int spanStart = message.indexOf(':') + 1;
        int spanEnd = message.length();

        if (spanStart > 0 && spanStart < spanEnd) {
            spannable.setSpan(new RelativeSizeSpan(2f), spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new ForegroundColorSpan(context.getColor(colorResId)), spanStart, spanEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannable;
    }
}
