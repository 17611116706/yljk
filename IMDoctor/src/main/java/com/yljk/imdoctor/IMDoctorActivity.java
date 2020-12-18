package com.yljk.imdoctor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import crossoverone.statuslib.StatusUtil;
public class IMDoctorActivity extends AppCompatActivity {
    private Button sendTalking;
    private EditText sendWriting;
    private ImageView writeChangeVoice;
    private boolean isChange = true;
    private RelativeLayout imDoctorTitlebar;
    private RecyclerView imDoctorList;
    private InputMethodManager imm;
    private LinearLayout imDoctorOutside;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imdoctor);
        //沉浸式布局
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //状态栏信息设置-黑色
        StatusUtil.setSystemStatus(this,true,true);
        //状态栏背景设置-白色
        StatusUtil.setUseStatusBarColor(this,Color.WHITE);
        initView();
        //根据状态栏高度调整UI布局
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        imDoctorTitlebar.measure(w, h);
        int height = imDoctorTitlebar.getMeasuredHeight();
        LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) imDoctorTitlebar.getLayoutParams();
        int statusBarHeight = IMDoctorUtils.getInstance().getStatusBarHeight(this);
        params.height = height-statusBarHeight;
        imDoctorTitlebar.setLayoutParams(params);

        //外部区域点击 关闭系统软键盘
        imDoctorOutside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(sendWriting.getWindowToken(), 0); //强制隐藏键盘
            }
        });
        //语音发送识别
        sendTalking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IMDoctorActivity.this, "发送消息", Toast.LENGTH_SHORT).show();
            }
        });
        //语音 输入切换
        writeChangeVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                boolean isOpen=imm.isActive();//isOpen若返回true，则表示输入法打开
                if (isChange){
                    change_write();
                    if (!isOpen){
                        imm.showSoftInput(sendWriting,InputMethodManager.SHOW_FORCED);
                    }
                }else{
                    change_voice();
                    imm.hideSoftInputFromWindow(sendWriting.getWindowToken(), 0); //强制隐藏键盘
                }
            }
        });
    }

    private void initView() {
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imDoctorList = findViewById(R.id.im_doctor_list);
        imDoctorTitlebar = findViewById(R.id.im_doctor_titlebar);
        writeChangeVoice = findViewById(R.id.write_change_voice);//语音 输入切换
        sendWriting = findViewById(R.id.send_writing);//文本输入
        sendTalking = findViewById(R.id.send_talking);//长按发送
        imDoctorOutside = findViewById(R.id.im_doctor_outside);
    }

    //语音输入模式切换
    private void change_voice(){
        writeChangeVoice.setBackground(getResources().getDrawable(R.drawable.im_doctor_write));
        sendTalking.setVisibility(View.VISIBLE);
        sendWriting.setVisibility(View.GONE);
        isChange = true;
    }
    //文字输入模式切换
    private void change_write(){
        writeChangeVoice.setBackground(getResources().getDrawable(R.drawable.im_doctor_to_voice));
        sendTalking.setVisibility(View.GONE);
        sendWriting.setVisibility(View.VISIBLE);
        isChange = false;
    }

}