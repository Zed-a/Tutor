package com.nan.tutor.ui.activity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.nan.tutor.R;
import com.nan.tutor.bean.Student;
import com.nan.tutor.log.TutorLog;
import com.nan.tutor.network.JsonDataResp;
import com.nan.tutor.network.RxSchedulers;
import com.nan.tutor.network.RxSubscriber;
import com.nan.tutor.network.service.LoginService;
import com.nan.tutor.ui.base.BaseActivity;
import com.nan.tutor.util.ToastUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.phone)
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
        TutorLog.i("registerTest","start");
        String phone = mAccount.getText().toString();
        String password = mPassword.getText().toString();
        loginService.rigister(phone,password)
                .compose(RxSchedulers.<JsonDataResp<Student>>networkThenMain())
                .subscribe(new RxSubscriber<JsonDataResp<Student>>() {
                    @Override
                    public void onNext(JsonDataResp<Student> resp) {
                        super.onNext(resp);
                        if (resp.code == 0) {
                            ToastUtil.show(LoginActivity.this,"注册成功");
                            Student student = resp.data;
                            TutorLog.i("registerTest",student.toString());

                        } else {
                            ToastUtil.show(LoginActivity.this,"注册失败");
                        }
                    }
                });
    }

    @OnClick(R.id.login)
    void clickLogin() {
        TutorLog.i("loginTest","start");
        String phone = mAccount.getText().toString();
        String password = mPassword.getText().toString();
        loginService.login(phone,password)
                .compose(RxSchedulers.<JsonDataResp<Student>>networkThenMain())
                .subscribe(new RxSubscriber<JsonDataResp<Student>>() {
                    @Override
                    public void onNext(JsonDataResp<Student> resp) {
                        super.onNext(resp);
                        TutorLog.i("loginTest",resp.toString());
                        if (resp.code == 0) {
                            ToastUtil.show(LoginActivity.this,"登录成功");
                            Student student = resp.data;
                            TutorLog.i("loginTest",student.toString());
                            startActivity(HomeActivity.class);
                        } else {
                            ToastUtil.show(LoginActivity.this,"登录失败");
                        }
                    }
                });
    }
}

