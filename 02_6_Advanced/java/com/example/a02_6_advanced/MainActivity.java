package com.example.a02_6_advanced;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb; int progress = 0;
    Handler handlerm;

    SeekBar sb; MediaPlayer mp; Handler handlert;
    RatingBar rb; TextView rbtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView w = findViewById(R.id.web);
        w.setWebViewClient(new WebViewClient());
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl("https://www.google.com");

        pb = findViewById(R.id.pb);
        handlerm = new Handler();

        sb = findViewById(R.id.sb);
        handlert = new Handler();
        mp = MediaPlayer.create(this, R.raw.music);
        sb.setMax(mp.getDuration());
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int progress, boolean fromUser) {
                if (fromUser) mp.seekTo(progress);
            }
            public void onStartTrackingTouch(SeekBar s) {}
            public void onStopTrackingTouch(SeekBar s) {}
        });

        rb = findViewById(R.id.rb);
        rbtv = findViewById(R.id.rbtv);
    }
    public void startt(View v) {
        progress = 0;
        pb.setMax(5);
        pb.setProgress(0);
        handlert.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (progress < 5) {
                    progress++;
                    pb.setProgress(progress);
                    handlert.postDelayed(this, 1000); // every 1 sec
                }
            }
        }, 1000);
    }

    public void startm(View v) {
        mp.start();
        handlerm.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mp != null && mp.isPlaying()) {
                    sb.setProgress(mp.getCurrentPosition());
                    handlerm.postDelayed(this, 500);
                }
            }
        }, 0);
    }

    public void getrating(View v) {
        float rating = rb.getRating();
        rbtv.setText("RatingBar Rating=" + String.valueOf(rating));
    }
}