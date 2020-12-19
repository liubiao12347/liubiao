package com.example.homework10.bean;

import com.example.homework10.R;

import java.util.ArrayList;

public class Planet {

    public int image;
    public String name;
    public String desc;

    public Planet(int image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    private static int[] iconArray = {R.drawable.androidstudio, R.drawable.java, R.drawable.cprimer,
            R.drawable.bczm, R.drawable.unity, R.drawable.sjzt,R.drawable.lyl, R.drawable.xxr};
    private static String[] nameArray = {"安卓开发", "Java编程", "C++入门", "编程之美", "游戏开发", "四级真题", "李永乐系列", "考研政治"};
    private static String[] descArray = {
            "Android Studio开发实战：从零基础到App上线（第2版）",
            "java编程思想 中文版第四版 thinking in java Java技术从入门到精通编程入门书 正版现货",
            "C++ Primer Plus(第6版)中文版 c++编程入门 正版编程书籍",
            "编程之美 微软技术面试心得 程序员面试剑指offer 程序员面试指导书籍 程序员代码面试指南",
            "【2019全新第四版】Unity 3D\\2D手机游戏开发 从学习到产品 第4版 游戏开发程序设计",
            "【12月新试卷】星火英语四级考试英语真题备考2020年12月4级英语全套试卷大学英语四级",
            "考研数学一2022李永乐历年真题大全解习题全套基础过关660题复习全书",
            "预售【2022肖秀荣全家桶】2022考研政治 精讲精练+1000题+讲真题+知识点提要形势与政策考点预测背诵肖八肖四肖秀容4肖8"
    };

    public static ArrayList<Planet> getDefaultList() {
        ArrayList<Planet> planetList = new ArrayList<Planet>();
        for (int i = 0; i < iconArray.length; i++) {
            planetList.add(new Planet(iconArray[i], nameArray[i], descArray[i]));
        }
        return planetList;
    }
}

