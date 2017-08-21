package com.taobao.injection.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.taobao.injection.scope.ActivityContext;
import com.taobao.injection.scope.PreFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @PreFragment
    public Activity provideActivity() {
        return fragment.getActivity();
    }

    @Provides
    @ActivityContext
    Context providesContext() {
        return fragment.getActivity();
    }

}
