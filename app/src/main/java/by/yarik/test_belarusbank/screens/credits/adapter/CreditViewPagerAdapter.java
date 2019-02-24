package by.yarik.test_belarusbank.screens.credits.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import by.yarik.test_belarusbank.screens.credits.item.CreditItemsFragment;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditSection;

public class CreditViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<CreditSection> sections;

    public CreditViewPagerAdapter(FragmentManager fm, List<CreditSection> sections) {
        super(fm);
        this.sections = sections;
    }

    @Override
    public Fragment getItem(int position) {
        return CreditItemsFragment.newInstance(sections.get(position));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return sections.get(position).getSectionTitle();
    }

    @Override
    public int getCount() {
        return sections.size();
    }
}
