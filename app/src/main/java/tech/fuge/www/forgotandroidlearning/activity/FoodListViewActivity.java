package tech.fuge.www.forgotandroidlearning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tech.fuge.www.forgotandroidlearning.R;

public class FoodListViewActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_view);
        listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object object = listView.getItemAtPosition(position);
                final String select = object.toString();
                Snackbar.make(listView, "your select" + select, Snackbar.LENGTH_SHORT)
                        .setAction("go to", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (select.equals("Drinks")) {
                                startActivity(new Intent(FoodListViewActivity.this,DrinkCategoryActivity.class));
                                }
                            }
                        })
                        .show();
            }
        });
    }
}
