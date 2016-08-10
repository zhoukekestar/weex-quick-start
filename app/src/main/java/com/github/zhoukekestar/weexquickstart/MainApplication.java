package com.github.zhoukekestar.weexquickstart;

import android.app.Application;

import com.alibaba.weex.commons.adapter.ImageAdapter;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.dom.module.WXModalUIModule;

/**
 * Created by Administrator on 8/10/2016.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        WXEnvironment.addCustomOptions("appName", "QuickStart");
        WXSDKEngine.initialize(this, null);

//        WXEnvironment.sRemoteDebugMode = false;
//        WXEnvironment.sRemoteDebugProxyUrl = "ws://10.10.2.18:8088/debugProxy/native";

        WXSDKEngine.setIWXImgLoaderAdapter(new ImageAdapter());

    }
}
