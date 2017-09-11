package com.atlas.threebundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.atlas.threebundle.db.User;
import com.atlas.threebundle.db.dao.DaoMaster;
import com.atlas.threebundle.db.dao.DaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

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
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"person-db");
        Database db =  helper.getWritableDb();
        DaoSession daoSession = new DaoMaster(db).newSession();
        User  user = new User();

        user.name="system"+System.currentTimeMillis();
        daoSession.getUserDao().save(user);


    }
}
