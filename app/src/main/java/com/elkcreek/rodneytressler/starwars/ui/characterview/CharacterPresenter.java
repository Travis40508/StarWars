package com.elkcreek.rodneytressler.starwars.ui.characterview;

import android.os.Parcelable;
import android.util.Log;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.ui.baseview.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class CharacterPresenter implements BasePresenter<CharacterView>{
    private CharacterView view;
    private CompositeDisposable disposable;

    @Inject CharacterPresenter() {

    }

    @Override
    public void attachView(CharacterView view) {
        this.view = view;
    }

    @Override
    public void subscribe() {
        disposable = new CompositeDisposable();
    }

    @Override
    public void unsubscribe() {
        disposable.clear();
    }

    public void characterRetrieved(StarWarsApi.StarWarsCharacter character) {
        view.displayCharacter(character);
    }
}
