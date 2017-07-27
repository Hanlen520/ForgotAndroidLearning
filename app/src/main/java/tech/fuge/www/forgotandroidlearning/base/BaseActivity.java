package tech.fuge.www.forgotandroidlearning.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import tech.fuge.www.forgotandroidlearning.BuildConfig;
import tech.fuge.www.forgotandroidlearning.R;

/**
 * Created by Lin Zongfu on 2017/6/23.
 * 基类
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    /*是否开启debug*/
    public static final boolean DEBUG = true;
    //区别debug和release版本字段，可用来开关打印。不必每次发布前手动修改
    public final static boolean LOG_DEBUG = BuildConfig.DEBUG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG) {
            Log.e(TAG, getClass().getSimpleName());
        }
        ActivityCollector.addActivity(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.show_activity:
                Toast.makeText(this, ActivityCollector.showAll(), Toast.LENGTH_SHORT).show();
                return true;
            default:return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    protected void showToast(String text) {
        Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String text) {
        Toast.makeText(getApplication(), text, Toast.LENGTH_LONG).show();
    }

    protected void showSnackBar(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
    }

    protected void showLongSnackBar(View view, String text) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    protected void showSnackBarWithAction(View view, String text, String actionText, View.OnClickListener clickListener) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT).setAction(actionText, clickListener).show();
    }

    protected void showLongSnackBarWithAction(View view, String text, String actionText, View.OnClickListener clickListener) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).setAction(actionText, clickListener).show();
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // TODO Auto-generated method stub
//        if (keyCode == KeyEvent.KEYCODE_BACK) {//屏蔽返回键
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
