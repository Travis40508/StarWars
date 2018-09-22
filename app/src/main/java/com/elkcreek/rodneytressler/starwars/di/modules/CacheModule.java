package com.elkcreek.rodneytressler.starwars.di.modules;

import com.elkcreek.rodneytressler.starwars.repo.cache.CacheService;
import com.elkcreek.rodneytressler.starwars.repo.cache.CacheServiceImpl;
import com.elkcreek.rodneytressler.starwars.repo.database.DatabaseService;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsService;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {

    @Provides
    CacheService providesCacheService(StarWarsService service, DatabaseService database) {
        return new CacheServiceImpl(service, database);
    }
}
