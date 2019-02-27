package com.nan.tutor.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nan on 2019/2/27.
 */
public class Student implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("password")
    private String password;

    @SerializedName("name")
    private String name;

    @SerializedName("sex")
    private String sex;

    @SerializedName("age")
    private String age;

    @SerializedName("phone")
    private String phone;

    @SerializedName("subject")
    private List<String> subject;

    @SerializedName("spare_time")
    private List<String> spareTime;

    @SerializedName("grade")
    private String grade;
}
