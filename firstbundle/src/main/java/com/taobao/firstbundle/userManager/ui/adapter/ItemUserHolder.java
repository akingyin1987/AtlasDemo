package com.taobao.firstbundle.userManager.ui.adapter;

import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.chad.library.adapter.base.BaseViewHolder;
import com.taobao.firstbundle.R2;
import com.taobao.firstbundle.db.UserEntity;

public class ItemUserHolder extends BaseViewHolder {
  @BindView(R2.id.item_more) ImageView mItemMore;
  private TextView tvSort;
  private TextView tvName;
  private TextView tvDemo;
  private TextView tvTime;

  public ItemUserHolder(LayoutInflater inflater, ViewGroup parent) {
    this(inflater.inflate(R2.layout.item_user, parent, false));
  }

  public ItemUserHolder(View view) {
    super(view);
    ButterKnife.bind(this, view);
    tvSort = (TextView) view.findViewById(R2.id.tv_sort);
    tvName = (TextView) view.findViewById(R2.id.tv_name);
    tvDemo = (TextView) view.findViewById(R2.id.tv_demo);
    tvTime = (TextView) view.findViewById(R2.id.tv_time);
  }

  public void bind(UserEntity userEntity, int postion) {
    tvSort.setText(String.valueOf(postion));
    tvName.setText("用户名：" + userEntity.getName());
    tvDemo.setText("备注：" + userEntity.getAge());

    //tvTime.setText(null == userEntity.time ? "" : TimeUtils.format(userEntity.time));
  }

  public TextView getTvDemo() {
    return tvDemo;
  }

  public TextView getTvName() {
    return tvName;
  }

  public TextView getTvTime() {
    return tvTime;
  }

  public TextView getTvSort() {
    return tvSort;
  }

 // @OnClick(R.id.item_more)
  public void onViewClicked() {
    PopupMenu   popupMenu = new PopupMenu(itemView.getContext(),mItemMore);
    popupMenu.getMenu().add(1,1,1,"修改");
    popupMenu.getMenu().add(2,2,2,"删除");
    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        return false;
      }
    });
    popupMenu.show();

  }
}
