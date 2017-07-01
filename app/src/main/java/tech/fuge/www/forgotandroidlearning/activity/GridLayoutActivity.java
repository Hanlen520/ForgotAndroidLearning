package tech.fuge.www.forgotandroidlearning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import tech.fuge.www.forgotandroidlearning.R;

public class GridLayoutActivity extends AppCompatActivity {
Button btnSend;
    EditText etMail;
    EditText etMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        btnSend = (Button) findViewById(R.id.btn_send);
        etMail = (EditText) findViewById(R.id.et_email);
        etMessage= (EditText) findViewById(R.id.et_message);
        System.out.println(btnSend.getId());
        System.out.println(etMessage.getHeight());
        System.out.println(etMessage.getWidth());
        if(etMail.isClickable()){
            System.out.println("etMail可点击");
        }
    }
}
