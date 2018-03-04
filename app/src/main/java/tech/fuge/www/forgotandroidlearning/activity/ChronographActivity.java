package tech.fuge.www.forgotandroidlearning.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import tech.fuge.www.forgotandroidlearning.R;

public class ChronographActivity extends AppCompatActivity {
    TextView timeTv;
    private int seconds = 0;
    private boolean running;
private boolean wasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronograph);
        timeTv = (TextView) findViewById(R.id.tv_chromograph);
        runTimer();
        if (savedInstanceState!=null){
            seconds=savedInstanceState.getInt("curSecond");
            running=savedInstanceState.getBoolean("curRun");
            wasRunning=savedInstanceState.getBoolean("wasRunning");
        }
        findViewById(R.id.btn_start).setOnClickListener(v -> running = true);
        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                timeTv.setText("00:00:00");
                running = false;
                seconds = 0;
            }
        });


    }

    private void runTimer() {
        final Handler handler =new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeTv.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("curSecond",seconds);
        outState.putBoolean("curRun",running);
        outState.putBoolean("wasRunning",wasRunning);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /*写法不对*/
//    private void runTimer() {
//        final Handler handler =new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                int hours = seconds / 3600;
//                int minutes = (seconds % 3600) / 60;
//                int secs = seconds % 60;
//                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
//                timeTv.setText(time);
//                if (running) {
//                    seconds++;
//                }
//                handler.post(this);
//            }
//        },1000);
//
//    }


    @Override
    protected void onStart() {
        super.onStart();
        if (wasRunning){
            running=true;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning){
            running=true;
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        wasRunning=running;
        running=false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        wasRunning=running;
        running=false;
    }
}
