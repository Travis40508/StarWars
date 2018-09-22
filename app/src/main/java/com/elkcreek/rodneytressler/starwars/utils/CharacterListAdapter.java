package com.elkcreek.rodneytressler.starwars.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.elkcreek.rodneytressler.starwars.R;
import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder> {

    private final RequestManager glide;
    private List<StarWarsApi.StarWarsCharacter> starWarsCharacters;
    private CharacterAdapterCallback callback;

    public CharacterListAdapter(RequestManager glide, List<StarWarsApi.StarWarsCharacter> starWarsCharacters) {
        this.starWarsCharacters = starWarsCharacters;
        this.glide = glide;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_character, viewGroup, false);
        return new CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder characterViewHolder, int position) {
        characterViewHolder.bindCharacter(starWarsCharacters.get(position));
        characterViewHolder.itemView.setOnClickListener(characterViewHolder.onCharacterClicked(starWarsCharacters.get(position)));
    }

    @Override
    public int getItemCount() {
        return starWarsCharacters.size();
    }

    public void setCallback(CharacterAdapterCallback callback) {
        this.callback = callback;
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_name)
        protected TextView characterName;

        @BindView(R.id.item_image)
        protected ImageView characterImage;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindCharacter(StarWarsApi.StarWarsCharacter starWarsCharacter) {
            characterName.setText(starWarsCharacter.getName());
            glide
                    .setDefaultRequestOptions(RequestOptions.overrideOf(80, 80))
                    .load(starWarsCharacter.getCharacterImage())
                    .into(characterImage);
        }

        public View.OnClickListener onCharacterClicked(StarWarsApi.StarWarsCharacter starWarsCharacter) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callback.characterClicked(starWarsCharacter);
                }
            };
        }
    }

    public interface CharacterAdapterCallback {
        void characterClicked(StarWarsApi.StarWarsCharacter character);
    }
}
