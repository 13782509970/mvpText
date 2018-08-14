package com.example.xiaofu.mvp.ui.particulars.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.xiaofu.mvp.R;
import com.example.xiaofu.mvp.model.entity.TeacherBean;

import java.util.List;

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
public class ParticularsRecycler extends BaseQuickAdapter<TeacherBean.BodyBean.ResultBean, BaseViewHolder> {
    public ParticularsRecycler(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TeacherBean.BodyBean.ResultBean item) {
        helper.setText(R.id.main_item_name, item.getTeacherName());
        helper.setText(R.id.main_item_content, item.getTitle());


        List<TeacherBean.BodyBean.ResultBean.TeacherTypeBean> teacherType = item.getTeacherType();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < teacherType.size(); i++) {
            TeacherBean.BodyBean.ResultBean.TeacherTypeBean teacherTypeBean = teacherType.get(i);
            String typename = teacherTypeBean.getTypename();
            sb.append("#"+typename+"#");
        }
        helper.setText(R.id.main_item_type, sb.toString());
        // 加载网络图片
        Glide.with(mContext).load(item.getTeacherPic()).apply(new RequestOptions().circleCrop()).into((ImageView) helper.getView(R.id.main_item_image));

        helper.addOnClickListener(R.id.main_item_btn);

    }
}
