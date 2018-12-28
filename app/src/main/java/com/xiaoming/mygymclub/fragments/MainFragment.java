package com.xiaoming.mygymclub.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoming.mygymclub.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;


public class MainFragment extends SupportFragment {
    private static final int REQ_MSG = 10;

    public static final int FIRST = 0;
    public static final int SECOND = 1;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_bar_home_bottom)
    LinearLayout mBottomNavigationBar;
    @BindView(R.id.tab_home_page)
    TextView mTabMenuHome;
    @BindView(R.id.tab_train)
    TextView mTabTrainerBooking;

    private SupportFragment[] mFragments = new SupportFragment[2];

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);
        ButterKnife.bind(this,view);

        mTabMenuHome.performClick();  //触发点击以进入HomePage
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportFragment firstFragment = findChildFragment(HomePageFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = HomePageFragment.newInstance();
            mFragments[SECOND] = TrainerBookingFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_tab_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findChildFragment(TrainerBookingFragment.class);
        }
    }

    @Override
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
        super.onFragmentResult(requestCode, resultCode, data);
        if (requestCode == REQ_MSG && resultCode == RESULT_OK) {

        }
    }

    private void setSelected() {
        mTabMenuHome.setSelected(false);
        mTabTrainerBooking.setSelected(false);
    }

    @OnClick({R.id.tab_home_page, R.id.tab_train})
    void onBottomNavigationBarSelected(View v) {
        //先隐藏全部Fragment
        switch (v.getId()) {
            case R.id.tab_home_page:
                showHideFragment(mFragments[0], mFragments[1]);
                toolbar.setTitle(R.string.home_title);
                break;
            case R.id.tab_train:
                showHideFragment(mFragments[1], mFragments[0]);
                toolbar.setTitle(R.string.trainer_list_title);
                break;
        }
    }

    /**
     * start other BrotherFragment
     */
    public void startBrotherFragment(SupportFragment targetFragment) {
        start(targetFragment);
    }
}
