package com.example.lenovo.jianningtianqi.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jianningtianqi.R;
import com.hyphenate.EMError;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/14.
 */

public class ResigstActivity extends Activity {

    @BindView(R.id.iv_menus)
    ImageView ivMenus;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_verify_code)
    EditText etVerifyCode;
    @BindView(R.id.tv_send_verify_code)
    TextView tvSendVerifyCode;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.iv_agree_protocol)
    ImageView ivAgreeProtocol;
    @BindView(R.id.tv_agree_protocol)
    TextView tvAgreeProtocol;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_send_verify_code, R.id.btn_next, R.id.iv_agree_protocol})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_send_verify_code:
                startCountDown();
                break;
            case R.id.btn_next:
                break;
            case R.id.iv_agree_protocol:
                break;
        }
    }
    private void startCountDown() {
        tvSendVerifyCode.setEnabled(false);
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvSendVerifyCode.setText(millisUntilFinished / 1000 + "S");
            }

            @Override
            public void onFinish() {
                tvSendVerifyCode.setText(R.string.get_verify_code);
                tvSendVerifyCode.setEnabled(true);
            }
        };
        countDownTimer.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
