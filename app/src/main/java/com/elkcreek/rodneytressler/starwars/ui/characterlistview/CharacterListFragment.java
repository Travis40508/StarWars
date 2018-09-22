package com.elkcreek.rodneytressler.starwars.ui.characterlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.elkcreek.rodneytressler.starwars.R;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.elkcreek.rodneytressler.starwars.ui.characterview.CharacterFragment;
import com.elkcreek.rodneytressler.starwars.utils.CharacterListAdapter;
import com.elkcreek.rodneytressler.starwars.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class CharacterListFragment extends Fragment implements CharacterListView {

    @Inject CharacterListPresenter presenter;
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;
    private CharacterListAdapter adapter;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        return view;
    }

    public static CharacterListFragment newInstance() {

        Bundle args = new Bundle();

        CharacterListFragment fragment = new CharacterListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void showStarWarsCharacterList(List<StarWarsApi.StarWarsCharacter> starWarsCharacters) {
        adapter = new CharacterListAdapter(Glide.with(this), starWarsCharacters);
        adapter.setCallback(new CharacterListAdapter.CharacterAdapterCallback() {
            @Override
            public void characterClicked(StarWarsApi.StarWarsCharacter character) {
                goToCharacterScreen(character);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    private void goToCharacterScreen(StarWarsApi.StarWarsCharacter character) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.CHARACTER_TAG, character);
        Fragment characterFragment = CharacterFragment.newInstance();
        characterFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, characterFragment, Constants.CHARACTER_FRAGMENT_TAG).addToBackStack(null).commit();
    }
}
