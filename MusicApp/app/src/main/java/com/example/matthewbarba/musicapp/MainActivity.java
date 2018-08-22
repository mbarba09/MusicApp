package com.example.matthewbarba.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the views that show the other categories (music, playlists, podcasts)
        TextView myMusic = (TextView) findViewById(R.id.my_music);
        TextView myPlaylist = (TextView) findViewById(R.id.playlists);
        TextView myPodcast = (TextView) findViewById(R.id.podcasts);
        LinearLayout library = (LinearLayout) findViewById(R.id.menu_library);
        LinearLayout playing = (LinearLayout) findViewById(R.id.menu_play);

//        set OnClickListener for the MyMusic text view. Sends the user to their music library
        myMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, MusicActivity.class);
                startActivity(i);
            }
        });

        //        set OnClickListener for the MyPlaylist text view. Sends the user to their playlist library
        myPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(i);
            }
        });

        //        set OnClickListener for the MyPodcast text view. Sends the user to their podcast library
        myPodcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PodcastActivity.class);
                startActivity(i);
            }
        });

        //        set OnClickListener for the library menu button (Linear Layout). Informs the user they are already at the activity
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You are already at your library!", Toast.LENGTH_SHORT).show();
            }
        });

        //        set OnClickListener for the Playing Now menu button(Linear Layout). Sends the user to what is currently playing.
        playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(i);
            }
        });

    }


}
