package com.taobao.firstbundle.injection.module;

import android.app.Application;
import android.content.Context;
import com.taobao.firstbundle.injection.scope.ApplicationContext;
import dagger.Module;
import dagger.Provides;


/**
 * Created by Anthony on 2016/6/13.
 * Class Note:
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }








}
