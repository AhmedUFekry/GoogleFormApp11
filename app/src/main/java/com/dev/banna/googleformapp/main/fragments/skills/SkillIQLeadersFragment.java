package com.dev.banna.googleformapp.main.fragments.skills;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.banna.googleformapp.R;
import com.dev.banna.googleformapp.base.BaseFragment;
import com.dev.banna.googleformapp.network.ApiClient;
import com.dev.banna.googleformapp.network.models.SkillsResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersFragment extends BaseFragment implements SkillIQLeadersAdapter.Callback {
    private static final String TAG = "SkillIQLeadersFragment";

    @BindView(R.id.rv_learning_leaders)
    RecyclerView mRecyclerView;

    SkillIQLeadersAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);
        setUnBinder(ButterKnife.bind(this, view));

        return view;
    }


    @Override
    protected void setUp(View view) {
        initRecyclerView();
        getIQSkillsApiCall();
    }

    void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mAdapter = new SkillIQLeadersAdapter(new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
    }

    void getIQSkillsApiCall() {
        ApiClient.getInstance().getIQSkillsApiCall().enqueue(new Callback<List<SkillsResponse>>() {
            @Override
            public void onResponse(Call<List<SkillsResponse>> call, Response<List<SkillsResponse>> response) {
                Log.d(TAG, "onResponse: " + response.body().toString());
                List<SkillsResponse> mResponse = response.body();
                mAdapter.addItems(mResponse);
            }

            @Override
            public void onFailure(Call<List<SkillsResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void onMerchantClick(SkillsResponse dataBean) {

    }
}
