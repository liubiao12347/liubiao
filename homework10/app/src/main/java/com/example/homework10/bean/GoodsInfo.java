package com.example.homework10.bean;

import com.example.homework10.R;

import java.util.ArrayList;

public class GoodsInfo {
    public long rowid; // 行号
    public int sn; // 序号
    public String name; // 名称
    public String desc; // 描述
    public float price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号

    public GoodsInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "安卓开发", "Java编程", "C++入门", "编程之美", "游戏开发", "四级真题", "李永乐系列", "考研政治"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "Android Studio开发实战：从零基础到App上线（第2版）",
            "java编程思想 中文版第四版 thinking in java Java技术从入门到精通编程入门书 正版现货",
            "C++ Primer Plus(第6版)中文版 c++编程入门 正版编程书籍",
            "编程之美 微软技术面试心得 程序员面试剑指offer 程序员面试指导书籍 程序员代码面试指南",
            "【2019全新第四版】Unity 3D\\2D手机游戏开发 从学习到产品 第4版 游戏开发程序设计",
            "【12月新试卷】星火英语四级考试英语真题备考2020年12月4级英语全套试卷大学英语四级",
            "考研数学一2022李永乐历年真题大全解习题全套基础过关660题复习全书",
            "预售【2022肖秀荣全家桶】2022考研政治 精讲精练+1000题+讲真题+知识点提要形势与政策考点预测背诵肖八肖四肖秀容4肖8"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {69.50f, 75.6f, 59.0f, 39.5f, 75.8f, 29.9f, 49.9f, 225.0f};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.androidstudio_s, R.drawable.java_s, R.drawable.cprimer_s,
            R.drawable.bczm_s, R.drawable.unity_s, R.drawable.sjzt_s, R.drawable.lyl_s, R.drawable.xxr_s
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.androidstudio, R.drawable.java, R.drawable.cprimer,
            R.drawable.bczm, R.drawable.unity, R.drawable.sjzt,R.drawable.lyl, R.drawable.xxr
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodsInfo info = new GoodsInfo();
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.thumb = mThumbArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }

}
