package com.aaronhalbert.nonaddictivereddit4droid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RedditFragmentPagerAdapter extends FragmentPagerAdapter {
    static final int NUM_ITEMS = 2;

    public RedditFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        return AllPostsFragment.newInstance("abc", "def");
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) return "/r/All"; else return "Home";
    }


}
