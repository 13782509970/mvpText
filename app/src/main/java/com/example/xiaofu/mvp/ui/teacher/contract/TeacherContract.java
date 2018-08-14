package com.example.xiaofu.mvp.ui.teacher.contract;

import android.widget.Button;

import com.example.xiaofu.mvp.base.BasePresenter;
import com.example.xiaofu.mvp.base.BaseView;
import com.example.xiaofu.mvp.model.entity.TeacherBean;

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
public interface TeacherContract {

    interface View extends BaseView{
        void showTeacherData(TeacherBean teacherBean);
        void showTeacherErro(String erro);
        void toParticulars(TeacherBean.BodyBean.ResultBean resultBean);
    }
    interface Presenter extends BasePresenter<View>{
        void getTeacherData();
        void setBackground(Button btn , boolean isSelect);
    }

}
