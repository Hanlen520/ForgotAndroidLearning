package tech.fuge.www.forgotandroidlearning.sample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tech.fuge.www.forgotandroidlearning.R;

/**
 * 实现长时间任务的两种方法，Thread和Handler
 */
public class ThreadSampleActivity extends AppCompatActivity {
    public final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_sample);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(myThreadRunnable).start();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keeeThreadRunning = false;
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.post(myHandlerRunnable);
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHandler.removeCallbacksAndMessages(null);
            }
        });


    }

    private boolean keeeThreadRunning = false;
    private Runnable myThreadRunnable = new Runnable() {
        @Override
        public void run() {
            keeeThreadRunning = true;
            int i = 1;
            while (keeeThreadRunning) {
                System.out.println("thread:" + i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    int j;
    private Handler myHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            switch (msg.what) {
                case 0x01:
                    System.out.println("handler:" + j);
                    j++;
                    break;
                default:
                    break;
            }
        }
    };

    private Runnable myHandlerRunnable = new Runnable() {
        @Override
        public void run() {
            myHandler.sendEmptyMessage(0x01);
            myHandler.postDelayed(this, 1000);
        }
    };
}
