package com.nan.tutor.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nan on 2019/2/27.
 */
public class People {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("sex")
    private String sex;

    @SerializedName("age")
    private String age;

    @SerializedName("phone")
    private String phone;
}
