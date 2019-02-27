package com.nan.tutor.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nan on 2019/2/27.
 */
public class Student extends People implements Serializable {
    @SerializedName("subject")
    private List<String> subject;

    @SerializedName("spare_time")
    private List<String> spareTime;

    @SerializedName("grade")
    private String grade;
}
