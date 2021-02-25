package com.jmdevs.petagram.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class pageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> frags;

    public pageAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        frags = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}
