package com.github.zhoukekestar.weexquickstart;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

public class MainActivity extends Activity implements IWXRenderListener  {

    private static final String TAG = "MainActivity";
    private static WXSDKInstance mInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstance = new WXSDKInstance(this);
        mInstance.registerRenderListener(this);

        // WeexSDK 0.5.1
//        mInstance.render("WeexQuickStart", WXFileUtils.loadFileContent("weex/index.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);

        // WeexSDK 0.8.0.1
        mInstance.render("WeexQuickStart", WXFileUtils.loadAsset("weex/index.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onViewCreated(WXSDKInstance wxsdkInstance, View view) {
        Log.v(TAG, "onViewCreated");
        setContentView(view);
        Toast.makeText(MainActivity.this, "onViewCreated", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {
        Log.v(TAG, "onRenderSuccess");
        Toast.makeText(MainActivity.this, "onRenderSuccess", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefreshSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {
        Log.v(TAG, "onRefreshSuccess");
        Toast.makeText(MainActivity.this, "onRefreshSuccess", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

        Log.v(TAG, "onException errCode:" + errCode + " msg:" + msg);
        Toast.makeText(MainActivity.this, "ERROR  errCode:" + errCode + " msg:" + msg, Toast.LENGTH_LONG).show();
    }
}
