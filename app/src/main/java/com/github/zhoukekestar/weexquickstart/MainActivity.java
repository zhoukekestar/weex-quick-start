package com.github.zhoukekestar.weexquickstart;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXLogUtils;

public class MainActivity extends Activity {

    private ViewGroup mViewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WXSDKInstance mInstance = new WXSDKInstance(this);

        mViewGroup = (ViewGroup) findViewById(R.id.main_container);

        mInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                mViewGroup.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
                WXLogUtils.v("Render Success");
            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {
                WXLogUtils.v("Refresh Success");
            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {
                WXLogUtils.e("error:" + msg);
            }
        });

        String template = WXFileUtils.loadFileContent("index.js", this);
        mInstance.render("pagenmae", template, null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
    }
}
