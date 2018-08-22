package com.example.matthewbarba.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PodcastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //create an arrayList of words
        ArrayList<Music> songs = new ArrayList<Music>();
//        Music.add(new Word("song name", "artist name", int imageResource));
        songs.add(new Music("The H3 Podcast", "Eithan Klien", R.drawable.h3h3));
        songs.add(new Music("The RFK Tapes", "CrimeTown Presents", R.drawable.rfk));
        songs.add(new Music("NPR Politics Podcast", "NPR", R.drawable.npr));
        songs.add(new Music("And That's Why We Drink", "And That's Why We Drink", R.drawable.atwwd));
        songs.add(new Music("The Joe Rogan Experience", "Joe Rogan", R.drawable.joe));
        songs.add(new Music("Stuff You Should Know", "how Stuff Works", R.drawable.stuffyoushouldknow));

        MusicAdapter adapter = new MusicAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.music_list);

        // AVS
        adapter.setItemClickListener(new MusicAdapter.Listener() {
            @Override
            public void onItemClicked(Music music) {
                startActivity(PlayingActivity.createIntent(PodcastActivity.this, music));
            }
        });


        listView.setAdapter(adapter);
    }

}
