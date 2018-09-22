package com.elkcreek.rodneytressler.starwars.ui.baseview;

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);
    void subscribe();
    void unsubscribe();
}
