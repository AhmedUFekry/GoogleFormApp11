package com.dev.banna.googleformapp.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dev.banna.googleformapp.main.fragments.learning_leaders.LearningLeadersFragment;
import com.dev.banna.googleformapp.main.fragments.skills.SkillIQLeadersFragment;


public class MainPagerAdapter extends FragmentStateAdapter {

    private int itemCount;

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new LearningLeadersFragment();
            case 1:
                return new SkillIQLeadersFragment();

            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int count) {
        itemCount = count;
    }
}

