package com.example.cll.caolilu1508b20171123.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.cll.caolilu1508b20171123.View.ClassFragment;
import com.example.cll.caolilu1508b20171123.View.HomeFragment;

/**
 * Created by cll on 2017/11/23.
 */

public class Fragmen extends FragmentPagerAdapter {

    public Fragmen(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new HomeFragment();
                break;
            case 1:
                fragment=new ClassFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
