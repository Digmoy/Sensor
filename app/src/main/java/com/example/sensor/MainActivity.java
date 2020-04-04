package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    GestureDetector gestureDetector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(getApplicationContext(), LockService.class));

        gestureDetector = new GestureDetector(MainActivity.this, MainActivity.this);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation

        Log.e("vndsjkbvkj","xbdfb");
        return super.onTouchEvent(event);


    }

    @Override
    public boolean onDown(MotionEvent event) {

        Log.e("vndsjkbvkj","xbdfb");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.e("vndsjkbvkj","xbdfb");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.e("vndsjkbvkj","xbdfb");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.e("vndsjkbvkj","xbdfb");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.e("vndsjkbvkj","xbdfb");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.e("vndsjkbvkj","xbdfb");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {

        Toast.makeText(MainActivity.this, "Double Tap on Screen is Working.", Toast.LENGTH_LONG).show();
        Intent MyIntentService = new Intent(MainActivity.this, BackgroundSoundService.class);
        startService(MyIntentService);

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Intent MyIntentService = new Intent(MainActivity.this, BackgroundSoundService.class);
        stopService(MyIntentService);
        return false;
    }

}
