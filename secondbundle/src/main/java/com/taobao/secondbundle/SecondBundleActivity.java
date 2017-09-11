package com.taobao.secondbundle;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.taobao.secondbundle.db.dao.DaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

public class SecondBundleActivity extends AppCompatActivity implements PlusOneFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondbundle);
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"user-db");
        Database db =  helper.getWritableDb();
      //  DaoMaster  daoMaster = new DaoMaster(db);
        //DaoSession daoSession = new DaoMaster(db).newSession();
        //Person   person = new Person();
        //person.name="name";
        //daoSession.getPersonDao().save(person);
//        Toast.makeText(this,"ddddddddddd",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
