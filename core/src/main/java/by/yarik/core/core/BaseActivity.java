package by.yarik.core.core;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import by.yarik.core.R;

public class BaseActivity extends AppCompatActivity {

    @LayoutRes
    protected int containerFragmentRes;

    public void setMainFragment(Fragment fragment) {
        setFragment(fragment, false);
    }

    public void setCurrentFragment(Fragment fragment) {
        setFragment(fragment, true);
    }

    @SuppressLint("ResourceType")
    public void setFragment(Fragment fragment, boolean add) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        String fragmentName = fragment.getClass().getName();

        transaction.replace(containerFragmentRes, fragment, fragmentName);
        if(add) {
            transaction.addToBackStack(fragmentName);
        }
        transaction.commit();
    }

    protected void setContainerFragmentRes(int containerFragmentRes) {
        this.containerFragmentRes = containerFragmentRes;
    }
}
