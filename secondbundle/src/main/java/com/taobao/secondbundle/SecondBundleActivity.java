package com.taobao.secondbundle;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.taobao.publicBundle.PreferencesUtil;

public class SecondBundleActivity extends AppCompatActivity implements PlusOneFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondbundle);
        System.out.println("name="+PreferencesUtil.getDefaultName());
        String   value = PreferencesUtil.get("test","");
        System.out.println("value="+value);
//        Toast.makeText(this,"ddddddddddd",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
