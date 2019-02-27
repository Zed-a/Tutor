package com.nan.tutor.di;

import android.app.Application;

import com.nan.tutor.TutorApplication;
import com.nan.tutor.image.TutorGlideModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * @author nan
 * @date 2019/2/27
 */
@Singleton
@Component(modules = {
        AppModule.class,
        ActivityModule.class,
        FragmentModule.class
})
public interface AppComponent {

    void inject(TutorApplication application);

    void inject(TutorGlideModule module);

    @Component.Builder
    interface Builder {
        AppComponent build();
        @BindsInstance Builder application(Application application);
    }
}
