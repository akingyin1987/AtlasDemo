package com.atlas.threebundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



/**
 * Created by Administrator on 2017/8/25.
 */

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trheemain);
        findViewById(R.id.threebundle_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent();
                intent.setClassName(ThreeActivity.this,"com.taobao.secondbundle.ShareDataActivity");
                startActivity(intent);
            }
        });

    }
}
