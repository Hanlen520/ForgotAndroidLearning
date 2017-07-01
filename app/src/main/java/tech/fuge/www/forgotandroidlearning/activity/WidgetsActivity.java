package tech.fuge.www.forgotandroidlearning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import tech.fuge.www.forgotandroidlearning.R;

public class WidgetsActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        toggleButton = (ToggleButton) findViewById(R.id.toggle);
        aSwitch = (Switch) findViewById(R.id.switcher);
final CharSequence text = "CharSequence + ";
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = toggleButton.isChecked();
                if (on) {
                    Log.e("toggle", "on");
                    Toast.makeText(WidgetsActivity.this, text+"on", Toast.LENGTH_SHORT).show();

                } else {
                    Log.e("toggle", "off");
                    Toast.makeText(WidgetsActivity.this, text+"off", Toast.LENGTH_SHORT).show();
                }
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean on2 = aSwitch.isChecked();
                if (on2) {
                    Log.e("toggle", "on");


                } else {
                    Log.e("toggle", "off");
                }
            }
        });

    }
}
