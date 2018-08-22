package com.example.matthewbarba.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //create an arrayList of words
        final ArrayList<Music> songs = new ArrayList<Music>();
//        Music.add(new Word("song name", "artist name", int imageResource));
        songs.add(new Music("Nice For What", "Drake", R.drawable.drake));
        songs.add(new Music("Psycho", "Post Malone ft. Ty Dolla $ign", R.drawable.post_malone));
        songs.add(new Music("I Like It", "Cardi B, Bad Bunny & J Balvin", R.drawable.cardi_b));
        songs.add(new Music("God's Plan", "Drake", R.drawable.drake));
        songs.add(new Music("Girls Like You", "Maroon 5 ft. Cardi B", R.drawable.maroon_five));
        songs.add(new Music("Lucid Dreams", "Juice WRLD", R.drawable.juice));
        songs.add(new Music("Boo'd Up", "Ella Mai", R.drawable.ella_mai));
        songs.add(new Music("The Middle", "Zedd, Maren Morris & Grey", R.drawable.zedd));
        songs.add(new Music("No Tears Left To Cry", "Ariana Grande", R.drawable.ariana_grande));
        songs.add(new Music("Meant To Be", "Bebe Rexha & Florida Georgia Line", R.drawable.bebe));

        MusicAdapter adapter = new MusicAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.music_list);

        // AVS
        adapter.setItemClickListener(new MusicAdapter.Listener() {
            @Override
            public void onItemClicked(Music music) {
                startActivity(PlayingActivity.createIntent(MusicActivity.this, music));
            }
        });


        listView.setAdapter(adapter);

    }

}
