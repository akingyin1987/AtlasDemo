package com.taobao.firstbundle.userManager.presenter;

import com.taobao.firstbundle.base.BasePresenter;
import com.taobao.firstbundle.base.BaseView;
import com.taobao.firstbundle.db.UserEntity;
import java.util.List;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/4/11 17:49
 * @ Version V1.0
 */

public interface UserContract {

  interface View extends BaseView {

     void  showEditUserDialgo(UserEntity userEntity, int postion);


     void  showDelectUserDialog(UserEntity userEntity, int postion);

  }

  interface Presenter extends BasePresenter<View> {

     boolean   delectUser(UserEntity userEntity);

     UserEntity   saveUser(String name, String demo);

     boolean   modieyUser(String name, String demo, UserEntity userEntity);

     boolean   checkUser(String name, UserEntity userEntity);
     List<UserEntity> findAllUser();


  }
}
