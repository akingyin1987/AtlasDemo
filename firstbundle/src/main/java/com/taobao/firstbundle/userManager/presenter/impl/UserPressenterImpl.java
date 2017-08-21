package com.taobao.firstbundle.userManager.presenter.impl;

import com.taobao.firstbundle.db.UserEntity;
import com.taobao.firstbundle.db.UserEntityDao;
import com.taobao.firstbundle.userManager.presenter.UserContract;
import java.util.List;
import javax.inject.Inject;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/8/21 17:42
 * @ Version V1.0
 */

public class UserPressenterImpl  implements UserContract.Presenter {

  UserContract.View   mView;

  @Inject UserEntityDao mUserEntityDao;

  @Inject
  public UserPressenterImpl() {

  }

  @Override public boolean delectUser(UserEntity userEntity) {
    return false;
  }

  @Override public UserEntity saveUser(String name, String demo) {
    return null;
  }

  @Override public boolean modieyUser(String name, String demo, UserEntity userEntity) {
    return false;
  }

  @Override public boolean checkUser(String name, UserEntity userEntity) {
    return false;
  }

  @Override public List<UserEntity> findAllUser() {
    return null;
  }

  @Override public void attachView(UserContract.View view) {
    this.mView = view;
  }

  @Override public void detachView() {
    if(null != mView){
      mView = null;
    }
  }

  @Override public void initialization() {

  }
}
