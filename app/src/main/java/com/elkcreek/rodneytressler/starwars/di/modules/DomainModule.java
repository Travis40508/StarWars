package com.elkcreek.rodneytressler.starwars.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.elkcreek.rodneytressler.starwars.repo.database.DatabaseService;
import com.elkcreek.rodneytressler.starwars.repo.database.DatabaseServiceImpl;
import com.elkcreek.rodneytressler.starwars.repo.database.StarWarsDatabase;
import com.elkcreek.rodneytressler.starwars.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {

    @Provides
    @Singleton
    StarWarsDatabase providesStarWarsDatabase(Context context) {
        StarWarsDatabase database = Room.databaseBuilder
                (context, StarWarsDatabase.class, Constants.DATABASE_KEY)
                .build();

        return database;
    }

    @Provides
    DatabaseService providesDatabaseService(StarWarsDatabase database) {
        return new DatabaseServiceImpl(database);
    }
}
