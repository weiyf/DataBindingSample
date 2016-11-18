package cn.weiyf.databindingsample.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import cn.weiyf.databindingsample.R;
import cn.weiyf.databindingsample.base.BaseActivity;
import cn.weiyf.databindingsample.base.BaseFragment;
import cn.weiyf.databindingsample.databinding.ActivityMainBinding;
import cn.weiyf.databindingsample.ui.fragment.BasicUsageFragment;
import cn.weiyf.databindingsample.ui.fragment.GettingStartedFragment;

public class MainActivity extends BaseActivity {

    private BaseFragment[] mFragments;


    private ActivityMainBinding mMainBinding;

    private Presenter mPresenter;

    @Override
    protected void initViews(@Nullable Bundle bundle) {
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (bundle == null) {
            mFragments = new BaseFragment[]{
                    GettingStartedFragment.newInstance(),
                    BasicUsageFragment.newInstance()
            };
        } else {
            mFragments[0] = findFragment(GettingStartedFragment.class);
            mFragments[1] = findFragment(BasicUsageFragment.class);
        }
        mPresenter = new Presenter();
        mMainBinding.setPresenter(mPresenter);
        loadMultipleRootFragment(R.id.main_container, 0, mFragments);
        mPresenter.toggle = new ActionBarDrawerToggle(
                this, mMainBinding.drawerLayout, mMainBinding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mPresenter.toggle.syncState();

    }


    @Override
    public void onBackPressedSupport() {
        if (mMainBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressedSupport();
        }
    }


    public class Presenter implements NavigationView.OnNavigationItemSelectedListener {


        public ActionBarDrawerToggle toggle;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            showToast(item.getTitle().toString());
            int id = item.getItemId();

            if (id == R.id.getting_started) {
                showHideFragment(mFragments[0], mFragments[1]);
            } else if (id == R.id.basic_usage) {
                showHideFragment(mFragments[1], mFragments[0]);
            } else if (id == R.id.advanced_usage) {

            } else if (id == R.id.actual_combat) {

            }

            mMainBinding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
    }
}
