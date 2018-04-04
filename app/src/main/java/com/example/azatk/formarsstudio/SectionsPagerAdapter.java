package com.example.azatk.formarsstudio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.azatk.formarsstudio.Fragments.BlankFragment1;
import com.example.azatk.formarsstudio.Fragments.BlankFragment2;

/**
 * Created by azatk on 04.04.2018.
 */

class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                BlankFragment1 fragment1=new BlankFragment1();
                return fragment1;
            case 1:
                BlankFragment2 fragment2=new BlankFragment2();
                return fragment2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Статьи";
            case 1:
                return "Новости";
            default:
                return null;
        }
    }
}
