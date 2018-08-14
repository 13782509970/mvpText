package com.example.xiaofu.mvp.utils;

import android.util.Log;


import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;


/**
 * Created by XiaoFu on 2018/7/27.
 */

public class OkHttpInterceptor implements Interceptor {

    private Charset charset;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Request.Builder builder = request.newBuilder();
       /* builder.addHeader("apptoken",token );
        builder.addHeader("appType","univstarUnion");
        builder.addHeader("cid","dd2a152f6d132980462385b10b8487bb");
        builder.addHeader("did","");
        builder.addHeader("oCode","350010");
        builder.addHeader("userId","1567");*/

        Response response = chain.proceed(builder.build());

        return response;
    }
}
