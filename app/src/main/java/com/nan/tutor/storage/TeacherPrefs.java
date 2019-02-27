package com.nan.tutor.storage;

import android.content.Context;

import com.google.gson.Gson;
import com.nan.tutor.di.ForApplication;

import javax.inject.Inject;

/**
 * Created by nan on 2019/2/27.
 */
public class TeacherPrefs extends TutorPrefs{
    private final static String PREFS_NAME = "teacherPrefs";

    @Inject
    Gson gson;

    @Inject TeacherPrefs(@ForApplication Context context) {
        super(context, PREFS_NAME);
    }

    public void setA() {
        super.setString("a","123");
    }

    public String getA() {
        return super.getString("a");
    }
}
