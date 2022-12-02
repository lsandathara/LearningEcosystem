package com.example.arunalu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    private int behavior;
    PagerAdapter (FragmentManager fm, int behavior) {
        super (fm);
        this.behavior = behavior;
    }

    @Override
    public Fragment getItem (int position) {
        switch (position) {
            case 0:
                return new AboutChild();
            case 1:
                return new AddChild();
            case 2:
                return new UpdateChild();
            case 3:
                return new ViewChild();
            default:
                return null;
        }
    }
    @Override
    public int getCount () {
        return behavior;
    }


}
