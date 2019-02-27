package com.nan.tutor.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.nan.tutor.R;
import com.nan.tutor.activity.base.BaseActivity;
import com.nan.tutor.network.JsonDataResp;
import com.nan.tutor.network.RxSchedulers;
import com.nan.tutor.network.RxSubscriber;
import com.nan.tutor.network.service.LoginService;
import com.nan.tutor.storage.TeacherPrefs;
import com.nan.tutor.util.ToastUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.account)
    AutoCompleteTextView mAccount;
    @BindView(R.id.password)
    EditText mPassword;

    @Inject
    LoginService loginService;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(saveInstanceState);
    }

    @OnClick(R.id.regitster)
    void clickRegister() {
//        startActivity(HomeActivity.class);

        ToastUtil.show(this,"startConnect");
        loginService.connectTest()
                .compose(RxSchedulers.<JsonDataResp>computationThenMain())
                .subscribe(new RxSubscriber<JsonDataResp>() {
                    @Override
                    public void onNext(JsonDataResp resp) {
                        super.onNext(resp);
                    }
                });
    }

    @OnClick(R.id.login)
    void clickLogin() {
        mAccount.setError(null);
        mPassword.setError(null);
        if (TextUtils.isEmpty(mAccount.getText())) {
            mAccount.setError(getString(R.string.input_account));
            mAccount.setFocusable(true);
            mAccount.setFocusableInTouchMode(true);
            mAccount.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(mPassword.getText())) {
            mPassword.setError(getString(R.string.input_password));
            mPassword.setFocusable(true);
            mPassword.setFocusableInTouchMode(true);
            mPassword.requestFocus();
            return;
        }
    }
}

