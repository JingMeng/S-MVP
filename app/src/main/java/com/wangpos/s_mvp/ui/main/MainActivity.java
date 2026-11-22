package com.wangpos.s_mvp.ui.main;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.adapter.RecyclerAdapter;
import com.wangpos.s_mvp.base.BaseActivity;
import com.wangpos.s_mvp.ui.asynctask.AsyncTaskActivity;
import com.wangpos.s_mvp.ui.meizi.FuliActivity;
import com.wangpos.s_mvp.ui.retrofit.RetrofitSampleActivity;
import com.wangpos.s_mvp.ui.synctask.SyncTaskActivity;
import com.wangpos.s_mvp.ui.welcome.WelcomeActivity;
import com.wangpos.s_mvp.ui.wxnews.WXNewsActivity;
import com.wangpos.s_mvp.widget.TimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/6/24.
 *
 * 娣诲姞绉诲嚭鍔ㄧ敾锛? * 淇敼鏍峰紡棰滆壊
 * 娣诲姞璇︽儏婕旂ず
 */

public class MainActivity extends BaseActivity implements  RecyclerAdapter.OnClickListener{


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        List<TimeModel> datas = new ArrayList<>();
        initDatas(datas);
        RecyclerAdapter adapter = new RecyclerAdapter(datas,this);
        adapter.setmOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }



    private void initDatas(List<TimeModel> datas) {
        datas.add(new TimeModel("2017/10/11","鍒涘缓S-MVP椤圭洰锛屾墦閫犱竴涓槗浜庣淮鎶ゃ€佹槗浜庢祴璇曘€佹彁楂樺紑鍙戞晥鐜囩殑鏋舵瀯"));
        datas.add(new TimeModel("2017/12/1","寮曞叆璋锋瓕MVP Contracts鎬濇兂锛屾帴鍙ｇ粺涓€鍖栧皝瑁?鍑忓皯绫荤殑鍒涘缓"));
        datas.add(new TimeModel("2017/12/12","寮曞叆AOP鎻掍欢锛岃窡浼橀泤鐨勭洃鍚拰缁存姢椤圭洰"));
        datas.add(new TimeModel("2017/12/27","灏佽SmartTask娣诲姞澶氫釜缃戠粶璇锋眰椤哄簭澶勭悊"));
        datas.add(new TimeModel("2018/2/10","娣诲姞LifeCycle瀹炵幇涓氬姟鍒嗙"));
        datas.add(new TimeModel("2018/3/2","添加插件化框架，实现轻量级View的注入"));
        datas.add(new TimeModel("2018/5/2","添加AOP切片，实现日志和缓存的代理，编译后期维护和修改"));
        datas.add(new TimeModel("2018/5/5","封装SmartTask添加多个网络异步请求，监听全部执行完成"));
        datas.add(new TimeModel("2018/7/3","鍗曠嫭浣跨敤Retrofit鑾峰彇澶╂皵淇℃伅"));
        datas.add(new TimeModel("2018/7/6","联合使用RxJava和Retrofit获取微信精选"));
        datas.add(new TimeModel("2018/7/10","福利社"));






    }

    @Override
    public void onClick(View view, int position) {

        switch (position){
            case 0:
                launch("https://github.com/UCodeUStory/S-MVP");
                break;
            case 3:
                launch(SyncTaskActivity.class);
                break;
            case 4:
                launch(WelcomeActivity.class);
                break;
            case 7:
                launch(AsyncTaskActivity.class);
                break;
            case 8:
                launch(RetrofitSampleActivity.class);
                break;
            case 9:
                launch(WXNewsActivity.class);
                break;
            case 10:
                launch(FuliActivity.class);
                break;

        }

    }
}

