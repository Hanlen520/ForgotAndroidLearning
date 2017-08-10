package tech.fuge.www.forgotandroidlearning.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import tech.fuge.www.forgotandroidlearning.R;
import tech.fuge.www.forgotandroidlearning.activity.MainActivity;

public class ExceptionSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception_sample);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = new FileInputStream("text.txt");
                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
                    Log.e("yichang","发生异常不要紧");
                    Toast.makeText(ExceptionSampleActivity.this, "exception has happen", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
