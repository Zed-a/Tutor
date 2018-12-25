package com.nan.tutor.manager;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.content.SharedPreferences.Editor;
/**
 * Created by nan on 2018/12/25.
 */
public abstract class PreferenceHelper {
    public abstract void save(Editor editor);

    private static PreferenceHelper sHelper;

    public static PreferenceHelper getInstance() {
        if (null == sHelper) {
            sHelper = new NewPreferenceHelper();
        }
        return sHelper;
    }

    private static class OlderPreferenceHelper extends PreferenceHelper {

        @Override
        public void save(Editor editor) {
            editor.commit();
        }

    }

    private static class NewPreferenceHelper extends PreferenceHelper {

        @SuppressLint("NewApi")
        @Override
        public void save(Editor editor) {
            editor.apply();
        }

    }
}
