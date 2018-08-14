package com.example.xiaofu.mvp.ui.particulars.presenter;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.example.xiaofu.mvp.R;
import com.example.xiaofu.mvp.config.Urls;
import com.example.xiaofu.mvp.model.biz.IOkHttpModel;
import com.example.xiaofu.mvp.model.biz.OkHttpModel;
import com.example.xiaofu.mvp.model.biz.Service;
import com.example.xiaofu.mvp.model.callback.ParticularsCallBack;
import com.example.xiaofu.mvp.model.entity.TeacherParticularsBean;
import com.example.xiaofu.mvp.ui.particulars.contract.ParticularsContract;
import com.example.xiaofu.mvp.utils.RetrofitManager;
import com.example.xiaofu.mvp.utils.log.LogUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
* Created by TMVPHelper on 2018/08/13
*/
public class ParticularsPresenter implements ParticularsContract.Presenter {


    public ParticularsContract.View mView;
    public OkHttpModel model;
    public ParticularsPresenter(){
        model = new IOkHttpModel();
    }
    @Override
    public void getParticularsData(int id) {
        model.getParticulars(id,new ParticularsCallBack<TeacherParticularsBean>() {
            @Override
            public void onSuccess(TeacherParticularsBean teacherParticularsBean) {
                mView.showParticularsData(teacherParticularsBean);
            }

            @Override
            public void onError(String errorMsg) {
                LogUtil.e("ParticularsPresenter-->",errorMsg);
            }
        });
    }

    @Override
    public void setBackground(Button btn, boolean isSelect) {

    }

    @Override
    public void attach(ParticularsContract.View view) {
        mView = view;
    }

    @Override
    public void decath() {
        mView =null;
    }

    /*public ParticularsContract.View mView;
    private final Service service;

    public ParticularsPresenter(){
        service = RetrofitManager.getInstance(Urls.BASE_URL).setCreate(Service.class);
    }




    @Override
    public void getParticularsData(int id) {
        service.getTeacherParticulars(id+"")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TeacherParticularsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeacherParticularsBean teacherParticularsBean) {
                        mView.showParticularsData(teacherParticularsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showParticularsErro(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void setBackground(Button btn  , boolean isSelect) {
        if(!isSelect){
            btn.setBackgroundResource(R.drawable.btn_select);
            btn.setTextColor(Color.WHITE);
        }else{
            btn.setBackgroundResource(R.drawable.btn_unselected);
            btn.setTextColor(Color.BLACK);
        }
    }*/




}