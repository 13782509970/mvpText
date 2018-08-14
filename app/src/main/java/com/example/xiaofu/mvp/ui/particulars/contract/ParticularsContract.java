package com.example.xiaofu.mvp.ui.particulars.contract;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.example.xiaofu.mvp.base.BasePresenter;
import com.example.xiaofu.mvp.base.BaseView;
import com.example.xiaofu.mvp.model.entity.TeacherParticularsBean;

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
public interface ParticularsContract {

    interface View extends BaseView {

        void showParticularsData(TeacherParticularsBean teacherParticularsBean);
        void showParticularsErro(String erro);


    }


    interface Presenter extends BasePresenter<View> {
        void getParticularsData(int id);
        void setBackground(Button btn , boolean isSelect);
    }
}