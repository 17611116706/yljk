package com.yljk.yljkproject;

import android.app.Application;
import android.content.Context;


import cn.org.bjca.sdk.core.kit.BJCASDK;
import cn.org.bjca.sdk.core.values.EnvType;
import me.jessyan.autosize.AutoSizeConfig;

public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 医网签环境设置
         * EnvType.PUBLIC为医网信正式环境
         * EnvType.INTEGRATE为集成环境
         */

        BJCASDK.getInstance().setServerUrl(EnvType.INTEGRATE);
//        if(BuildConfig.DEBUG){ //如果在debug模式下
//            // 打印日志,默认关闭
//            ARouter.openLog();
//            // 开启调试模式，默认关闭
//            ARouter.openDebug();
//            // 打印日志的时候打印线程堆栈
//            ARouter.printStackTrace();
//        }
//
//
//        ARouter.init(this);
        AutoSizeConfig.getInstance()
                .setDesignWidthInDp(375)
                .setDesignHeightInDp(863);
    }
}
