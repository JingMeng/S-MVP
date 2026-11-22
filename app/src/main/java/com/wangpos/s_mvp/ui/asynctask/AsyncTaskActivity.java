package com.wangpos.s_mvp.ui.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.adapter.DisplayPhotoAdapter;
import com.wangpos.s_mvp.adapter.UploadPhotoAdapter;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.base.task.SmartTaskManager;
import com.wangpos.s_mvp.ui.welcome.BodyView;
import com.wangpos.s_mvp.ui.welcome.HeaderView;
import com.wangpos.s_mvp.ui.welcome.MenuView;

import java.util.ArrayList;
import java.util.List;

/**
 * 鎬ф劅濡瑰瓙鍥緃ttp://m.xxxiao.com
 */
public class AsyncTaskActivity extends BaseActivity {
    @$(R.id.recyclerView)
    public RecyclerView recyclerView;

    @$(R.id.tv_finish)
    public TextView tvFinish;


    @Override
    public int getLayoutId() {
        return R.layout.activity_async_task;
    }

    @Override
    public void initView() {

        SmartTaskManager.as().put("asloadImage",9).toEnd(()->{

            tvFinish.setVisibility(View.VISIBLE);
        });

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        displayAdapter = new DisplayPhotoAdapter(getDatas(),getApplicationContext());
        recyclerView.setAdapter(displayAdapter);
    }


    public DisplayPhotoAdapter displayAdapter;


    public List<Integer> getDatas() {
        List<Integer>imageUrls = new ArrayList<>();
        imageUrls.add(R.drawable.anime1);
        imageUrls.add(R.drawable.anime2);
        imageUrls.add(R.drawable.anime3);
        imageUrls.add(R.drawable.anime4);
        imageUrls.add(R.drawable.anime5);
        imageUrls.add(R.drawable.anime6);
        imageUrls.add(R.drawable.anime7);
        imageUrls.add(R.drawable.anime8);
        imageUrls.add(R.drawable.anime9);

        return imageUrls;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        displayAdapter.onDetached();
    }
}

