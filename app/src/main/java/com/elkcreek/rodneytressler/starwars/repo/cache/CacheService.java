package com.elkcreek.rodneytressler.starwars.repo.cache;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;

import java.util.List;

import io.reactivex.Observable;

public interface CacheService {
    Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharacters();
    Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharactersFromDatabase();
    Observable<StarWarsApi.StarWarsResponse> getStarWarsCharactersFromNetwork();
}
