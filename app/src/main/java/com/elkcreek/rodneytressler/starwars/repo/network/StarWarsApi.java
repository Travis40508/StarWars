package com.elkcreek.rodneytressler.starwars.repo.network;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import com.elkcreek.rodneytressler.starwars.repo.database.StarWarsTypeConverters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StarWarsApi {

    @GET("project.json")
    Observable<StarWarsResponse> getStarWarsCharacters();


    @Entity
    public class StarWarsResponse {

        @PrimaryKey(autoGenerate = true)
        private int primaryKey;

        @TypeConverters(StarWarsTypeConverters.class)
        @SerializedName("results")
        @Expose private List<StarWarsCharacter> starWarsCharactersList;

        public List<StarWarsCharacter> getStarWarsCharactersList() {
            return starWarsCharactersList;
        }

        public int getPrimaryKey() {
            return primaryKey;
        }

        public void setPrimaryKey(int primaryKey) {
            this.primaryKey = primaryKey;
        }

        public void setStarWarsCharactersList(List<StarWarsCharacter> starWarsCharactersList) {
            this.starWarsCharactersList = starWarsCharactersList;
        }
    }

    @Entity
    public class StarWarsCharacter implements Parcelable {
        @PrimaryKey(autoGenerate = true)
        private int primaryKey;

        @SerializedName("name")
        @Expose private String name;

        @SerializedName("height")
        @Expose private String height;

        @SerializedName("mass")
        @Expose private String mass;

        @SerializedName("hair_color")
        @Expose private String hairColor;

        @SerializedName("skin_color")
        @Expose private String skinColor;

        @SerializedName("eye_color")
        @Expose private String eyeColor;

        @SerializedName("birth_year")
        @Expose private String birthYear;

        @SerializedName("gender")
        @Expose private String gender;

        @SerializedName("image")
        @Expose private String characterImage;

        public StarWarsCharacter() {

        }

        protected StarWarsCharacter(Parcel in) {
            primaryKey = in.readInt();
            name = in.readString();
            height = in.readString();
            mass = in.readString();
            hairColor = in.readString();
            skinColor = in.readString();
            eyeColor = in.readString();
            birthYear = in.readString();
            gender = in.readString();
            characterImage = in.readString();
        }

        public static final Creator<StarWarsCharacter> CREATOR = new Creator<StarWarsCharacter>() {
            @Override
            public StarWarsCharacter createFromParcel(Parcel in) {
                return new StarWarsCharacter(in);
            }

            @Override
            public StarWarsCharacter[] newArray(int size) {
                return new StarWarsCharacter[size];
            }
        };

        public int getPrimaryKey() {
            return primaryKey;
        }

        public void setPrimaryKey(int primaryKey) {
            this.primaryKey = primaryKey;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getMass() {
            return mass;
        }

        public void setMass(String mass) {
            this.mass = mass;
        }

        public String getHairColor() {
            return hairColor;
        }

        public void setHairColor(String hairColor) {
            this.hairColor = hairColor;
        }

        public String getSkinColor() {
            return skinColor;
        }

        public void setSkinColor(String skinColor) {
            this.skinColor = skinColor;
        }

        public String getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
        }

        public String getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(String birthYear) {
            this.birthYear = birthYear;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCharacterImage() {
            return characterImage;
        }

        public void setCharacterImage(String characterImage) {
            this.characterImage = characterImage;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(primaryKey);
            parcel.writeString(name);
            parcel.writeString(height);
            parcel.writeString(mass);
            parcel.writeString(hairColor);
            parcel.writeString(skinColor);
            parcel.writeString(eyeColor);
            parcel.writeString(birthYear);
            parcel.writeString(gender);
            parcel.writeString(characterImage);
        }
    }
}
