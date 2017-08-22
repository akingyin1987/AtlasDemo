package com.taobao.firstbundle.injection.component;

import com.taobao.firstbundle.injection.module.ActivityModule;
import com.taobao.firstbundle.injection.scope.PerActivity;
import com.taobao.firstbundle.userManager.ui.UserListActivity;
import dagger.Component;

/**
 * 生命周期与Activity一起
 * Created by Anthony on 2016/6/13.
 * Class Note:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


  void  inject(UserListActivity  activity);



}
