package com.nan.tutor.util;

import android.content.Context;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;

/**
 * @author nan
 * @date 2019/2/28
 */
public class LocationManager {

    private static LocationManager INSTANCE = null;
    public static LocationManager getIntance() {
        if (INSTANCE == null) {
            synchronized (LocationManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LocationManager();
                }
            }
        }
        return INSTANCE;
    }

    private LocationClient mLocationClient;

    /**
     * 获取当前位置信息
     */
    public void getLocation(Context context, CallBack<BDLocation> callback) {
        mLocationClient = new LocationClient(context.getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener(callback));
        SDKInitializer.initialize(context.getApplicationContext());
        requestLocation();
    }

    private void requestLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    private class MyLocationListener extends BDAbstractLocationListener {

        CallBack<BDLocation> callback;
        MyLocationListener(CallBack<BDLocation> callback) {
            this.callback = callback;
        }

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location.getLocType() == BDLocation.TypeGpsLocation
                    || location.getLocType() == BDLocation.TypeNetWorkLocation) {
                if (callback != null) {
                    callback.action(location);
                }
            }
        }

    }
}
