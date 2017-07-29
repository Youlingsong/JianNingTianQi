package com.example.lenovo.jianningtianqi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.entity.QQ_message;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/13.
 */

public class StartActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1106300050";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    @BindView(R.id.btn_browsing)
    Button btnBrowsing;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_regeist)
    Button btnRegeist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        mTencent = Tencent.createInstance(APP_ID, StartActivity.this.getApplicationContext());
    }

    @OnClick({R.id.btn_browsing, R.id.btn_login, R.id.btn_regeist})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_browsing:
                //startActivity(new Intent(StartActivity.this, ShouyeActivity.class));
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(StartActivity.this, "all", mIUiListener);
                break;
            case R.id.btn_login:
                onClickShare();
                break;
            case R.id.btn_regeist:
                startActivity(new Intent(StartActivity.this, ResigstActivity.class));
                break;
        }
    }

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(StartActivity.this, "授权成功", Toast.LENGTH_SHORT).show();

            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(), qqToken);


                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG, "登录成功" + response.toString());
                        QQ_message message = Utility.handleQQmessage(response.toString());
                        String ss = message.getNickname();
                        String pic=message.getFigureurl_qq_2();
                        Intent intent = new Intent(StartActivity.this, ShouyeActivity.class);
                        intent.putExtra("name", ss);
                        intent.putExtra("pic",pic);
                        startActivity(intent);


                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG, "登录失败" + uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG, "登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(StartActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(StartActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_LOGIN) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onClickShare() {
        final Bundle params = new Bundle();
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
        params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, 3);
        mTencent.shareToQQ(StartActivity.this, params, new BaseUiListener());
    }

}
