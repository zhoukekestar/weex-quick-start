package com.github.zhoukekestar.weexquickstart;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

/**
 * Created by Administrator on 8/10/2016.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Code comes form: https://github.com/weexteam/article/issues/25
        InitConfig config = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
        WXSDKEngine.initialize(this,config);
    }
}
