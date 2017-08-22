package com.taobao.firstbundle.userManager.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.taobao.firstbundle.FirstBundleApp;
import com.taobao.firstbundle.R;
import com.taobao.firstbundle.R2;
import com.taobao.firstbundle.db.UserEntity;
import com.taobao.firstbundle.injection.component.ActivityComponent;
import com.taobao.firstbundle.injection.component.DaggerActivityComponent;
import com.taobao.firstbundle.injection.module.ActivityModule;
import com.taobao.firstbundle.userManager.presenter.UserContract;
import com.taobao.firstbundle.userManager.presenter.impl.UserPressenterImpl;
import com.taobao.firstbundle.userManager.ui.adapter.UserListAdapter;
import javax.inject.Inject;

/**
 * @ Description:
 * @ Author king
 * @ Date 2017/4/11 17:47
 * @ Version V1.0
 */

public class UserListActivity extends AppCompatActivity
    implements UserContract.View {

  @BindView(R2.id.recycler) RecyclerView mRecycler;

  @Inject UserListAdapter mUserListAdapter;
  @BindView(R2.id.toolbar) Toolbar mToolbar;
  @BindView(R2.id.appbar) AppBarLayout mAppbar;
  @BindView(R2.id.fab_edit_task_done) FloatingActionButton mFabEditTaskDone;
  @BindView(R2.id.coordinatorLayout) CoordinatorLayout mCoordinatorLayout;
  @BindView(R2.id.action_mv) ActionMenuView mActionMv;
  @Inject
   UserPressenterImpl   mPresenter;




   protected void initEventAndData() {
    mPresenter.attachView(this);
    mRecycler.setLayoutManager(new LinearLayoutManager(this));
    mRecycler.setItemAnimator(new DefaultItemAnimator());
    mRecycler.setAdapter(mUserListAdapter);
    ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mUserListAdapter);
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
    itemTouchHelper.attachToRecyclerView(mRecycler);


    mUserListAdapter.addData(mPresenter.findAllUser());

    // 开启拖拽
    mUserListAdapter.enableDragItem(itemTouchHelper, R.id.item_more, true);
    mUserListAdapter.setOnItemDragListener(new OnItemDragListener() {
      @Override public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
         System.out.println("onItemDragStart");
      }

      @Override public void onItemDragMoving(RecyclerView.ViewHolder source, int from,
          RecyclerView.ViewHolder target, int to) {
        System.out.println("onItemDragMoving");
      }

      @Override public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
        System.out.println("onItemDragEnd");
      }
    });
    //mUserListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
    //  @Override public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
    //    showEditUserDialgo(mUserListAdapter.getItem(position), position);
    //  }
    //});

    //mUserListAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
    //  @Override public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
    //    showDelectUserDialog(mUserListAdapter.getItem(position), position);
    //    return true;
    //  }
    //});

    mUserListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
      @Override public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if(view.getId() == R.id.item_more){
          showMore(position,view);
        }
        System.out.println("--------onItemChildClick-------------");
      }
    });


    mActionMv.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId() == R.id.menu_model){
          RecyclerView.LayoutManager  layoutManager =mRecycler.getLayoutManager();
          if(layoutManager instanceof GridLayoutManager){
            mRecycler.setLayoutManager(new LinearLayoutManager(UserListActivity.this));
          }else{
            mRecycler.setLayoutManager(new GridLayoutManager(UserListActivity.this,2));
          }
        }
        return false;
      }
    });
  }

  private   void   showMore(final int  postion,View  view){
    PopupMenu popupMenu = new PopupMenu(this,view);
    popupMenu.getMenu().add(1,1,1,"修改");
    popupMenu.getMenu().add(2,2,2,"删除");
    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
      @Override public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId() == 1){
          showEditUserDialgo(mUserListAdapter.getItem(postion),postion);
        }else if(item.getItemId() == 2){
          showDelectUserDialog(mUserListAdapter.getItem(postion),postion);
        }
        return true;
      }
    });
    popupMenu.show();
  }

   protected int getContentViewID() {
    return R.layout.activity_userlist;
  }

  private ActivityComponent mActivityComponent;
  public ActivityComponent activityComponent() {
    if (mActivityComponent == null) {

      mActivityComponent = DaggerActivityComponent.builder()
          .applicationComponent(FirstBundleApp.get().getAppComponent())
          .activityModule(new ActivityModule(this))
          .build();
    }
    return mActivityComponent;
  }
   protected void injectDagger() {
    activityComponent().inject(this);
  }

   protected void initToolBar() {
    setSupportActionBar(mToolbar);
    if (null != getSupportActionBar()) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // TODO: add setContentView(...) invocation
    setContentView(getContentViewID());
    ButterKnife.bind(this);
    initToolBar();
    injectDagger();
    initEventAndData();
  }

  @OnClick(R2.id.fab_edit_task_done) public void onViewClicked() {

    showEditUserDialgo(null, 0);
  }



  @Override public void showDelectUserDialog(final UserEntity userEntity, final int postion) {

  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.user_menu , mActionMv.getMenu()); //将menu关联
    return super.onCreateOptionsMenu(menu);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mPresenter.detachView();
  }

  @Override public void showMessage(String msg) {

  }

  @Override public void close() {

  }

  @Override public void showTips(String msg) {

  }

  @Override public void showLoadDialog() {

  }

  @Override public void hideLoadDialog() {

  }

  @Override public void showEditUserDialgo(UserEntity userEntity, int postion) {

  }
}
