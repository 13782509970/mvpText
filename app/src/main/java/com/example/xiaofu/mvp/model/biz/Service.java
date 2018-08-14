package com.example.xiaofu.mvp.model.biz;

import com.example.xiaofu.mvp.config.Urls;
import com.example.xiaofu.mvp.model.entity.TeacherBean;
import com.example.xiaofu.mvp.model.entity.TeacherParticularsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

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
public interface Service {

    @GET(Urls.TEACHER_DATA)
    Observable<TeacherBean> getTeacher();

    @GET(Urls.TEACHER_PARTICULARS+"{ID}")
    Observable<TeacherParticularsBean> getTeacherParticulars(@Path("ID")String id);



}
