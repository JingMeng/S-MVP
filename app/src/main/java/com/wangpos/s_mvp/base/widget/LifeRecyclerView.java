package com.wangpos.s_mvp.base.widget;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.wangpos.s_mvp.base.BasePresenter;
import com.wangpos.s_mvp.base.BaseView;

import java.lang.reflect.ParameterizedType;

/**
 * Created by qiyue on 2018/7/6.
 */

public class LifeRecyclerView<P extends BasePresenter> extends RecyclerView implements LifecycleObserver,IBase {



    protected P mPresenter;

    protected IBase iBase;

    public LifeRecyclerView(Context context) {
        super(context);
    }

    public LifeRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LifeRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }




    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void ON_CREATE() {
        initPresenter();
        iBase = new BaseImpl(getContext());//初始化公共操作
    }

    private void initPresenter() {
        if (this instanceof BaseView &&
                this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            /**
             * 鏍规嵁杩愯鏃惰幏鍙栫埗绫籆lass,瀹炲姏鍖栵紝涓嶈嚦浜庢瘡涓瓙绫籔resenter閮藉幓new
             *
             * 1浼樼偣锛岃繖鏍峰瓙绫诲彧闇€瑕佹寚瀹氭硾鍨嬪嵆鍙娇鐢?             *
             */
            try {
                mPresenter = (P)mPresenterClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (mPresenter != null) mPresenter.onAttachedView(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void ON_START() {
        Log.i("info","MyObserver:ON_START");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void ON_RESUME() {
        Log.i("info","MyObserver:ON_RESUME");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void ON_PAUSE() {
        Log.i("info","MyObserver:ON_PAUSE");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void ON_STOP() {
        Log.i("info","MyObserver:ON_STOP");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void ON_DESTROY() {
        Log.i("info","MyObserver:ON_DESTROY");
    }

    @Override
    public void toast(String msg) {
        iBase.toast(msg);
    }
}


