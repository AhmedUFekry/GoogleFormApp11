package com.dev.banna.googleformapp.main.fragments.learning_leaders;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dev.banna.googleformapp.R;
import com.dev.banna.googleformapp.base.BaseViewHolder;
import com.dev.banna.googleformapp.network.models.HoursResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningLeadersAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_SEARCH = 1;


    private Callback mCallback;
    private List<HoursResponse> mMerchantsList;

    public LearningLeadersAdapter(List<HoursResponse> list) {
        mMerchantsList = list;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_SEARCH:
                return new SearchViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hours, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mMerchantsList != null) {

            if (mMerchantsList.size() > 0)
                return VIEW_TYPE_SEARCH;
            else
                return VIEW_TYPE_EMPTY;

        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mMerchantsList != null && mMerchantsList.size() > 0) {
            return mMerchantsList.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<HoursResponse> list) {
        mMerchantsList.clear();
        mMerchantsList.addAll(list);
        notifyDataSetChanged();
    }


    public void clear() {
        mMerchantsList.clear();
        notifyDataSetChanged();
    }

    public interface Callback {
        void onMerchantClick(HoursResponse dataBean);
    }

    public class SearchViewHolder extends BaseViewHolder {

        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_description)
        TextView tvDescription;

        public SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        protected void clear() {

        }

        @SuppressLint("SetTextI18n")
        public void onBind(int position) {
            super.onBind(position);

            HoursResponse dataBean = mMerchantsList.get(position);

            Glide.with(itemView)
                    .load(dataBean.getBadgeUrl())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(ivIcon);

            tvTitle.setText(dataBean.getName());
            tvDescription.setText(dataBean.getHours() + "," + dataBean.getCountry());

        }
    }


    public class EmptyViewHolder extends BaseViewHolder {

        EmptyViewHolder(View itemView) {
            super(itemView);

        }

        @Override
        protected void clear() {

        }

    }
}