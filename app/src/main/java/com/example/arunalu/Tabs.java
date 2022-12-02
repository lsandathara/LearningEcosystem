package com.example.arunalu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class Tabs extends FragmentStatePagerAdapter {

    int numOfTabs;
    public Tabs(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                AboutChild aboutChild = new AboutChild();
                return aboutChild;
            case 1:
                AddChild addChild = new AddChild();
                return addChild;
            case 2:
                UpdateChild updateChild = new UpdateChild();
                return updateChild;
            case 3:
                ViewChild viewChild = new ViewChild();
                return viewChild;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
