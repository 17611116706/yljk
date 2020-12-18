package com.yljk.imdoctor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class IMDoctorUtils {

    private static IMDoctorUtils imDoctorUtils = new IMDoctorUtils();
    private Context IMContext;
    private IMDoctorUtils(){};

    public static IMDoctorUtils getInstance(){
        return  imDoctorUtils;
    }
    public void IMDoctorinit(Context context){
        IMContext = context;
    }


    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }





}
