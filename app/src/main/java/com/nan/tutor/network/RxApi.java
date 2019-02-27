package com.nan.tutor.network;

import android.support.annotation.NonNull;

import rx.Observable;

/**
 * @author nan
 * @date 2019/2/27
 */
public class RxApi {
    /**
     * 不会监听生命周期
     */
    public static <T> void execute(@NonNull Observable<T> request,
                                   @NonNull RxSubscriber<T> rxSubscriber) {
        request.compose(RxSchedulers.<T>networkThenMain())
                .subscribe(rxSubscriber);
    }

    /**
     * 1. 网络请求线程切换；
     * 2. 监听ILifecycleProvider生命周期
     *
     * 使用方法:
     * ```
     *  MTop.getUser(1)
     *      .compose(RxApi.<User>networkRequestTransformer(lifecycleProvider))
     *      .subscribe(new RxSubscriber() {});
     *```
     */
//    public static <T> Observable.Transformer<T, T> networkRequestTransformer(
//            @Nullable final ILifecycleProvider lifecycleProvider) {
//        return new Observable.Transformer<T, T>() {
//            @Override
//            public Observable<T> call(Observable<T> source) {
//                Observable<T> scheduledObservable = source.compose(RxSchedulers.<T>networkThenMain());
//                if (lifecycleProvider != null) {
//                    if (lifecycleProvider instanceof BaseActivity) {
//                        BaseActivity baseActivity = (BaseActivity) lifecycleProvider;
//                        return scheduledObservable.compose(
//                                baseActivity.<T>bindUntilEvent(ActivityLifecycle.DESTROY));
//                    }
//                    if (lifecycleProvider instanceof BaseFragment) {
//                        BaseFragment baseFragment = (BaseFragment) lifecycleProvider;
//                        //return scheduledObservable.compose(
//                        //baseFragment.<T>bindUntilEvent(FragmentLifecycle.DESTROY_VIEW));
//                    }
//                }
//                return scheduledObservable;
//            }
//        };
//    }
}
