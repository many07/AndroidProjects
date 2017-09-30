package com.example.android.elboton;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean reproduccion = false;
    MediaPlayer sound;
    AudioManager audioManager;
    AudioManager.OnAudioFocusChangeListener audioFocusChanger =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                            || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                        sound.pause();
                        sound.seekTo(0);
                        reproduccion = false;
                    }else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                        sound.start();
                        reproduccion = true;
                    }else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                        sound.stop();
                        reproduccion = false;
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);




    }
    public void turnDownForWhat(View view){
        if (reproduccion){
            sound.stop();
            reproduccion = false;
        }
    }


    public void johnCena(View view){
        if (reproduccion){
            releaseMediaPlayer();
        }else{
            playSound(R.raw.johncena);
        }
    }
    public void violin(View view){
        if (reproduccion){
            releaseMediaPlayer();
        }else{
            playSound(R.raw.violindc);
        }

    }
    public void desorden(View view){
        if (reproduccion){
            releaseMediaPlayer();
        }else{
            playSound(R.raw.desorden);
        }
    }
    public void wombocombo(View view){
        if (reproduccion){
            releaseMediaPlayer();
        }
    }
    public void harry(View view){
        if (reproduccion){
            releaseMediaPlayer();
        }
    }
    private void releaseMediaPlayer(){
        if(sound!=null){
            sound.release();
            sound = null;
            audioManager.abandonAudioFocus(audioFocusChanger);
            reproduccion = false;
        }
    }
    private void playSound(int musicPath){
        int result = audioManager.requestAudioFocus(audioFocusChanger, AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
            sound = MediaPlayer.create(MainActivity.this, musicPath);
            sound.start();
            reproduccion = true;
            sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    releaseMediaPlayer();
                }
            });
        }
    }
}
