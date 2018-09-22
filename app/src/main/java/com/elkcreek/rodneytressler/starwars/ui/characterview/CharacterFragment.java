package com.elkcreek.rodneytressler.starwars.ui.characterview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.elkcreek.rodneytressler.starwars.R;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.utils.Constants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class CharacterFragment extends Fragment implements CharacterView {

    @Inject protected CharacterPresenter presenter;
    @BindView(R.id.character_image)
    protected ImageView characterImage;
    @BindView(R.id.character_name)
    protected TextView characterName;
    @BindView(R.id.birth_year)
    protected TextView birthYear;
    @BindView(R.id.gender)
    protected TextView gender;
    @BindView(R.id.height)
    protected TextView height;
    @BindView(R.id.mass)
    protected TextView mass;
    @BindView(R.id.eye_color)
    protected TextView eyeColor;
    @BindView(R.id.hair_color)
    protected TextView hairColor;
    @BindView(R.id.skin_color)
    protected TextView skinColor;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        return view;
    }


    public static CharacterFragment newInstance() {

        Bundle args = new Bundle();

        CharacterFragment fragment = new CharacterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
        presenter.characterRetrieved((StarWarsApi.StarWarsCharacter) getArguments().getParcelable(Constants.CHARACTER_TAG));
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void displayCharacter(StarWarsApi.StarWarsCharacter character) {
        Glide.with(this).setDefaultRequestOptions(RequestOptions.overrideOf(250, 200))
                .load(character.getCharacterImage()).into(characterImage);

        characterName.setText(character.getName());
        birthYear.setText(character.getBirthYear());
        gender.setText(character.getGender());
        height.setText(character.getHeight());
        mass.setText(character.getMass());
        eyeColor.setText(character.getEyeColor());
        hairColor.setText(character.getHairColor());
        skinColor.setText(character.getSkinColor());
    }
}
