package com.elkcreek.rodneytressler.starwars.repo.cache;

import com.elkcreek.rodneytressler.starwars.repo.database.DatabaseService;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CacheServiceImpl implements CacheService {

    private final StarWarsService network;
    private final DatabaseService database;

    public CacheServiceImpl(StarWarsService network, DatabaseService database) {
        this.network = network;
        this.database = database;
    }

    @Override
    public Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharacters() {
        return database.getStarWarsCharacters()
                .flatMap(starWarsCharacters -> starWarsCharacters.get(0) == null ? Observable.error(Throwable::new) : Observable.just(starWarsCharacters))
                .onErrorResumeNext(Observable.empty())
                .switchIfEmpty(getStarWarsCharactersFromNetwork()
                .map(StarWarsApi.StarWarsResponse::getStarWarsCharactersList))
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<StarWarsApi.StarWarsCharacter>> getStarWarsCharactersFromDatabase() {
        return database.getStarWarsCharacters();
    }

    @Override
    public Observable<StarWarsApi.StarWarsResponse> getStarWarsCharactersFromNetwork() {
        return network.getStarWarsCharacters()
                .doOnNext(database::insertStarWarsCharacters);
    }
}
