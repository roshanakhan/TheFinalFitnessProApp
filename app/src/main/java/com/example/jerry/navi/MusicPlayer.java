package com.example.jerry.navi;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jerry.navi.R;
import com.example.jerry.navi.Spotify;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MusicPlayer extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private EditText edittext;
    private SeekBar seekbar;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private boolean iffirst = false;
    private boolean isChanging = false;
    private TextView musicname;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);
        initView();



    }

    private void initView() {
        Button play = findViewById(R.id.btn_play);
        Button pause = findViewById(R.id.btn_pause);
        Button search = findViewById(R.id.btn_search);
        Button stop = findViewById(R.id.btn_stop);
        edittext = (EditText) findViewById(R.id.et1);
        Button spotify = findViewById(R.id.btn_spotify);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) new MySeekbar());
        musicname = findViewById(R.id.music_name);




        //web player
        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer != null){
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                    }
                }
                Intent intent = new Intent(MusicPlayer.this, Spotify.class);
                startActivity(intent);
            }
        });



        //search
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0 )
                    Toast.makeText(MusicPlayer.this, "please type something", Toast.LENGTH_SHORT).show();


                else if ("android".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music android found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.android);
                    mediaPlayer.getDuration();
                    musicname.setText("Music name: android");
                }
                else if ("fade".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music fade found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.daybreak);
                    musicname.setText("Music name: fade");
                }
                else if ("daybreak".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music daybreak found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.daybreak);
                    musicname.setText("Music name: daybreak");
                }
                else if ("higher".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music higher found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.higher);
                    musicname.setText("Music name: higher");
                }
                else if ("intro".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music intro found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.intro);
                    musicname.setText("Music name: intro");
                }
                else if ("life".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music life found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.life);
                    musicname.setText("Music name: life");
                }
                else if ("pdd".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music pdd found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.pdd);
                    musicname.setText("Music name: pdd");
                }
                else if ("shadows".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music shadows found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.shadows);
                    musicname.setText("Music name: shadows");
                }
                else if ("spectre".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music spectre", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.spectre);
                    musicname.setText("Music name: spectre");
                }
                else if ("trip".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music trip found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.trip);
                    musicname.setText("Music name: trip");
                }
                else if ("windfall".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music windfall", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.windfall);
                    musicname.setText("Music name: windfall");
                }
                else
                    Toast.makeText(MusicPlayer.this, "music not found, please search on Spotify", Toast.LENGTH_SHORT).show();

            }
        });


        //play
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0)
                    Toast.makeText(MusicPlayer.this, "please type something", Toast.LENGTH_SHORT).show();
                else { try {
                    mediaPlayer.prepare();
                } catch (IllegalStateException e) {

                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    seekbar.setMax(mediaPlayer.getDuration());//set the seek bar
                    // set the play time    //
                    mTimer = new Timer();
                    mTimerTask = new TimerTask() {
                        @Override
                        public void run() {
                            if(isChanging) {
                                return;
                            }
                            seekbar.setProgress(mediaPlayer.getCurrentPosition());
                        }
                    };
                    mTimer.schedule(mTimerTask, 0, 10);
                    iffirst=true;
                }
                mediaPlayer.start();
            }

        });

        //pause
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0)
                    Toast.makeText(MusicPlayer.this, "please type something", Toast.LENGTH_SHORT).show();
                else mediaPlayer.pause();
            }
        });

        //stop
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0)
                    Toast.makeText(MusicPlayer.this, "please play a music", Toast.LENGTH_SHORT).show();
                else mediaPlayer.stop();
            }
        });
    }
    class MySeekbar implements SeekBar.OnSeekBarChangeListener {
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            isChanging=true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            mediaPlayer.seekTo(seekbar.getProgress());
            isChanging=false;
        }

    }


    //handle
    protected void onDestroy() {
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            mediaPlayer.release();
        }
        super.onDestroy();
    }

    protected void onPause() {
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        super.onPause();
    }

    protected void onResume() {
        if(mediaPlayer != null){
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }
        }
        super.onResume();
    }
}
