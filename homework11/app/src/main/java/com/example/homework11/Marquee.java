package com.example.homework11;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Marquee extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_marquee; // 声明一个文本视图对象
    private TextView tv_marquee1; // 声明一个文本视图对象
    private boolean isPaused = false; // 跑马灯文字是否暂停滚动
    private Button btn_login;
    protected Context mContext; // 声明一个上下文对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);
        // 从布局文件中获取名叫tv_marquee的文本视图
        btn_login = findViewById(R.id.btn_login);
        tv_marquee = findViewById(R.id.tv_marquee);

        // 给tv_marquee设置点击监听器

        tv_marquee.requestFocus(); // 强制获得焦点，让跑马灯滚起来
        btn_login.setOnClickListener(this);

    }
    @Override

    public void onClick(View v) {

        Intent intent = new Intent(this, SQLiteWriteActivity.class);
        startActivity(intent);

    }

}