package com.nan.tutor.ui.activity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.nan.tutor.R;
import com.nan.tutor.network.service.LoginService;
import com.nan.tutor.ui.base.BaseActivity;

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
        startActivity(HomeActivity.class);
    }

    @OnClick(R.id.login)
    void clickLogin() {
    }
}

