package tech.fuge.www.forgotheadfirstandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import tech.fuge.www.forgotheadfirstandroid.R;
import tech.fuge.www.forgotheadfirstandroid.model.Drink;

public class DrinkActivity extends AppCompatActivity {
public static final String EXTRA_DRINKNO= "drinkNo";
    TextView tvName;
    TextView tvContent;
    ImageView drinkImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];
        tvName= (TextView) findViewById(R.id.drink_name);
        tvContent= (TextView) findViewById(R.id.drink_content);
        drinkImg= (ImageView) findViewById(R.id.drink_img);

        tvName.setText(drink.getName());
        tvContent.setText(drink.getDescription());
        drinkImg.setImageResource(drink.getImageResourceId());
        drinkImg.setContentDescription(drink.getName());
    }
}
