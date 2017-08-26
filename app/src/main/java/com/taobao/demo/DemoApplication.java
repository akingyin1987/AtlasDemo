package com.taobao.demo;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.taobao.atlas.bundleInfo.AtlasBundleInfoManager;
import android.taobao.atlas.bundleInfo.BundleListing;
import android.taobao.atlas.framework.Atlas;
import android.taobao.atlas.runtime.ActivityTaskMgr;
import android.taobao.atlas.runtime.ClassNotFoundInterceptorCallback;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mapapi.SDKInitializer;
import com.facebook.stetho.Stetho;
import com.taobao.injection.component.ApplicationComponent;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.osgi.framework.BundleException;

/**
 * Created by guanjie on 2017/3/16.
 */

public class DemoApplication extends Application {
    private ApplicationComponent mAppComponent;
    @Override
    public void onCreate() {

        super.onCreate();
        Stetho.initializeWithDefaults(this);
        CrashReport.initCrashReport(this);

        SDKInitializer.initialize(getApplicationContext());

        Atlas.getInstance().setClassNotFoundInterceptorCallback(new ClassNotFoundInterceptorCallback() {
            @Override
            public Intent returnIntent(Intent intent) {
                final String className = intent.getComponent().getClassName();
                BundleListing bundleInfo = AtlasBundleInfoManager.instance().getBundleInfo();
                LinkedHashMap<String,BundleListing.BundleInfo>  bundleInfoLinkedHashMap = bundleInfo.getBundles();
                for(BundleListing.BundleInfo bundleInfo1 :bundleInfoLinkedHashMap.values()){
                    System.out.println(bundleInfo1.getName()+":"+bundleInfo1.getPkgName());
                    HashMap<String,Boolean>  booleanHashMap = bundleInfo1.getActivities();
                    if(null != booleanHashMap){
                        for(String  key : booleanHashMap.keySet()){
                            System.out.println(key+":"+booleanHashMap.get(key));
                        }
                    }

                }
                final String bundleName = AtlasBundleInfoManager.instance().getBundleForComponet(className);
                System.out.println("className="+className+":"+bundleName);
                if (!TextUtils.isEmpty(bundleName) && !AtlasBundleInfoManager.instance().isInternalBundle(bundleName)) {

                    //远程bundle
                    Activity activity = ActivityTaskMgr.getInstance().peekTopActivity();
                    File remoteBundleFile = new File(activity.getExternalCacheDir(),"lib" + bundleName.replace(".","_") + ".so");

                    String path = "";
                    if (remoteBundleFile.exists()){
                        path = remoteBundleFile.getAbsolutePath();
                    }else {
                        Toast.makeText(activity, " 远程bundle不存在，请确定 : " + remoteBundleFile.getAbsolutePath() , Toast.LENGTH_LONG).show();
                        return intent;
                    }


                    PackageInfo info = activity.getPackageManager().getPackageArchiveInfo(path, 0);
                    try {
                        Atlas.getInstance().installBundle(info.packageName, new File(path));
                    } catch (BundleException e) {
                        Toast.makeText(activity, " 远程bundle 安装失败，" + e.getMessage() , Toast.LENGTH_LONG).show();

                        e.printStackTrace();
                    }

                    activity.startActivities(new Intent[]{intent});

                }

                return intent;
            }
        });

    }

    public ApplicationComponent getAppComponent() {
        if (mAppComponent == null) {

            //mAppComponent = DaggerApplicationComponent.builder().
            //        applicationModule(new ApplicationModule((Application) getApplicationContext()))
            //        .greenDaoModule(new GreenDaoModule())
            //        .build();
        }
        return mAppComponent;
    }
}
