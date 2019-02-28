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

        TutorLog.d("ActivityName", getClass().getSimpleName());
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);

        initView();
        initData();
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