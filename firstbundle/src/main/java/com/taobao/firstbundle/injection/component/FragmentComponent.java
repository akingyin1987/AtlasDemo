package com.taobao.firstbundle.injection.component;

import android.app.Activity;
import com.taobao.firstbundle.injection.module.FragmentModule;
import com.taobao.firstbundle.injection.scope.PreFragment;
import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@PreFragment
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {


    Activity getActivity();


}
