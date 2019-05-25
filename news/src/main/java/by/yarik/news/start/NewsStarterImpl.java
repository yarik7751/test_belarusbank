package by.yarik.news.start;

import android.support.v4.app.Fragment;

import javax.inject.Inject;

import by.yarik.news.presentation.news.view.NewsFragment;
import by.yarik.news_api.INewsStarter;

public class NewsStarterImpl implements INewsStarter {

    @Inject
    public NewsStarterImpl() {
    }

    @Override
    public Fragment getScreen() {
        return NewsFragment.newInstance();
    }
}
