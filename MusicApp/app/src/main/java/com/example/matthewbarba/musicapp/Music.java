package com.example.matthewbarba.musicapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {
    private final String song;
    private final String artist;
    private final int album;

    public Music(String songName, String artistName, int albumArt) {
        this.song = songName;
        artist = artistName;
        album = albumArt;
    }

    public String getSongName() {
        return song;
    }
    public String getArtistName() {
        return artist;
    }
    public int getAlbumArt() {
        return album;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(song);
        parcel.writeString(artist);
        parcel.writeInt(album);
    }

    public static final Parcelable.Creator<Music> CREATOR = new Parcelable.Creator<Music>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Music createFromParcel(Parcel in) {
            return fromParcel(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    private static Music fromParcel(Parcel in) {
        return new Music(in.readString(), in.readString(), in.readInt());
    }
}