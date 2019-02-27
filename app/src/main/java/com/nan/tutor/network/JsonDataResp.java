package com.nan.tutor.network;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author nan
 * @date 2019/2/27
 */

public class JsonDataResp<T> implements Serializable {
    @SerializedName("code")
    public int code;

    @SerializedName("msg")
    public String msg;

    @SerializedName("data")
    public T data;

    @Override
    public String toString() {
        return "JsonDataResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data.toString() +
                '}';
    }
}
