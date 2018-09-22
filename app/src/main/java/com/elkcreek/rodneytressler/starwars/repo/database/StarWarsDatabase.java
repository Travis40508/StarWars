package com.elkcreek.rodneytressler.starwars.repo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;

@TypeConverters(StarWarsTypeConverters.class)
@Database(version = 1, entities = {StarWarsApi.StarWarsResponse.class, StarWarsApi.StarWarsCharacter.class}, exportSchema = false)
public abstract class StarWarsDatabase extends RoomDatabase {
    public abstract StarWarsDAO starWarsDAO();
}
