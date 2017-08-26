package com.taobao.secondbundle;

import android.app.Application;

/**
 * Created by Administrator on 2017/8/25.
 */

public class SecondApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("SecondApp");
    }
}
