package com.example.xiaofu.mvp.ui.teacher.presenter;

import android.graphics.Color;
import android.widget.Button;

import com.example.xiaofu.mvp.R;
import com.example.xiaofu.mvp.config.Urls;
import com.example.xiaofu.mvp.model.biz.Service;
import com.example.xiaofu.mvp.model.entity.TeacherBean;
import com.example.xiaofu.mvp.ui.teacher.contract.TeacherContract;
import com.example.xiaofu.mvp.utils.RetrofitManager;
import com.example.xiaofu.mvp.utils.log.LogUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//         佛祖保佑       永无BUG     永不修改                     //
////////////////////////////////////////////////////////////////////
public class TeacherPresenter implements TeacherContract.Presenter {

    public TeacherContract.View mView;
    public Service service;

    public TeacherPresenter(){
        service = RetrofitManager.getInstance(Urls.BASE_URL).setCreate(Service.class);
    }



    @Override
    public void attach(TeacherContract.View view) {
        mView=view;
    }

    @Override
    public void decath() {
        mView = null;
    }

    @Override
    public void getTeacherData() {

        service.getTeacher()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TeacherBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeacherBean teacherBean) {
                        if(mView !=null){
                            mView.showTeacherData(teacherBean);
                        }else{
                            LogUtil.e("TeacherPresenter-->","mView为空");
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                        if(mView !=null){
                            mView.showTeacherErro(e.getMessage());
                        }else{
                            LogUtil.e("TeacherPresenter-->","mView为空");
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void setBackground(Button btn  ,boolean isSelect) {
        if(!isSelect){
            btn.setBackgroundResource(R.drawable.btn_select);
            btn.setTextColor(Color.WHITE);
        }else{
            btn.setBackgroundResource(R.drawable.btn_unselected);
            btn.setTextColor(Color.BLACK);
        }
    }
}
