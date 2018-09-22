package com.elkcreek.rodneytressler.starwars.repo.database;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;

import java.util.List;

import io.reactivex.Observable;

public interface DatabaseService {
    void insertStarWarsCharacters(StarWarsApi.StarWarsResponse starWarsResponse);
    Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharacters();
}
