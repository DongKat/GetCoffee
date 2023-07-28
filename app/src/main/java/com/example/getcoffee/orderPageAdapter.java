package com.example.getcoffee;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class orderPageAdapter extends FragmentPagerAdapter
{
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitle = new ArrayList<>();

    public orderPageAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    public void addFragment(Fragment fragment, String title)
    {
        fragmentList.add(fragment);
        fragmentTitle.add(title);
    }

    @NonNull
    public Fragment createFragment(int position)
    {
        return fragmentList.get(position);
    }

    public int getItemCount()
    {
        return fragmentList.size();
    }

    public CharSequence getPageTitle(int position)
    {
        return fragmentTitle.get(position);
    }

}
