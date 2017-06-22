package tech.fuge.www.forgotheadfirstandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tech.fuge.www.forgotheadfirstandroid.R;
import tech.fuge.www.forgotheadfirstandroid.base.BaseActivity;

public class WineRecommendActivity extends BaseActivity {
    TextView wineTv;
    Spinner spinner;
    String spinnerStr;
    StringBuilder stringRecommend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_recommend);
        wineTv = (TextView) findViewById(R.id.tv_wine);
        spinner = (Spinner) findViewById(R.id.spinner_wine);

        findViewById(R.id.btn_wine_recommend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerStr = spinner.getSelectedItem().toString();
                stringRecommend = new StringBuilder();
                List<String> wineList = recommentWine(spinnerStr);
                for (String s : wineList) {
                    stringRecommend.append(s).append("\n");
                }
                wineTv.setText(stringRecommend);
            }
        });
    }


    /*用卫语句实现，而不是多重if else*/
    private List<String> recommentWine(String type) {
        List<String> list = new ArrayList<>();
        if (type.equals("啤酒")) {
            list.add("菠萝啤就不错啦");
            list.add("珠江啤酒啊");
            return list;
        }
        if (type.equals("红酒")) {
            list.add("龙舌兰够逼格了吧");
            list.add("标准的海贼要喝朗姆酒");
            return list;
        }
        if (type.equals("白酒")) {
            list.add("必须是茅台啊");
            list.add("龙井也不错啊");
            return list;
        }
        list.add(getString(R.string.no_for_you));
        return list;
    }
}
