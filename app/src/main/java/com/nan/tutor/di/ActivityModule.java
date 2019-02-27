package com.nan.tutor.di;

import com.nan.tutor.ui.activity.HomeActivity;
import com.nan.tutor.ui.activity.LoginActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author nan
 * @date 2019/2/27
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract HomeActivity homeActivity();

    @ContributesAndroidInjector
    abstract LoginActivity loginActivity();
}
