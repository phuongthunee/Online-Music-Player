package vn.edu.usth.onlinemusicplayer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar MusicPlayer;
    private TextView title, singer, runtime, totaltime;
    private ImageView like;
    private ImageButton shuffle, previous, pause, next, lap;
    private SeekBar time;
    long duration, currentDuration = 0;
    private boolean repeat = false, checkrandom = false, isplaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
    }
}

