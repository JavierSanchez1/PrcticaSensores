package com.example.javiersanchez.prcticasensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager;
    MediaPlayer mediaPlayer;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        mediaPlayer=MediaPlayer.create(this,R.raw.cancion);
        mediaPlayer.start();

    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float x, y, z;
            String c1,c2,c3;
            x=event.values[0];
            c1=""+x;
            y=event.values[1];
            c2=""+y;
            z=event.values[2];
            c3=""+y;
            textView4.setText(c1);
            textView5.setText(c2);
            textView6.setText(c3);
            if (z<-5){
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            } else if(z>-5) {
                mediaPlayer.start();
                getWindow().getDecorView().setBackgroundColor(Color.RED);

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    };
    private void sonido(){


    }
}
