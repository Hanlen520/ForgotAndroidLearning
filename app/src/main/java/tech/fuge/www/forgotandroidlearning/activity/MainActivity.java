package tech.fuge.www.forgotandroidlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tech.fuge.www.forgotandroidlearning.R;

public class MainActivity extends AppCompatActivity {
TextView mTextView;
    Button btnPress;
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
                        .putExtra(Intent.EXTRA_TEXT, "发送给别人的消息");
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
                        .putExtra(Intent.EXTRA_TEXT, "选择器：发送给别人的消息");
                String chosenTitle = getString(R.string.chooser);
                Intent chosenIntent = Intent.createChooser(intent, chosenTitle);
                startActivity(chosenIntent);
            }
        });
//        testFastJson();
        findViewById(R.id.chronograph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChronographActivity.class));
            }
        });
        findViewById(R.id.btn_gridlayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridLayoutActivity.class));
            }
        });

        findViewById(R.id.btn_widget).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WidgetsActivity.class));
            }
        });
        findViewById(R.id.list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoodListViewActivity.class));
            }
        });

        findViewById(R.id.workout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WorkOutActivity.class));
            }
        });

        findViewById(R.id.btn_titlebar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ActionbarActivity.class));
            }
        });

       mTextView= (TextView) findViewById(R.id.text);
        mTextView.setText(R.string.age);
        mTextView.setText(String.format(getString(R.string.age),20));
         btnPress = (Button) findViewById(R.id.btn_press);
        btnPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAfterPress();
            }
        });
//        String a;
//        a.equals("ss");
    }


    void doAfterPress(){
        System.out.println("press");
        btnPress.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btnPress.setEnabled(true);
            }
        }, 1000);
    }
//    public static void testFastJson() {
//        Group group = new Group();
//        group.setId(0L);
//        group.setName("admin");
//
//        User guestUser = new User();
//        guestUser.setId(2L);
//        guestUser.setName("guest");
//
//        User rootUser = new User();
//        rootUser.setId(3L);
//        rootUser.setName("root");
//
//        group.addUser(guestUser);
//        group.addUser(rootUser);
//
////        String jsonString = JSON.toJSONString(group);
//
////        System.out.println(jsonString);
////        Log.w("toString", jsonString);
//
////        Group group1 = JSON.parseObject("{\"id\":0,\"name\":\"admin\",\"users\":[{\"id\":2,\"name\":\"guest\"},{\"id\":3,\"name\":\"root\"}]}", Group.class);
////        Log.e("tag", group.toString());
//    }


}
