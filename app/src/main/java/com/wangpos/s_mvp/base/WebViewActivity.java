package com.wangpos.s_mvp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wangpos.s_mvp.R;


/**
 * @ Author: qiyue (ustory)
 * @ Email: qiyuekoon@foxmail.com
 * @ Data:2016/3/11
 */
public class WebViewActivity extends Activity {

    private WebView webview;
    private static final int PROGRESS_RATIO = 1000;
    public final static String EXTRA_URL = "toUrl";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webview = (WebView) findViewById(R.id.webview);


        initCreateData();
//        setWindowStatusBarColor(this,R.color.githubtitle);
    }



    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(activity.getResources().getColor(colorResId));

                //搴曢儴瀵艰埅鏍?
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void enableCustomClients() {
        this.webview.setWebViewClient(new DemoWebViewClient());/*new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            *//**
         * @param view The WebView that is initiating the callback.
         * @param url  The url of the page.
         *//*
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
               *//* if (url.contains("www.vmovier.com")) {
                   // WebViewUtils.injectCSS(EasyWebViewActivity.this, EasyWebViewActivity.this.webview, "vmovier.css");
                } else if (url.contains("video.weibo.com")) {
                 //   WebViewUtils.injectCSS(EasyWebViewActivity.this, EasyWebViewActivity.this.webview, "weibo.css");
                } else if (url.contains("m.miaopai.com")) {
                  //  WebViewUtils.injectCSS(EasyWebViewActivity.this, EasyWebViewActivity.this.webview, "miaopai.css");
                }*//*
            }
        });*/
        this.webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
//                WebViewActivity.this.webviewPb.setProgress(progress);
                setProgress(progress * PROGRESS_RATIO);
                if (progress >= 80) {
//                    WebViewActivity.this.webviewPb.setVisibility(View.GONE);
                } else {
//                    WebViewActivity.this.webviewPb.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    class DemoWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("http:") || url.startsWith("https:")) {
                return false;
            }
           /* Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);*/
//  涓嬮潰杩欎竴琛屼繚鐣欑殑鏃跺€欙紝鍘熺綉椤典粛鎶ラ敊锛屾柊缃戦〉姝ｅ父.鎵€浠ユ敞閲婃帀鍚庯紝涔熷氨娌￠棶棰樹簡
//          view.loadUrl(url);
            return true;
        }
    }

    protected void initCreateData() {
   /*     this.enableJavascript();
        this.enableCaching();*/
        this.enableCustomClients();
    /*    this.enableAdjust();
        this.zoomedOut();
*/
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//璁剧疆js鍙互鐩存帴鎵撳紑绐楀彛锛屽window.open()锛岄粯璁や负false
        webview.getSettings().setJavaScriptEnabled(true);//鏄惁鍏佽鎵цjs锛岄粯璁や负false銆傝缃畉rue鏃讹紝浼氭彁閱掑彲鑳介€犳垚XSS婕忔礊
        webview.getSettings().setSupportZoom(true);//鏄惁鍙互缂╂斁锛岄粯璁rue
        webview.getSettings().setBuiltInZoomControls(true);//鏄惁鏄剧ず缂╂斁鎸夐挳锛岄粯璁alse
        webview.getSettings().setUseWideViewPort(true);//璁剧疆姝ゅ睘鎬э紝鍙换鎰忔瘮渚嬬缉鏀俱€傚ぇ瑙嗗浘妯″紡
        webview.getSettings().setLoadWithOverviewMode(true);//鍜宻etUseWideViewPort(true)涓€璧疯В鍐崇綉椤佃嚜閫傚簲闂
        webview.getSettings().setDomStorageEnabled(true);//DOM Storage
        webview.getSettings().setTextSize(WebSettings.TextSize.NORMAL);

        this.webview.loadUrl(this.getUrl());
    }
  /*  @SuppressLint("SetJavaScriptEnabled")
    private void enableJavascript() {
        this.webview.getSettings().setJavaScriptEnabled(true);
        this.webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    }

    private void enableCaching() {\
        this.webview.getSettings().setAppCachePath(getFilesDir() + getPackageName() + "/cache");
        this.webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
    }

    private void enableAdjust() {
        this.webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.webview.getSettings().setLoadWithOverviewMode(true);
    }

    private void zoomedOut() {
        this.webview.getSettings().setLoadWithOverviewMode(true);
        this.webview.getSettings().setUseWideViewPort(true);
        this.webview.getSettings().setSupportZoom(true);
    }*/


    private String getUrl() {
        // return IntentUtils.getStringExtra(this.getIntent(), EXTRA_URL);
        return this.getIntent().getStringExtra(EXTRA_URL);
        // return "http://www.jianshu.com/c/5139d555c94d";
    }

    public static void toUrl(Context context, String url) {
        toUrl(context, url, android.R.string.untitled);
    }

    /**
     * @param context    Any context
     * @param url        A valid url to navigate to
     * @param titleResId A String resource to display as the title
     */
    public static void toUrl(Context context, String url, int titleResId) {
        toUrl(context, url, context.getString(titleResId));
    }

    /**
     * @param context Any context
     * @param url     A valid url to navigate to
     * @param title   A title to display
     */
    public static void toUrl(Context context, String url, String title) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(EXTRA_URL, url);
        //  intent.putExtra(EXTRA_TITLE, title);
        context.startActivity(intent);
    }

    /**
     * For gank api
     *
     * @param context context
     * @param url     url
     * @param title   title
     * @param type    type
     */
    public static void toUrl(Context context, String url, String title, String type) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(EXTRA_URL, url);
        // intent.putExtra(EXTRA_TITLE, title);
        // intent.putExtra(EXTRA_GANK_TYPE, type);
        context.startActivity(intent);
    }


}

