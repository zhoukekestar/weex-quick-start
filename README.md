## Weex-Quick-Start
该项目为Weex的Quick-Start项目，使用过程中如果有更好的样例或者，能把代码解释得更详细的，更清楚的，欢迎提PR，我会尽量merge的^-^.

## app/libs，复制libs
app/libs下有`inspector-[debug/release].aar`,`weex_debug-[debug/release].aar`,`weex_sdk-[debug/release].aar`等6个文件

所有的文件都可以从weex项目下build文件夹下找到（当然需要之前编译过才行）[参考文章](http://blog.csdn.net/getchance/article/details/47257389)

比如：以我当前电脑环境为例，我的weex项目clone在`D:\Temp-Doc\weex\weex-repo`目录下。

所以在运行过playground后，可以在`D:\Temp-Doc\weex\weex-repo\android\sdk\build\outputs\aar`找到`weex_sdk-[debug/release].aar`

ps: 不想运行playground的同学，可以直接clone当前项目，在当前项目`app/libs`下有上传aar文件


## MainApplication.class
初始化SDKEngine
```java
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        WXEnvironment.addCustomOptions("appName", "QuickStart");
        WXSDKEngine.initialize(this, null);

        WXSDKEngine.setIWXImgLoaderAdapter(new ImageAdapter());

    }
}
```
写完后，别忘了在`AndroidManifest.xml`设置application的name属性
```xml
<application
    android:name=".MainApplication"
    ...
```

## MainActivity.class
大部分代码直接看吧，主要是下面几句，将assets中的index.js（这个是.we文件编译后的js文件）作为template，并渲染
```java
String template = WXFileUtils.loadFileContent("index.js", this);
mInstance.render("pagenmae", template, null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);

```

## AndroidManifest.xml
```xml
 <uses-permission android:name="android.permission.INTERNET" /> // 各种权限，能写的都写上吧。。。
 <application
       android:name=".MainApplication"
       tools:overrideLibrary="com.taobao.android.dexposed"  // 重写库，需要引入com.taobao.android:dexposed:0.1.8依赖
       android:allowBackup="false"                          // 由于上面的重写，这里需要设置false
       android:icon="@mipmap/ic_launcher"
       android:label="@string/app_name"
       android:supportsRtl="true"
       android:theme="@style/AppTheme">

       <activity android:name=".MainActivity">
           <intent-filter>
               <action android:name="android.intent.action.MAIN" />

               <category android:name="android.intent.category.LAUNCHER" />
           </intent-filter>
       </activity>
   </application>
```

## build.gradle

设置libs文件，采用方式1（即自定义aar方式）引入SDK时需要使用，采用其他方式可注释掉
```gradle
repositories {
    flatDir {
        dirs project(':app').file('libs')
    }
}
```
引入weex-sdk，我采用了3种方式，自定义aar、以module方式引入sdk目录、官方发布aar
```gradle

// 方式1：SDK 自定义arr引入（构建playground的时候会在weex\android\sdk\build\outputs\aar\weex_sdk-release.aar）
compile(name:'weex_sdk-release', ext:'aar')

// 方式2：SDK 目录引入
// compile project(':weex_sdk')

// 方式3：SDK 官方发布引入，官方会发布SDK到jcenter
// compile 'com.taobao.android:weex_sdk:0.6.1'

```

## settings.gradle
采用方式2（即引入sdk目录自己构建的时候）引入WEEX_SDK时需要，其他方式可注释掉。。。
```gradle
include ":weex_sdk"
project(":weex_sdk").projectDir = new File("D:\\Temp-Doc\\weex\\weex-repo\\android\\sdk")
// 采用方式2（即引入sdk目录自己构建的时候）引入WEEX_SDK时需要
// ../weex-repo/android/sdk 目录为 https://github.com/alibaba/weex/tree/dev/android/sdk 在本地的目录
```

## Errors
我刚开始，貌似有个jsframework未初始化的错误
```bash
08-13 10:13:49.187 5490-5508/com.github.zhoukekestar.weexquickstart E/weex: [WXBridgeManager] invokeCreateInstance: framework.js uninitialized. // 这边有个错误
08-13 10:13:49.187 5490-5508/com.github.zhoukekestar.weexquickstart D/weex: WXDebugTool not found!
08-13 10:13:49.187 5490-5508/com.github.zhoukekestar.weexquickstart D/weex: WXDebugTool not found!
08-13 10:13:49.187 5490-5508/com.github.zhoukekestar.weexquickstart D/weex: framework from assets
08-13 10:13:49.207 5490-5508/com.github.zhoukekestar.weexquickstart D/weex: WXDebugTool not found!
08-13 10:13:49.217 5490-5508/com.github.zhoukekestar.weexquickstart D/weex: WXDebugTool not found!
08-13 10:13:49.317 5490-5490/com.github.zhoukekestar.weexquickstart D/OpenGLRenderer: Enabling debug mode 0
08-13 10:13:49.347 5490-5490/com.github.zhoukekestar.weexquickstart E/weex: error:createInstance fail! // 错误，然后，无法正常显示
```
解决方案：
Build->Clean Project，然后再次运行，就好了==

## Pics
![样例截屏](./assets/demo.png)
