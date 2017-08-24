package com.taobao.firstbundle;

import android.app.Application;
import android.content.Context;
import com.taobao.firstbundle.db.DBHelper;
import com.taobao.firstbundle.injection.component.ApplicationComponent;
import com.taobao.firstbundle.injection.component.DaggerApplicationComponent;
import com.taobao.firstbundle.injection.module.ApplicationModule;
import com.taobao.firstbundle.injection.module.GreenDaoModule;
import com.taobao.publicBundle.KissTools;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/8/21 17:21
 * @ Version V1.0
 */

public class FirstBundleApp  extends Application {

  private static FirstBundleApp myApplication = null;

  private ApplicationComponent mAppComponent;
  @Override public void onCreate() {
    super.onCreate();
    DBHelper.init(getApplicationContext());
    myApplication = this;
    System.out.println("onCreate");
    KissTools.setContext(getApplicationContext());
  }

  public ApplicationComponent getAppComponent() {
    if (mAppComponent == null) {

      mAppComponent = DaggerApplicationComponent.builder().
          applicationModule(new ApplicationModule((Application) getApplicationContext()))
          .greenDaoModule(new GreenDaoModule(DBHelper.getDaoSession(getApplicationContext())))
          .build();
    }
    return mAppComponent;
  }

  public static FirstBundleApp get(Context context) {
    return (FirstBundleApp) context.getApplicationContext();
  }

  public static FirstBundleApp get() {
    return myApplication;
  }

  public void setAppComponent(ApplicationComponent appComponent) {
    mAppComponent = appComponent;
  }

}
