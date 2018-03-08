package tech.fuge.www.forgotandroidlearning.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import tech.fuge.www.forgotandroidlearning.R;

/**
 * Created by forgot on 2018/3/7.
 * Email: forgot2015@gmail.com
 */

public class LoadingDialog extends Dialog {
    private TextView tvMsg;

    public LoadingDialog(Context context) {
        super(context);
        /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_loading);
        tvMsg = (TextView) findViewById(R.id.tv_msg);
        setCanceledOnTouchOutside(false);
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    public LoadingDialog setMessage(String message) {
        tvMsg.setText(message);
        return this;
    }


}
