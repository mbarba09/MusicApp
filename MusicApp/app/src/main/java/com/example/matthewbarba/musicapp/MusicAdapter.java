package com.example.matthewbarba.musicapp;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {
    @Nullable Listener listener;

    public MusicAdapter(Activity context, ArrayList<Music> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)   {
//        check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // bind the view to item position
        bindViewToPosition(listItemView, position);

        // set view tag
        listItemView.setTag(position);

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    int position = (int) view.getTag();
                    Music music = getItem(position);
                    listener.onItemClicked(music);
                }
            }
        });

//        return the whole list item layout(3 TextViews and 1 ImageView)
//        so that it can be shown in the ListView
        return listItemView;
    }

    // AVS
    public void setItemClickListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    // AVS
    private void bindViewToPosition(View listItemView, int position) {
        Music music = getItem(position);

        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.list_song_name);
        songNameTextView.setText(music.getSongName());

        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.list_album_artist);
        artistNameTextView.setText(music.getArtistName());

        ImageView albumArtImageView = (ImageView) listItemView.findViewById(R.id.list_image);
        albumArtImageView.setImageResource(music.getAlbumArt());

        TextView listNumberTextView = (TextView) listItemView.findViewById(R.id.list_number);
        listNumberTextView.setText(String.valueOf(position + 1));
    }

    // AVS
    interface Listener {
        void onItemClicked(Music music);
    }
}

