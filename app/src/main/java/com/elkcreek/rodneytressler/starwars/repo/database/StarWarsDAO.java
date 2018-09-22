package com.elkcreek.rodneytressler.starwars.repo.database;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;

import java.util.List;

import io.reactivex.Flowable;

public interface StarWarsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCharacters(StarWarsApi.StarWarsResponse starWarsResponse);

    @Query("SELECT * FROM StarWarsResponse")
    Flowable<List<StarWarsApi.StarWarsResponse>> getStarWarsCharacters();
}
