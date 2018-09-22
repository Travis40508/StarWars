package com.elkcreek.rodneytressler.starwars.ui.characterlistview;

import android.util.Log;

import com.elkcreek.rodneytressler.starwars.repo.cache.CacheService;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.ui.baseview.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class CharacterListPresenter implements BasePresenter<CharacterListView> {

    private final CacheService cacheService;
    private CompositeDisposable disposable;
    private CharacterListView view;

    @Inject
    public CharacterListPresenter(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void attachView(CharacterListView view) {
        this.view = view;
    }

    @Override
    public void subscribe() {
        disposable = new CompositeDisposable();
        fetchCharacters();
    }

    private void fetchCharacters() {
        disposable.add(cacheService.getStarWarsCharacters().subscribe(updateUiWithStarWarsCharacters(), updateUiWithError()));
    }

    private Consumer<List<StarWarsApi.StarWarsCharacter>> updateUiWithStarWarsCharacters() {
        return starWarsCharacters -> {
          view.showStarWarsCharacterList(starWarsCharacters);
        };
    }

    private Consumer<Throwable> updateUiWithError() {
        return throwable -> Log.d("@@@@", throwable.getMessage());
    }

    @Override
    public void unsubscribe() {
        disposable.clear();
    }
}
