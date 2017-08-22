package com.taobao.firstbundle.userManager.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.taobao.firstbundle.R2;
import com.taobao.firstbundle.db.UserEntity;
import com.taobao.firstbundle.injection.scope.ActivityContext;
import javax.inject.Inject;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/4/11 17:35
 * @ Version V1.0
 */

public class UserListAdapter  extends BaseItemDraggableAdapter<UserEntity,ItemUserHolder> {

  Context  mContext;

  LayoutInflater   mInflater;

  @Inject
  public UserListAdapter(@ActivityContext Context  context) {
    super( null);
    this.mContext = context;
    mInflater = LayoutInflater.from(context);
  }

  @Override protected ItemUserHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
    return new ItemUserHolder(mInflater,parent);
  }

  @Override protected void convert(ItemUserHolder helper, UserEntity item) {
     helper.addOnClickListener(R2.id.item_more);
     helper.bind(item,helper.getAdapterPosition()+1);
  }
}
