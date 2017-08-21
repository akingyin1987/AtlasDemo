package com.taobao.injection.component;

import android.app.Application;
import android.content.Context;


import com.taobao.injection.module.ApplicationModule;
import com.taobao.injection.module.GreenDaoModule;
import com.taobao.injection.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @ Description:
 *  单列组件，生命周期承APP 一起
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date ${DATE} ${TIME}
 * @ Version V1.0
 */
@Singleton
@Component(modules = { ApplicationModule.class, GreenDaoModule.class})
public interface ApplicationComponent {

    void inject(Application application);




    @ApplicationContext
    Context context();

    Application application();






}
