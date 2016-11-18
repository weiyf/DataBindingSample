package cn.weiyf.databindingsample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.weiyf.databindingsample.base.BaseFragment;
import cn.weiyf.databindingsample.databinding.FragmentBasicUsageBinding;
import cn.weiyf.databindingsample.entity.User;

public class BasicUsageFragment extends BaseFragment {

    private FragmentBasicUsageBinding mBasicUsageBinding;

    private Presenter mPresenter;

    public static BasicUsageFragment newInstance() {

        Bundle args = new Bundle();

        BasicUsageFragment fragment = new BasicUsageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBasicUsageBinding = FragmentBasicUsageBinding.inflate(inflater, container, false);
        return mBasicUsageBinding.getRoot();
    }

    @Override
    protected void initViews(@Nullable Bundle bundle) {
        mPresenter = new Presenter();
        mPresenter.mUser = new User("firstName", "lastName", 16);
        mBasicUsageBinding.setUser(mPresenter.mUser);
        mBasicUsageBinding.setPresenter(mPresenter);
    }

    public class Presenter {

        private User mUser;

        public void onFirstNameChanged(CharSequence s, int start, int before, int count) {
            mBasicUsageBinding.watcher.setText("firstName: " + s + "\nstart: " + start +
                    "\nbefore: " + before + "\ncount: " + count);
        }

        public void changedFirstName(View view) {
            mUser.setFirstName("改名字怎么了");
            showToast("点击事件, \nuser： " + mBasicUsageBinding.getUser().toString());
        }

        public void printUser(User user) {
            showToast(user.toString());
        }

    }
}
