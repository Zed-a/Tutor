package com.nan.tutor.di;

import com.nan.tutor.ui.fragment.StudyFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author nan
 * @date 2019/2/27
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract StudyFragment studyFragment();
}

