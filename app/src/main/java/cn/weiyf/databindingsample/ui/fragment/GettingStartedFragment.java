package cn.weiyf.databindingsample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.weiyf.databindingsample.base.BaseFragment;
import cn.weiyf.databindingsample.databinding.GettingStartedBinding;
import cn.weiyf.databindingsample.entity.User;

public class GettingStartedFragment extends BaseFragment {

    private GettingStartedBinding mGettingStartedBinding;


    public static GettingStartedFragment newInstance() {

        Bundle args = new Bundle();

        GettingStartedFragment fragment = new GettingStartedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mGettingStartedBinding = GettingStartedBinding.inflate(inflater, container, false);
//        or
//        mGettingStartedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_getting_started, container, false);
        return mGettingStartedBinding.getRoot();
    }

    @Override
    protected void initViews(@Nullable Bundle bundle) {
        mGettingStartedBinding.setUser(new User("firstName", "lastName"));
//        or
//        mGettingStartedBinding.setVariable(BR.user, new User("firstName", "lastName"));
    }
}
