package Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
    protected void initView(){}


    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 设置事件监听
     */
    protected void applyEvent(){}

    protected void onDestroy() {
        super.onDestroy();
    }
}