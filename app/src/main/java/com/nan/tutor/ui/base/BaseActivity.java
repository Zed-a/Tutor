package com.nan.tutor.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nan.tutor.log.TutorLog;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {

    protected void onCreate(Bundle saveInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(saveInstanceState);

        TutorLog.i(getClass().getSimpleName(), "onCreate");
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TutorLog.i(getClass().getSimpleName(),"onSaveInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TutorLog.i(getClass().getSimpleName(),"onRestart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TutorLog.i(getClass().getSimpleName(),"onRestoreInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TutorLog.i(getClass().getSimpleName(),"onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        TutorLog.i(getClass().getSimpleName(),"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        TutorLog.i(getClass().getSimpleName(),"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        TutorLog.i(getClass().getSimpleName(),"onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        TutorLog.i(getClass().getSimpleName(),"onStart");
    }

    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected void initView() {}

    /**
     * 初始化数据
     */
    protected void initData() {}

    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}