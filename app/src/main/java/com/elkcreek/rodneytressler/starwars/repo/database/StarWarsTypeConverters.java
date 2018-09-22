package com.elkcreek.rodneytressler.starwars.repo.database;

import android.arch.persistence.room.TypeConverter;

import com.elkcreek.rodneytressler.starwars.repo.network.StarWarsApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class StarWarsTypeConverters {
    @TypeConverter
    public String fromStarWarsCharacterList(List<StarWarsApi.StarWarsCharacter> starWarsCharacterList) {
        if (starWarsCharacterList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<StarWarsApi.StarWarsCharacter>>() {
        }.getType();
        String json = gson.toJson(starWarsCharacterList, type);
        return json;
    }

    @TypeConverter
    public List<StarWarsApi.StarWarsCharacter> toStarWarsCharacterList(String starWarsCharacterString) {
        if (starWarsCharacterString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<StarWarsApi.StarWarsCharacter>>() {
        }.getType();
        List<StarWarsApi.StarWarsCharacter> starWarsCharacterList = gson.fromJson(starWarsCharacterString, type);
        return starWarsCharacterList;
    }
}
