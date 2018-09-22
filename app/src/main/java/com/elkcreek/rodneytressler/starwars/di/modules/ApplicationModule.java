package com.elkcreek.rodneytressler.starwars.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Context providesApplicationContext() {
        return application;
    }
}
