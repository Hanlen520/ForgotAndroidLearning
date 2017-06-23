package tech.fuge.www.forgotheadfirstandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tech.fuge.www.forgotheadfirstandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //红酒推荐Activity
        findViewById(R.id.btn_wine_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WineRecommendActivity.class));
            }
        });
        //发送文本
        findViewById(R.id.btn_action).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_TEXT,"发送给别人的消息");
                startActivity(intent);
            }
        });
        //选择器
        findViewById(R.id.btn_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(Intent.EXTRA_TEXT,"选择器：发送给别人的消息");
                String chosenTitle =getString(R.string.chooser);
                Intent chosenIntent = Intent.createChooser(intent,chosenTitle);
                startActivity(chosenIntent);
            }
        });
    }


}
