package tech.fuge.www.forgotheadfirstandroid.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends AppCompatActivity {
    public static final String TAG = "BaseActivity";
    public static final boolean DEBUG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, getClass().getSimpleName()+"onCrete");
    }
}
