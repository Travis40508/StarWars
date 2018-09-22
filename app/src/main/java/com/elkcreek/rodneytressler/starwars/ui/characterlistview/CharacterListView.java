package com.elkcreek.rodneytressler.starwars.ui.characterlistview;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.ui.baseview.BaseView;

import java.util.List;

public interface CharacterListView extends BaseView {
    void showStarWarsCharacterList(List<StarWarsApi.StarWarsCharacter> starWarsCharacters);
}
