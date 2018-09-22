package com.elkcreek.rodneytressler.starwars.repo.network;

import java.util.List;

import io.reactivex.Observable;

public interface StarWarsService {

    Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharacter();
}
