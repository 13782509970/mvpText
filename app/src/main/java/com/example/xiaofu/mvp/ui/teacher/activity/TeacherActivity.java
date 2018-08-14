package com.example.xiaofu.mvp.ui.teacher.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.xiaofu.mvp.R;
import com.example.xiaofu.mvp.model.entity.TeacherBean;
import com.example.xiaofu.mvp.ui.BaseActivity;
import com.example.xiaofu.mvp.ui.particulars.activity.ParticularsActivity;
import com.example.xiaofu.mvp.ui.teacher.adapter.TeacherAdapter;
import com.example.xiaofu.mvp.ui.teacher.contract.TeacherContract;
import com.example.xiaofu.mvp.ui.teacher.presenter.TeacherPresenter;
import com.example.xiaofu.mvp.utils.log.LogUtil;

import java.util.ArrayList;

public class TeacherActivity extends BaseActivity implements TeacherContract.View{


    private TeacherContract.Presenter teacherPresenter;
    private android.support.v7.widget.RecyclerView mainRecycler;
    private TeacherAdapter teacherAdapter;
    private ArrayList<TeacherBean.BodyBean.ResultBean> list=new ArrayList<>();
    @Override
    public void showTeacherData(TeacherBean teacherBean) {
        list.addAll(teacherBean.getBody().getResult());
        teacherAdapter.notifyDataSetChanged();
    }


    @Override
    public void showTeacherErro(String erro) {
        LogUtil.e("TeacherActivity-->",erro);
    }

    @Override
    public void toParticulars(TeacherBean.BodyBean.ResultBean resultBean) {
        Intent intent = new Intent(this, ParticularsActivity.class);
        intent.putExtra("bean",resultBean);
        startActivity(intent);
    }




    @Override
    protected void initData() {
        teacherPresenter.getTeacherData();
    }

    @Override
    protected void initView() {
        teacherPresenter = new TeacherPresenter();//初始化P层对象
        teacherPresenter.attach(this);//初始化V层对象

        mainRecycler = (RecyclerView) findViewById(R.id.main_recycler);
        mainRecycler.setLayoutManager(new LinearLayoutManager(this));
        teacherAdapter = new TeacherAdapter(R.layout.main_item, list);
        mainRecycler.setAdapter(teacherAdapter);
        teacherAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TeacherBean.BodyBean.ResultBean resultBean = list.get(position);
                toParticulars(resultBean);
            }
        });
        teacherAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Button btn = view.findViewById(R.id.main_item_btn);
                TeacherBean.BodyBean.ResultBean resultBean = list.get(position);
                boolean select = resultBean.isSelect();
                resultBean.setSelect(!select);
                teacherPresenter.setBackground(btn,select);

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}
