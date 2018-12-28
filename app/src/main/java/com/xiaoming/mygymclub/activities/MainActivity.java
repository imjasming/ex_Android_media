package com.xiaoming.mygymclub.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoming.mygymclub.R;
import com.xiaoming.mygymclub.fragments.BaseMainFragment;
import com.xiaoming.mygymclub.fragments.HomePageFragment;
import com.xiaoming.mygymclub.fragments.MainFragment;
import com.xiaoming.mygymclub.fragments.TrainerBookingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class MainActivity extends SupportActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseMainFragment.OnFragmentOpenDrawerListener {

    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    /*@BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_bar_home_bottom)
    LinearLayout mBottomNavigationBar;
    @BindView(R.id.tab_home_page)
    TextView mTabMenuHome;
    @BindView(R.id.tab_train)
    TextView mTabTrainerBooking;*/

    private FragmentManager mFragmentManager;
    private Fragment mFragmentShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (findFragment(MainFragment.class) == null) {
            loadRootFragment(R.id.main_fragment_container, MainFragment.newInstance());
        }

        initView();

        //这才是
//        mTabMenuHome.performClick();  //触发点击以进入HomePage
    }

    private void initView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

        /*View navHeader = mNavigationView.getHeaderView(0);
        mHeadImg = navHeader.findViewById(R.id.nav_head_img);
        mHeadImg.setOnClickListener(e -> {
            final ISupportFragment topFragment = getTopFragment();
            SupportFragment home = (SupportFragment) topFragment;
            home.start(UserCenterFragment.newInstance(), SupportFragment.SINGLETASK);
            mDrawerLayout.closeDrawer(GravityCompat.START);
        });*/

    }

    @Override
    public void onBackPressedSupport() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            ISupportFragment topFragment = getTopFragment();

            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                pop();
            } else {
                if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                    finish();
                } else {
                    TOUCH_TIME = System.currentTimeMillis();
                    Toast.makeText(this, R.string.press_again_exit, Toast.LENGTH_SHORT).show();
                }
            }

            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//End of Auto Generated

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
    }

    @Override
    public void onOpenDrawer() {
        if (!mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }
/*
    private void setSelected() {
        mTabMenuHome.setSelected(false);
        mTabTrainerBooking.setSelected(false);
    }

    @OnClick({R.id.tab_home_page, R.id.tab_train})
    void onBottomNavigationBarSelected(View v) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        //先隐藏全部Fragment
        switch (v.getId()) {
            case R.id.tab_home_page:
                //set all tab item selected to false
                setSelected();
                mTabMenuHome.setSelected(true);
                mFragmentShown = new HomePageFragment();
                transaction.replace(R.id.fl_tab_container, mFragmentShown);
                toolbar.setTitle(R.string.home_title);
                break;
            case R.id.tab_train:
                setSelected();
                mTabTrainerBooking.setSelected(true);
                mFragmentShown = new TrainerBookingFragment();
                transaction.replace(R.id.fl_tab_container, mFragmentShown);
                toolbar.setTitle(R.string.trainer_list_title);
                break;
        }

        transaction.commit();
    }*/
}
