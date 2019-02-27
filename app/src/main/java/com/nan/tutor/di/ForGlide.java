package com.nan.tutor.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author nan
 * @date 2019/2/27
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForGlide {
}
