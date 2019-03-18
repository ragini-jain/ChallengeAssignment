package com.gl.application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int noOfTabs;

    public PagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){

           case 0:
               BasicFragment basicFragment = new BasicFragment();
               return basicFragment;
           case 1:
               ScientificFragment scientificFragment = new ScientificFragment();
               return  scientificFragment;

           default:return  null;
       }

    }


    @Override
    public int getCount() {
        return noOfTabs;
    }
}
