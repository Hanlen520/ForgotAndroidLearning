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
import tech.fuge.www.forgotandroidlearning.view.LoadingDialog;

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

    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG) {
            Log.e(TAG, getClass().getSimpleName());
        }
        ActivityCollector.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

}
