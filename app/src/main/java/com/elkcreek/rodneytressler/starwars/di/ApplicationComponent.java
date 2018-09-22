package com.elkcreek.rodneytressler.starwars.di;

import com.elkcreek.rodneytressler.starwars.di.modules.ApplicationModule;
import com.elkcreek.rodneytressler.starwars.di.modules.CacheModule;
import com.elkcreek.rodneytressler.starwars.di.modules.DomainModule;
import com.elkcreek.rodneytressler.starwars.di.modules.NetworkModule;
import com.elkcreek.rodneytressler.starwars.di.modules.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, CacheModule.class, DomainModule.class, NetworkModule.class, ViewModule.class})
public interface ApplicationComponent {
    void inject(StarWarsApplication starWarsApplication);
}
