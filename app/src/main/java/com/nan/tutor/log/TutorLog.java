package com.nan.tutor.log;

import android.util.Log;

/**
 * Created by nan on 2019/2/27.
 */
public class TutorLog {

    private static final String DEFAULT_TAG = "Tutor";

    /**
     * Info log
     */
    public static void i(String tag, int msg) {
        i(tag,msg+"");
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void i(String msg) {
        Log.i(DEFAULT_TAG, msg);
    }

    /**
     * Debug log
     */
    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void d(String msg) {
        Log.d(DEFAULT_TAG, msg);
    }

    /**
     * Error log
     */
    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void e(String msg) {
        Log.e(DEFAULT_TAG, msg);
    }

    /**
     * Warning log
     */
    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void w(String msg) {
        Log.w(DEFAULT_TAG, msg);
    }


    /**
     * Critical error log
     */
    public static void wtf(String tag, String msg) {
        Log.wtf(tag, msg);
    }

    public static void wtf(String msg) {
        Log.wtf(DEFAULT_TAG, msg);
    }

}
