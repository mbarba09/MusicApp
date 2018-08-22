package com.example.matthewbarba.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //create an arrayList of words
        ArrayList<Music> songs = new ArrayList<Music>();
//        Music.add(new Word("song name", "artist name", int imageResource));
        songs.add(new Music("As The Sun Goes Down", "OurMountainSound", R.drawable.pl1));
        songs.add(new Music("Vibe with Me", "PfMurphey89", R.drawable.pl2));
        songs.add(new Music("Hyped", "Jodi3", R.drawable.pl3));
        songs.add(new Music("Live Fast, Die Young", "clairebeahr", R.drawable.pl4));
        songs.add(new Music("CoffeeHouse", "SurviveIndie", R.drawable.pl5));
        songs.add(new Music("Get It Done II", "Kate.Nelligan9", R.drawable.pl6));
        songs.add(new Music("Dreams", "SurvivingIndie", R.drawable.pl7));
        songs.add(new Music("Beneath the Covers", "Booksta", R.drawable.pl8));

        MusicAdapter adapter = new MusicAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.music_list);

        // AVS
        adapter.setItemClickListener(new MusicAdapter.Listener() {
            @Override
            public void onItemClicked(Music music) {
                startActivity(PlayingActivity.createIntent(PlaylistActivity.this, music));
            }
        });
        listView.setAdapter(adapter);
    }

}
