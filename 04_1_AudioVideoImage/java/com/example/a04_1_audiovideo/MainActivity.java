package com.example.a04_1_audiovideo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SeekBar sb;
    Handler handler = new Handler();
    Runnable updateSeekBar;
    MediaPlayer mp;
    ImageView iv;
    int img[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    int c = 1;
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.music);
        sb = findViewById(R.id.sb);
        sb.setMax(mp.getDuration());
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) mp.seekTo(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mp != null) {
                    sb.setProgress(mp.getCurrentPosition());
                    handler.postDelayed(this, 500); // update every 0.5 sec
                }
            }
        };
        iv = findViewById(R.id.iv);
        vv = findViewById(R.id.vv);
        Uri u = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        vv.setVideoURI(u);
    }
    public void music(View v) {
        int id = v.getId();
        if(id == R.id.play) {
            if(mp == null) {
                mp = MediaPlayer.create(this, R.raw.music);
            }
            mp.setOnCompletionListener(mp->stopmusic());
            mp.start();
            handler.post(updateSeekBar);
        } else if(id == R.id.pause) {
            if(mp != null) {
                mp.pause();
                handler.removeCallbacks(updateSeekBar);
            }
        } else if(id == R.id.stop) {
            if(mp != null) {
                mp.stop();
                stopmusic();
                sb.setProgress(0);
            }
        }
    }

    private void stopmusic() {
        if (mp != null) {
            mp.release();
            mp = null;
        }
        handler.removeCallbacks(updateSeekBar);
    }
    protected void onStop() {
        super.onStop();
        stopmusic();
    }

    public void image(View v) {
        int id = v.getId();
        if(id == R.id.show) {
            iv.setImageResource(img[c]);
            iv.setVisibility(v.VISIBLE);
        } else if(id == R.id.next) {
            c = (c+1) % img.length;
            iv.setImageResource(img[c]);
            iv.setVisibility(v.VISIBLE);
        } else if(id == R.id.hide) {
            iv.setVisibility(v.GONE);
        }
    }

    public void video(View v) {
        int id = v.getId();
        if(id == R.id.vplay) {
            vv.start();
        } else if(id == R.id.vpause) {
            if(vv.isPlaying()) {
                vv.pause();
            }
        } else if(id == R.id.vstop) {
            vv.stopPlayback();
            Uri u = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
            vv.setVideoURI(u);
        }
    }
}