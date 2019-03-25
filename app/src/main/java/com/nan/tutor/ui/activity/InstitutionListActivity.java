package com.nan.tutor.ui.activity;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nan.tutor.R;
import com.nan.tutor.bean.Institution;
import com.nan.tutor.ui.adapter.InstitutionAdapter;
import com.nan.tutor.ui.base.BaseActivity;
import com.nan.tutor.util.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InstitutionListActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_institution_list;
    }

    private List<Institution> institutionList;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void initView() {
        super.initView();
        setupToolbar(toolbar,true,"附近机构");
        institutionList = new ArrayList<>();
        Uri uri;
        Institution institution;
        uri = ImageUtils.resourceIdToUri(this, R.drawable.institution_jingrui);
        institution = new Institution(uri.toString(),"上海精锐教育",9.7,1.5);
        institutionList.add(institution);
        uri = ImageUtils.resourceIdToUri(this, R.drawable.institution_angli);
        institution = new Institution(uri.toString(),"上海昂立教育",9.2,2.0);
        institutionList.add(institution);
        uri = ImageUtils.resourceIdToUri(this, R.drawable.institution_lvguang);
        institution = new Institution(uri.toString(),"上海绿光教育",9.0,2.4);
        institutionList.add(institution);
        uri = ImageUtils.resourceIdToUri(this, R.drawable.institution_fuwen);
        institution = new Institution(uri.toString(),"上海复文教育",9.7,3.1);
        institutionList.add(institution);
        uri = ImageUtils.resourceIdToUri(this, R.drawable.institution_zhixue);
        institution = new Institution(uri.toString(),"上海致学教育",9.1,4.2);
        institutionList.add(institution);
        uri = ImageUtils.resourceIdToUri(this, R.drawable.institution_longwen);
        institution = new Institution(uri.toString(),"上海龙文教育",9.4,0.5);
        institutionList.add(institution);


        InstitutionAdapter institutionAdapter = new InstitutionAdapter(this,institutionList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(institutionAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
