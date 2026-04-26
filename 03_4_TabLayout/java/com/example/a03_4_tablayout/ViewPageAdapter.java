package com.example.a03_4_tablayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new FirstFragment();
            case 1: return new SecondFragment();
            case 2: return new ThirdFragment();
        }
        return new FirstFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}