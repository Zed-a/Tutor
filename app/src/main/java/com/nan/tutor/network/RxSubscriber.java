package com.nan.tutor.network;

import com.nan.tutor.R;
import com.nan.tutor.TutorApplication;
import com.nan.tutor.util.ToastUtil;

import rx.Subscriber;

/**
 * @author nan
 * @date 2019/2/27
 */
public class RxSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        ToastUtil.show(TutorApplication.getInstance().getApplicationContext(), R.string.network_error);
    }

    @Override
    public void onNext(T t) {

    }
}
