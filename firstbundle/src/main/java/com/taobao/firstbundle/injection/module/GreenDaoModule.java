package com.taobao.firstbundle.injection.module;

import com.taobao.firstbundle.db.DaoSession;
import com.taobao.firstbundle.db.UserEntityDao;
import dagger.Module;
import dagger.Provides;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/4/8 15:41
 * @ Version V1.0
 */

@Module
public class GreenDaoModule {

  protected final DaoSession mDaoSession;

  public GreenDaoModule(DaoSession daoSession) {
    mDaoSession = daoSession;
  }


  @Provides
  public UserEntityDao getUserDao(){
    return  mDaoSession.getUserEntityDao();
  }


}
