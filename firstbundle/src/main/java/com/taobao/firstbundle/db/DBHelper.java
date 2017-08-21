package com.taobao.firstbundle.db;

import android.content.Context;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/8/21 15:51
 * @ Version V1.0
 */

public class DBHelper {

  private static DBHelper instance;
  private static Context mContext;

  private static DaoMaster daoMaster;
  private static DaoSession daoSession;

  /**
   * 取得DaoMaster
   *
   * @param context
   * @return
   */
  public static DaoMaster getDaoMaster(Context context) {
    if (daoMaster == null) {
      DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context,
          "notes.db", null);
      daoMaster = new DaoMaster(helper.getWritableDatabase());
    }
    return daoMaster;
  }

  /**
   * 取得DaoSession
   *
   * @param context
   * @return
   */
  public static DaoSession getDaoSession(Context context) {
    if (daoSession == null) {
      if (daoMaster == null) {
        daoMaster = getDaoMaster(context);
      }
      daoSession = daoMaster.newSession();
    }
    return daoSession;
  }

  private DBHelper() {
  }

  public static void init(Context context) {
    mContext = context;
    instance = new DBHelper();
    // 数据库对象
    DaoSession daoSession = getDaoSession(mContext);

  }

  public static DBHelper getInstance() {
    return instance;
  }
}
