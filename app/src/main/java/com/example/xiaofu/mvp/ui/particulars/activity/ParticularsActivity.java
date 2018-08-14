package com.example.xiaofu.mvp.ui.particulars.activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xiaofu.mvp.R;
import com.example.xiaofu.mvp.model.entity.TeacherBean;
import com.example.xiaofu.mvp.model.entity.TeacherParticularsBean;
import com.example.xiaofu.mvp.ui.BaseActivity;
import com.example.xiaofu.mvp.ui.particulars.adapter.ViewPagerFragmentAdapter;
import com.example.xiaofu.mvp.ui.particulars.contract.ParticularsContract;
import com.example.xiaofu.mvp.ui.particulars.fragment.ParticularsTabLayoutFragment;
import com.example.xiaofu.mvp.ui.particulars.presenter.ParticularsPresenter;
import com.example.xiaofu.mvp.utils.log.LogUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParticularsActivity extends BaseActivity implements ParticularsContract.View{


    private android.widget.ImageView mainItemImage;
    private android.widget.TextView mainItemName;
    private android.widget.TextView mainItemContent;
    private android.widget.TextView mainItemType;
    private android.widget.Button mainItemBtn;
    private android.support.design.widget.TabLayout tbaLayout;
    private ViewPager pager;
    private ParticularsPresenter particularsPresenter;
    private ArrayList<Fragment> fragmentArrayList =new ArrayList<>();
    private ArrayList<String> titleArrayList=new ArrayList<>();
    private String description;
    private ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    private int id;
    private boolean select;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        TeacherBean.BodyBean.ResultBean bean = (TeacherBean.BodyBean.ResultBean) intent.getSerializableExtra("bean");
        if(bean != null){
            select = bean.isSelect();
            mainItemName.setText(bean.getTeacherName());
            mainItemContent.setText(bean.getTitle());
            id = bean.getID();
            String teacherPic = bean.getTeacherPic();
            Glide.with(this).load(teacherPic).apply(new RequestOptions().circleCrop()).into(mainItemImage);
            List<TeacherBean.BodyBean.ResultBean.TeacherTypeBean> teacherType = bean.getTeacherType();
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < teacherType.size(); i++) {
                sb.append("#"+teacherType.get(i).getTypename()+"#");
            }
            mainItemType.setText(sb.toString());
            description = bean.getDescription();

        }
        particularsPresenter.getParticularsData(id);

    }

    @Override
    protected void initView() {
        particularsPresenter = new ParticularsPresenter();
        particularsPresenter.attach(this);
        mainItemImage = (ImageView) findViewById(R.id.main_item_image);
        mainItemName = (TextView) findViewById(R.id.main_item_name);
        mainItemContent = (TextView) findViewById(R.id.main_item_content);
        mainItemType = (TextView) findViewById(R.id.main_item_type);
        mainItemBtn = (Button) findViewById(R.id.main_item_btn);
        tbaLayout = (TabLayout) findViewById(R.id.tbaLayout);
        pager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentArrayList, titleArrayList);
        pager.setAdapter(viewPagerFragmentAdapter);
        tbaLayout.setupWithViewPager(pager);
        mainItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                particularsPresenter.setBackground(mainItemBtn,select);//不知道对不对
                select = !select;
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_particulars;
    }

    @Override
    public void showParticularsData(final TeacherParticularsBean teacherParticularsBean) {
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                List<TeacherParticularsBean.BodyBean.ResultBean> result = teacherParticularsBean.getBody().getResult();
                for (int i = 0; i < result.size(); i++) {
                    TeacherParticularsBean.BodyBean.ResultBean resultBean = result.get(i);
                    ParticularsTabLayoutFragment particularsTabLayoutFragment = new ParticularsTabLayoutFragment();
                    if(i == 0){
                        Bundle bundle = new Bundle();
                        bundle.putString("content",description);
                        particularsTabLayoutFragment.setArguments(bundle);
                    }
                    fragmentArrayList.add(particularsTabLayoutFragment);
                    titleArrayList.add(resultBean.getDescription());
                }
                viewPagerFragmentAdapter.notifyDataSetChanged();
            }
        });


    }
    Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    public void showParticularsErro(String erro) {
        LogUtil.e("ParticularsActivity-->",erro);
    }


}
