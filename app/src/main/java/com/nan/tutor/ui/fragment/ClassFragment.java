package com.nan.tutor.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.nan.tutor.R;
import com.nan.tutor.ui.base.BaseFragment;

import org.w3c.dom.Text;

import java.util.Calendar;

import butterknife.BindInt;
import butterknife.BindView;

public class ClassFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_class;
    }

    @BindView(R.id.time)
    TextView time;

    @Override
    protected void initView(View view) {
        time.setText(getDate());
    }

    private String getDate() {
        Calendar cal = Calendar.getInstance();
        int year_now = cal.get(Calendar.YEAR);
        int month_now = cal.get(Calendar.MONTH) + 1;
        int day_now = cal.get(Calendar.DAY_OF_MONTH);
        return year_now+"年"+month_now+"月"+day_now+"日";
    }
}
