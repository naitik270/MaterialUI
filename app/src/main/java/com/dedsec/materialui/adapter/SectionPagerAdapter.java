package com.dedsec.materialui.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dedsec.materialui.fragment.JAVACodeFrag;
import com.dedsec.materialui.fragment.XMLCodeFrag;

public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new XMLCodeFrag();
            case 1:
                return new JAVACodeFrag();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "XML";
            case 1:
                return "JAVA";
        }
        return null;
    }

}
