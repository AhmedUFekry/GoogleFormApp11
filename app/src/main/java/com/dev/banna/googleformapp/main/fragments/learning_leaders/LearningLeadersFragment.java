package com.dev.banna.googleformapp.main.fragments.learning_leaders;

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
import com.dev.banna.googleformapp.network.models.HoursResponse;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends BaseFragment implements LearningLeadersAdapter.Callback {

    private static final String TAG = "LearningLeadersFragment";

    @BindView(R.id.rv_learning_leaders)
    RecyclerView mRecyclerView;

    LearningLeadersAdapter mAdapter;

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
        getHoursApiCall();
    }

    void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mAdapter = new LearningLeadersAdapter(new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onMerchantClick(HoursResponse dataBean) {

    }


    void getHoursApiCall() {
        ApiClient.getInstance().getHoursApiCall().enqueue(new Callback<List<HoursResponse>>() {


            @Override
            public void onResponse(Call<List<HoursResponse>> call, Response<List<HoursResponse>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).toString());
                List<HoursResponse> mResponse = response.body();
                mAdapter.addItems(mResponse);
            }

            @Override
            public void onFailure(Call<List<HoursResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}
