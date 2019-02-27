package com.nan.tutor.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author nan
 * @date 2019/2/27
 */

public class JsonDataResp<T> implements Serializable {
    @SerializedName("rc")
    public int code;

    @SerializedName("err_msg")
    public String errMsg;

    @SerializedName("data")
    public T data;
}
