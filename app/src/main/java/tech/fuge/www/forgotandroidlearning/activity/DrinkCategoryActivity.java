package tech.fuge.www.forgotandroidlearning.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] strings = {"cokecole", "雪碧", "农夫山泉"};
        ListView listDrinks = getListView();
        ArrayAdapter listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strings);
        listDrinks.setAdapter(listAdapter);

    }

        @Override
        protected void onListItemClick (ListView l, View v,int position, long id){
//        super.onListItemClick(l, v, position, id);
            Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
            intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
            startActivity(intent);
        }
    }
