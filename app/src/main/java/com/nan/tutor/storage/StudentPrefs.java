package com.nan.tutor.storage;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.nan.tutor.bean.Student;
import com.nan.tutor.di.ForApplication;

import javax.inject.Inject;

/**
 * Created by nan on 2019/2/27.
 */
public class StudentPrefs extends TutorPrefs{
    private static final String PREFS_NAME = "teacherPrefs";
    private static final String STUDENT = "student";

    @Inject Gson gson;

    @Inject StudentPrefs(@ForApplication Context context) {
        super(context, PREFS_NAME);
    }

    public Student getStudent() {
        return gson.fromJson(getString(STUDENT),Student.class);
    }

    public void setStudent(@NonNull Student student) {
        super.setString(STUDENT,gson.toJson(student));
    }
}
