package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Manuel on 3/1/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    int backgroundColor;

    MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

        }
    };

    public WordAdapter(Activity context, ArrayList<Word> words, int gBackgroundColor){
        super(context,0,words);
        backgroundColor = gBackgroundColor;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        //listItemView.setBackgroundColor(R.color.category_numbers);
        Word currentWord = getItem(position);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }
        listItemView.setBackgroundColor(backgroundColor);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        //Button musicButton = (Button) listItemView.findViewById(R.id.music_button);
        return listItemView;
    }
    private void releaseMediaPlayer(MediaPlayer music){
        if(music!=null){
            music.release();
            music = null;
        }
    }
}

