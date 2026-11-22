package com.wangpos.s_mvp.ui.wxnews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bindview.$;
import com.wangpos.s_mvp.R;
import com.wangpos.s_mvp.base.BaseActivity;


/**
 * 涓€涓ā鍧楀紑鍙戞湰姝ラ鍏跺疄鍙互寰堝锛屽洜涓轰釜妯″潡閮芥槸鐩镐簰瑙ｈ€︾殑锛屾墍浠ュ叾瀹炰笉绠℃€庝箞閮藉簲璇ュ厛纭畾鏁版嵁bean
 *
 * 姣斿 绗竴绉? * 1.纭畾鏁版嵁bean
 * 2.鍏堝啓ApiService
 * 3.鍐機ontract
 * 4.鍐橫odel
 * 5.鍐橮resenter
 * 6.鍐橵iew
 * 7.View鍏宠仈Presenter
 *
 * 姣斿 绗簩绉? *
 * 1.纭畾鏁版嵁bean
 * 2.鍐機ontract
 * 3.鍐橵iew
 * 4.View鍏宠仈Presenter
 * 5.鍐檖resenter
 * 6.鍐檓odel
 * 7.鍐橝piService
 *
 *
 */
public class WXNewsActivity extends BaseActivity {


    @$(R.id.recyclerView)
    public WXNewsListView wxNewsListView;
    @Override
    public int getLayoutId() {
        return R.layout.activity_wxnews;
    }

    @Override
    public void initView() {
        getLifecycle().addObserver(wxNewsListView);

    }
}

