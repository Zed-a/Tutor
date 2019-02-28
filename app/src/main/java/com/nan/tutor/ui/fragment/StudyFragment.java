package com.nan.tutor.ui.fragment;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nan.tutor.R;
import com.nan.tutor.ui.base.BaseFragment;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnEditorAction;

public class StudyFragment extends BaseFragment {

    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.search)
    EditText search;

    @OnClick(R.id.city)
    void onClickCity() {
        List<HotCity> hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        CityPicker.from(this) //activity或者fragment
//                .enableAnimation(true)	//启用动画效果，默认无
//                .setAnimationStyle(anim)	//自定义动画
                .setLocatedCity(new LocatedCity("上海", "上海", "101020100"))
                .setHotCities(hotCities)	//指定热门城市
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {
                        city.setText(data.getName());
                    }

                    @Override
                    public void onCancel(){}

                    @Override
                    public void onLocate() {}
                })
                .show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_study;
    }

    @OnEditorAction(R.id.search)
    public boolean onEditorSearch(TextView v, int actionId, KeyEvent event){
        if (actionId == EditorInfo.IME_ACTION_SEARCH){
            if (TextUtils.isEmpty(search.getText().toString().trim())){
                Toast.makeText(getActivity(), "请输入内容", Toast.LENGTH_SHORT).show();
                return true;
            }else {
                Toast.makeText(getActivity(), "这里执行搜索操作", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return false;
    }
}
