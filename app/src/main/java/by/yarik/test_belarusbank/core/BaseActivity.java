package by.yarik.test_belarusbank.core;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import by.yarik.test_belarusbank.R;

public class BaseActivity extends AppCompatActivity {

    public void setMainFragment(Fragment fragment) {
        setFragment(fragment, false);
    }

    public void setCurrentFragment(Fragment fragment) {
        setFragment(fragment, true);
    }

    public void setFragment(Fragment fragment, boolean add) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        String fragmentName = fragment.getClass().getName();

        transaction.replace(R.id.container, fragment, fragmentName);
        if(add) {
            transaction.addToBackStack(fragmentName);
        }
        transaction.commit();
    }
}
