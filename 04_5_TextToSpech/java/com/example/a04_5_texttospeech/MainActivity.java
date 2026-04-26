package com.example.a04_5_texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText et;
    SeekBar sks, skp;
    TextView tvs, tvp;
    float speed=0.1f, pitch=0.1f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        tvs = findViewById(R.id.tvSpeed);
        tvp = findViewById(R.id.tvPitch);
        sks = findViewById(R.id.sbSpeed);
        skp = findViewById(R.id.sbPitch);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != -1) {
                    tts.setLanguage(Locale.CANADA);
                }
            }
        });
        sks.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar sk, int s, boolean fUser) {
                speed = s / 10.0f;
                if (speed < 1.0f)
                    speed = 1.0f;
                tvs.setText("Speed " + speed);
            }

            public void onStartTrackingTouch(SeekBar sk) {
            }

            public void onStopTrackingTouch(SeekBar sk) {
            }
        });
        skp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar s, int p, boolean fUser) {
                pitch = p / 10.0f;
                if (pitch < 1.0f)
                    pitch = 1.0f;
                tvp.setText("Pitch " + pitch);
            }

            public void onStartTrackingTouch(SeekBar sk) {
            }

            public void onStopTrackingTouch(SeekBar sk) {
            }
        });
    }
    public void start(View v) {
        String t = et.getText().toString();
        tts.setPitch(pitch);
        tts.setSpeechRate(speed);
        tts.speak(t, TextToSpeech.QUEUE_FLUSH, null, null);
    }
    public void onPause() {
        if(tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}