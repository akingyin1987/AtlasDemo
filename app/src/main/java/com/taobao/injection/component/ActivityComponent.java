package com.taobao.injection.component;


import com.taobao.injection.module.ActivityModule;
import com.taobao.injection.scope.PerActivity;

import dagger.Component;

/**
 * 生命周期与Activity一起
 * Created by Anthony on 2016/6/13.
 * Class Note:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {



}
