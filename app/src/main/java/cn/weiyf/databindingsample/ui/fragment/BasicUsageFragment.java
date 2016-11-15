package cn.weiyf.databindingsample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.weiyf.databindingsample.base.BaseFragment;
import cn.weiyf.databindingsample.databinding.FragmentBasicUsageBinding;

/**
 * Created by weiyf on 16-11-15.
 */

public class BasicUsageFragment extends BaseFragment {

    private FragmentBasicUsageBinding mBasicUsageBinding;

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
    }
}
