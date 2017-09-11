package com.taobao.secondbundle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.taobao.publicBundle.Tools;


/**
 * Created by Administrator on 2017/8/24.
 */

public class ShareDataActivity  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_plus_one);
        Tools.getCurrentTime();

//        System.out.println("name="+ PreferencesUtil.getDefaultName());
//        String   value = PreferencesUtil.get("test","");
//        System.out.println("value="+value);
    }
}
