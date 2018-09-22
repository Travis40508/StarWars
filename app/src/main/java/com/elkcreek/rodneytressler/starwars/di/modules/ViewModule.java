package com.elkcreek.rodneytressler.starwars.di.modules;

import com.elkcreek.rodneytressler.starwars.ui.characterlistview.CharacterListFragment;
import com.elkcreek.rodneytressler.starwars.ui.characterview.CharacterFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ViewModule {

    @ContributesAndroidInjector
    abstract CharacterListFragment contributesCharacterListFragmentInjector();

    @ContributesAndroidInjector
    abstract CharacterFragment contributesCharacterFragmentInjector();
}
