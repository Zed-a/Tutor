package com.nan.tutor.util;

import android.content.Context;
import android.util.Log;

public class LogUtil {
    public static void Log(Context context, String tag, String msg){
        Log.d(context.getClass().getSimpleName()+":"+tag,msg);
    }
}
