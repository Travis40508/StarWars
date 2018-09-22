package com.elkcreek.rodneytressler.starwars.ui.characterview;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.ui.baseview.BaseView;

public interface CharacterView extends BaseView {
    void displayCharacter(StarWarsApi.StarWarsCharacter character);
}
