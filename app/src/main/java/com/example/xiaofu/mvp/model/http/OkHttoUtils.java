package com.example.xiaofu.mvp.model.http;

import android.os.Looper;

import com.example.xiaofu.mvp.config.Urls;
import com.example.xiaofu.mvp.model.callback.ParticularsCallBack;
import com.example.xiaofu.mvp.model.entity.TeacherParticularsBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
public class OkHttoUtils implements IHttp {

    private static OkHttoUtils okHttoUtils;
    private final OkHttpClient build;

    private OkHttoUtils() {
        build = new OkHttpClient.Builder().build();
    }

    public static OkHttoUtils getInstance(){

        if(okHttoUtils == null){
            synchronized (OkHttoUtils.class){
                if(okHttoUtils == null){
                    okHttoUtils = new OkHttoUtils();
                }
            }
        }

        return okHttoUtils;

    }

    @Override
    public <T> void doGet(String url, String id, final ParticularsCallBack<T> callBack) {
        Request request = new Request.Builder()
                .url(url + id)
                .build();
        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                T t = parseData(string, callBack);
                callBack.onSuccess(t);
            }
        });
    }

    private <T> T parseData(String jsonData,ParticularsCallBack<T> callBack){

        Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
        Class<T> actualTypeArgument = (Class<T>) actualTypeArguments[0];
        T t = new Gson().fromJson(jsonData, actualTypeArgument);
        return t;
    }

}
