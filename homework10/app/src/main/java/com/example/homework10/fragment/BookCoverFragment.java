package com.example.homework10.fragment;

import androidx.fragment.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework10.R;

public class BookCoverFragment extends Fragment {
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象
    public ImageView iv;
    public TextView tv;
    public static long mGoodsId; // 当前商品的商品编号
    public int []ima = {
            R.drawable.book_detail, R.drawable.java_d, R.drawable.cprimer_d,
            R.drawable.bczm_d, R.drawable.unity_d, R.drawable.sjzt_d,R.drawable.lyl_d, R.drawable.xxr_d
    };
    private static String[] mStr = {
            "Android Studio开发实战：从零基础到App上线（第2版）",
            "java编程思想 中文版第四版 thinking in java Java技术从入门到精通编程入门书 正版现货",
            "C++ Primer Plus(第6版)中文版 c++编程入门 正版编程书籍",
            "编程之美 微软技术面试心得 程序员面试剑指offer 程序员面试指导书籍 程序员代码面试指南",
            "【2019全新第四版】Unity 3D\\2D手机游戏开发 从学习到产品 第4版 游戏开发程序设计",
            "【12月新试卷】星火英语四级考试英语真题备考2020年12月4级英语全套试卷大学英语四级",
            "考研数学一2022李永乐历年真题大全解习题全套基础过关660题复习全书",
            "预售【2022肖秀荣全家桶】2022考研政治 精讲精练+1000题+讲真题+知识点提要形势与政策考点预测背诵肖八肖四肖秀容4肖8"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_book_cover.xml生成视图对象
        mView = inflater.inflate(R.layout.fragment_book_detail, container, false);
        iv = mView.findViewById(R.id.iv_book_detail);
        tv = mView.findViewById(R.id.tv_book_detail);
        iv.setImageDrawable(getResources().getDrawable(ima[(int)mGoodsId-1]));
        tv.setText(mStr[(int)mGoodsId-1]);
        return mView;
    }
}

