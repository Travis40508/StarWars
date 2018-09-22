package com.elkcreek.rodneytressler.starwars.repo.network;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class StarWarsServiceImpl implements StarWarsService {

    private final StarWarsApi starWarsApi;

    public StarWarsServiceImpl(StarWarsApi starWarsApi) {
        this.starWarsApi = starWarsApi;
    }

    @Override
    public Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharacter() {
        return starWarsApi.getStarWarsCharacters()
                .subscribeOn(Schedulers.io())
                .map(StarWarsApi.StarWarsResponse::getStarWarsCharactersList);
    }
}
