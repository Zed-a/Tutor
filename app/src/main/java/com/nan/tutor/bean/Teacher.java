package com.nan.tutor.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by nan on 2019/2/27.
 */
public class Teacher implements Serializable {

    @SerializedName("degree")
    private String degree;

    @SerializedName("address")
    private String address;

    @SerializedName("teach_age")
    private int teachAge;
}
