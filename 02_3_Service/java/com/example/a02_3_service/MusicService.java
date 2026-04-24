package com.example.a02_3_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    MediaPlayer mp;

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.music);
        mp.setLooping(true);
    }

    public int onStartCommand(Intent i, int flag, int startID) {
        mp.start();
        return START_STICKY;
    }

    public void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }

    public IBinder onBind(Intent i) {
        return null;
    }
}
