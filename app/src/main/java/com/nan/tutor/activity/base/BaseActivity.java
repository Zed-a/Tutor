package com.nan.tutor.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nan.tutor.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        Log.d("ActivityName", getClass().getSimpleName());
        AppCompatActivityCollector.addActivity(this);
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        ButterKnife.bind(this);

        initView();
        initData();
        applyEvent();
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

    /**
     * 设置事件监听
     */
    protected void applyEvent() {}

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