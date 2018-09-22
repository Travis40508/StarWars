package com.elkcreek.rodneytressler.starwars.di;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.elkcreek.rodneytressler.starwars.di.modules.ApplicationModule;
import com.elkcreek.rodneytressler.starwars.di.modules.CacheModule;
import com.elkcreek.rodneytressler.starwars.di.modules.DomainModule;
import com.elkcreek.rodneytressler.starwars.di.modules.NetworkModule;
import com.elkcreek.rodneytressler.starwars.utils.Constants;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class StarWarsApplication extends Application implements HasSupportFragmentInjector {

    @Inject protected DispatchingAndroidInjector<Fragment> supportFragmentInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(Constants.STAR_WARS_URL))
                .domainModule(new DomainModule())
                .cacheModule(new CacheModule())
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return supportFragmentInjector;
    }
}
