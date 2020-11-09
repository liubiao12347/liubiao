package com.example.homework04a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework04a.bean.UserInfo;
import com.example.homework04a.database.UserDBHelper;
import com.example.homework04a.util.DateUtil;
import com.example.homework04a.util.ViewUtil;

public class SDCardInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard_info);

        getEnvironmentInfo();
    }

    // 显示系统目录的环境信息
    private void getEnvironmentInfo() {
        TextView tv_sdcard_info = findViewById(R.id.tv_sdcard_info);
        String desc = "系统环境（含SD卡）的信息如下：";
        desc = String.format("%s\n　根目录路径：%s", desc,
                Environment.getRootDirectory().getAbsolutePath());
        desc = String.format("%s\n　数据目录路径：%s", desc,
                Environment.getDataDirectory().getAbsolutePath());
        desc = String.format("%s\n　下载缓存目录路径：%s", desc,
                Environment.getDownloadCacheDirectory().getAbsolutePath());
        desc = String.format("%s\n　外部存储(即SD卡)目录路径：%s", desc,
                Environment.getExternalStorageDirectory().getAbsolutePath());
        desc = String.format("%s\n　外部存储(即SD卡)状态：%s", desc,
                Environment.getExternalStorageState());
        desc = String.format("%s\n　SD卡的相机目录路径：%s", desc,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
        // DIRECTORY_DOCUMENTS是Android4.4.2（SDK19）及以上版本才有的常量
        // 如果不做SDK版本判断，那么在低版本Android(例如4.2.2)上运行会报错
        // java.lang.NoSuchFieldError: android.os.Environment.DIRECTORY_DOCUMENTS
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            desc = String.format("%s\n　SD卡的文档目录路径：%s", desc,
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
        }
        desc = String.format("%s\n　SD卡的下载目录路径：%s", desc,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        desc = String.format("%s\n　SD卡的图片目录路径：%s", desc,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        desc = String.format("%s\n　SD卡的视频目录路径：%s", desc,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
        desc = String.format("%s\n　SD卡的音乐目录路径：%s", desc,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));

        // 获取系统的公共存储路径
        desc = String.format("%s\n\n　系统的公共存储路径位于：%s", desc,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        // 获取当前App的私有存储路径
        desc = String.format("%s\n　当前App的私有存储路径位于：%s\n\n　Android7.0之后默认禁止访问公共存储目录", desc,getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));

        tv_sdcard_info.setText(desc);
    }

    public static class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
        private static final String TAG = "RegisterActivity"; //Log提示信息
        private EditText et_registerpassword; // 声明一个编辑框对象
        private EditText et_registerphone; // 声明一个编辑框对象
        private EditText et_registername; // 声明一个编辑框对象
        private Button bt_register;
        private TextView sp_registername;
        private TextView sp_registerphone;
        private TextView sp_registerpassword;

        private UserDBHelper myHelper; // 声明一个用户数据库的帮助器对象
        private int myRequestCode = 0; // 跳转页面时的请求代码

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            sp_registername = findViewById(R.id.sp_registername);
            et_registername = findViewById(R.id.et_registername);
            sp_registerphone = findViewById(R.id.sp_registerphone);
            et_registerphone = findViewById(R.id.et_registerphone);
            sp_registerpassword = findViewById(R.id.sp_registerpassword);
            et_registerpassword = findViewById(R.id.et_registerpassword);
            bt_register = findViewById(R.id.bt_register);

            // 给et_registerphone添加文本变更监听器
            et_registerphone.addTextChangedListener(new HideTextWatcher(et_registerphone));
            // 给et_registerpassword添加文本变更监听器
            et_registerpassword.addTextChangedListener(new HideTextWatcher(et_registerpassword));

            bt_register.setOnClickListener((View.OnClickListener) this);
        }

        // 定义编辑框的文本变化监听器
        private class HideTextWatcher implements TextWatcher {
            private EditText myView;// 声明一个编辑框对象
            private int myMaxLength;// 声明一个最大长度变量
            private CharSequence myStr; // 声明一个文本串

            HideTextWatcher(EditText v) {
                super();
                myView = v;
                myMaxLength = ViewUtil.getMaxLength(v);
            }

            // 在编辑框的输入文本变化前触发
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            // 在编辑框的输入文本变化时触发
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myStr = s;
            }

            // 在编辑框的输入文本变化后触发
            public void afterTextChanged(Editable s) {
                if (myStr == null || myStr.length() == 0)
                    return;
                // 输入文本达到11位（如手机号码）时关闭输入法
                if (myStr.length() == 11 && myMaxLength == 11) {
                    ViewUtil.hideAllInputMethod(RegisterActivity.this);
                }
                // 输入文本达到6位（如登录密码）时关闭输入法
                if (myStr.length() == 8 && myMaxLength == 8) {
                    ViewUtil.hideOneInputMethod(RegisterActivity.this, myView);
                }
                if (myStr.length() == 6 && myMaxLength == 6) {
                    ViewUtil.hideOneInputMethod(RegisterActivity.this, myView);
                }
            }
        }


        private void showToast(String desc) {
            Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
        }

        public void onClick(View v) {
            if (v.getId() == R.id.bt_register) {
                String name = et_registername.getText().toString();
                String phone = et_registerphone.getText().toString();
                String pwd = et_registerpassword.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    showToast("请输入姓名");
                    return;
                } else if (TextUtils.isEmpty(phone)) {
                    showToast("请输入手机号码");
                    return;
                } else if (TextUtils.isEmpty(pwd)) {
                    showToast("请输入密码");
                    return;
                }

                // 以下声明一个用户信息对象，并填写它的各字段值
                UserInfo info = new UserInfo();
                info.name = name;
                info.phone = phone;
                info.pwd = pwd;
                info.update_time = DateUtil.getNowDateTime("yyyy-MM-dd HH:mm:ss");

                // 执行数据库帮助器的插入操作
                myHelper.insert(info);
                showToast("数据已写入SQLite数据库");

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }

        protected void onStart() {
            Log.d(TAG, "onStart: openLink");
            super.onStart();
            // 获得数据库帮助器的实例
            myHelper = UserDBHelper.getInstance(this, 1);
            // 打开数据库帮助器的写连接
            myHelper.openWriteLink();
            // 打开数据库帮助器的读连接
            myHelper.openReadLink();
        }

        @Override
        protected void onStop() {
            Log.d(TAG, "onStop: closeLink");
            super.onStop();
            // 关闭数据库连接
            myHelper.closeLink();
        }
    }
}