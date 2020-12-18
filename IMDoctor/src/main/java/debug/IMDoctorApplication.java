package debug;

import android.app.Application;

import com.yljk.imdoctor.BuildConfig;
import com.yljk.imdoctor.IMDoctorUtils;

import me.jessyan.autosize.AutoSizeConfig;

public class IMDoctorApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if(BuildConfig.DEBUG){ //如果在debug模式下
//            // 打印日志,默认关闭
//            ARouter.openLog();
//            // 开启调试模式，默认关闭(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//            ARouter.openDebug();
//            // 打印日志的时候打印线程堆栈
//            ARouter.printStackTrace();
//        }
//
//        // 尽可能早，推荐在Application中初始化
//        ARouter.init(this);
        AutoSizeConfig.getInstance()
                    .setDesignWidthInDp(375)
                    .setDesignHeightInDp(863);
        IMDoctorUtils.getInstance()
                     .IMDoctorinit(this);
    }
}
