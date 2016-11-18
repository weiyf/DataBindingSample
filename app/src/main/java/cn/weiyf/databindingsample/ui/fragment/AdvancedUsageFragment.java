package cn.weiyf.databindingsample.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.weiyf.databindingsample.base.BaseFragment;
import cn.weiyf.databindingsample.databinding.FragmentAdvancedUsageBinding;

/**
 * Created by weiyf on 16-11-18.
 */

public class AdvancedUsageFragment extends BaseFragment {

    private FragmentAdvancedUsageBinding mAdvancedUsageBinding;


    public static AdvancedUsageFragment newInstance() {

        Bundle args = new Bundle();

        AdvancedUsageFragment fragment = new AdvancedUsageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAdvancedUsageBinding = FragmentAdvancedUsageBinding.inflate(inflater, container, false);
        return mAdvancedUsageBinding.getRoot();
    }

    @Override
    protected void initViews(@Nullable Bundle bundle) {

    }

    public class Presenter {

    }
}
