package com.elkcreek.rodneytressler.starwars.repo.database;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DatabaseServiceImpl implements DatabaseService {

    private final StarWarsDatabase database;

    public DatabaseServiceImpl(StarWarsDatabase database) {
        this.database = database;
    }

    @Override
    public void insertStarWarsCharacters(StarWarsApi.StarWarsResponse starWarsResponse) {
        Schedulers.io().scheduleDirect(new Runnable() {
            @Override
            public void run() {
                database.starWarsDAO().insertCharacters(starWarsResponse);
            }
        });
    }

    @Override
    public Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharacters() {
        return database.starWarsDAO().getStarWarsCharacters()
                .subscribeOn(Schedulers.io()).toObservable()
                .map(responses -> responses.get(0))
                .map(StarWarsApi.StarWarsResponse::getStarWarsCharactersList);
    }
}
