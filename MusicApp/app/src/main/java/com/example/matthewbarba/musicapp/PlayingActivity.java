package com.example.matthewbarba.musicapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayingActivity extends AppCompatActivity {

 // create int heart for if/else statement to check the state of the icon
    public int heart = 0;

//    create in play for if/else statement to check the state of the icon
    public int play = 0;

    // AVS
    private static final String TAG = "PlayingActivity";

    // AVS
    public static Intent createIntent(Context context, @Nullable Music music) {
        Intent intent = new Intent(context, PlayingActivity.class);
        if (music != null) {
            intent.putExtra(TAG, music);
        }

        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        //        Find all views in now_playing.xml
        ImageView downArrow = findViewById(R.id.play_down_arrow);
        ImageView albumArt = findViewById(R.id.play_album_image_view);
        TextView songName = findViewById(R.id.play_song_name_text_view);
        TextView artistName = findViewById(R.id.play_artist_text_view);
//        views for icons in playbar
        final ImageView heartIcon = findViewById(R.id.play_like_icon);
        ImageView backIcon = findViewById(R.id.play_back_icon);
        final ImageView playButton = findViewById(R.id.play_play_icon);
        ImageView forwardButton = findViewById(R.id.play_forward_icon);
        ImageView deleteButton = findViewById(R.id.play_x_icon);
//        views for menu buttons
        LinearLayout library = (LinearLayout) findViewById(R.id.menu_library);
        LinearLayout playing = (LinearLayout) findViewById(R.id.menu_play);

        // AVS
        Intent intent = getIntent();
        Music music = intent.getParcelableExtra(TAG);
        // TODO check for music == null and use the music instance

//        if (music == null)  {
//            String song = getIntent().getParcelableExtra("song");
//            String artist = getIntent().getParcelableExtra("artist");
//            Integer album = getIntent().getParcelableExtra("album");
//
//            //        set data from music array
//            songName.setText(song);
//            artistName.setText(artist);
//            albumArt.setImageResource(album);
//
//        }

//        set down arrow to take user back to main activity
        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                create intent to send user to main activity
                Intent i = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

//        Playbar onClick listeners for buttons
//        Change appearance of buttons
//        toggle heart icon between filled and empty with each user click
        heartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (heart == 1) {
//                    if heart = 1; set the image to a filled heart. change value of heart to 0
                    heartIcon.setImageResource(R.drawable.ic_favorite_black_24dp);
                    heart = 0;
                } else {
//                    if heart = 0; set the image to a empty heart. change value of heart to 1
                    heartIcon.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    heart = 1;
                }
            }
        });

//        toggle play icon between play and pause with each user click
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play == 1)  {
//                    if play = 1; set the play button to a pause button. change value of play to 0
                    playButton.setImageResource(R.drawable.ic_pause_circle_outline_black_24dp);
                    play = 0;
                } else  {
//                    if play = 0; set the pause button to a play button. change the value of play to 1
                    playButton.setImageResource(R.drawable.ic_play_circle_outline_black_24dp);
                    play = 1;
                }
            }
        });




//        Menu OnClick Listeners
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        playing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayingActivity.this, "You are already looking at what is playing!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
