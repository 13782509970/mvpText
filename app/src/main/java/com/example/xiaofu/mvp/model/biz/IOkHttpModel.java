package com.example.xiaofu.mvp.model.biz;

import com.example.xiaofu.mvp.model.callback.ParticularsCallBack;
import com.example.xiaofu.mvp.model.entity.TeacherParticularsBean;
import com.example.xiaofu.mvp.model.http.HttpFactory;
import com.example.xiaofu.mvp.model.http.IHttp;

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

//M层的实现类
public class IOkHttpModel implements OkHttpModel {
    @Override
    public void getParticulars(int id,ParticularsCallBack<TeacherParticularsBean> callBack) {
        IHttp iHttp = HttpFactory.create();

        //发送求情
        iHttp.doGet("https://api.yunxuekeji.cn/yunxue_app_api/teacher/getTeacherPower/",id+"",callBack);
    }
}
