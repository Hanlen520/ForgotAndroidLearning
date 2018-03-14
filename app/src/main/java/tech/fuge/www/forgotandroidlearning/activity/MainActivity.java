package tech.fuge.www.forgotandroidlearning.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tech.fuge.www.forgotandroidlearning.R;
import tech.fuge.www.forgotandroidlearning.base.BaseActivity;
import tech.fuge.www.forgotandroidlearning.view.LoadingDialog;

public class MainActivity extends BaseActivity {
    public static final String TAG = "MainActivity";
    @BindView(R.id.btn_dialog)
    Button btnDialog;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    @BindView(R.id.btn_thread_ui)
    Button btnThreadUi;
    @BindView(R.id.btn_thread_handler)
    Button btnThreadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadingDialog = new LoadingDialog(this).setMessage("加载中，请稍后...");
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                tvMsg.setText("神荼");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                tvMsg.setText("神荼222");
            }
        });
    }

    @OnClick(R.id.btn_dialog)
    public void onBtnDialogClicked() {
        loadingDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismiss();
                tvMsg.setText("loadingDialog");
                Toast.makeText(MainActivity.this, "handler toast", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }

    @OnClick(R.id.btn_thread_ui)
    public void onBtnThreadUiClicked() {
        Log.e(TAG, "onBtnThreadUiClicked");
        new Thread(new Runnable() {
            @Override
            public void run() {
                tvMsg.setText("Thread update ui , crash");
            }
        }).start();
    }

    @OnClick(R.id.btn_thread_handler)
    public void onViewClicked() {
        Log.e(TAG, "Thread Handler Update UI");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "Thread Handler Update UI111");
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e(TAG, "Thread Handler Update UI222");
                        tvMsg.setText("Thread Handler Update UI");
                    }
                });
            }
        }).start();
    }
}
