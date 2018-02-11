package com.example.vinod.mailtemplate;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by Dell XPS on 1/26/2018.
 */


public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;

    private String fragments[] =  {"Mail" ,"Contact" , "List"};
    private Context mContext;

    public CategoryFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public CategoryFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MailFragment();
        } else if (position == 1) {
            return new ContactFragment();
        }  else {
            return new ListFragment();
        }
    }
    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}