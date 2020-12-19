package com.example.homework11.bean;

import com.example.homework11.R;

import java.util.ArrayList;

public class GoodInfo {
    public long rowid; // 行号
    public int sn; // 序号
    public String name; // 名称
    public String desc; // 描述
    public float price; // 价格
    public String thumb_path; // 小图的保存路径
    public String pic_path; // 大图的保存路径
    public int thumb; // 小图的资源编号
    public int pic; // 大图的资源编号
    public String eva;
    public GoodInfo() {
        rowid = 0L;
        sn = 0;
        name = "";
        desc = "";
        price = 0;
        thumb_path = "";
        pic_path = "";
        eva="";
        thumb = 0;
        pic = 0;
    }

    // 声明一个手机商品的名称数组
    private static String[] mNameArray = {
            "motorcycle", "Aircraft carrier", "Necklace", "Bicycle", "Garage Kit", "excavating machinery","snake","vans"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "motorcycle 骑上它，享受风驰电掣的快感",
            "Aircraft carrier 辽宁号原版模型，拥有它，睡觉都觉得踏实",
            "Necklace 民族特色，戴上它，体会异域风情",
            "Bicycle 二八自行车，嘎嘎新买到就是赚到",
            "Garage Kit 还记得你童年想成为的超级英雄么",
            "excavating machinery 挖掘机销售哪家好，刘彪作业不好找",
            "snake  性感玩具蛇在线钓鱼",
            "vans 玩出你的花样，秀出你的vans"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {48, 7999, 84, 99, 9798, 442, 798, 59};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable.balm_s, R.drawable.computer_s,
            R.drawable.eardrop_s, R.drawable.lipstick_s,
            R.drawable.meizu_s, R.drawable.ukulele_s,
            R.drawable.watches_s, R.drawable.wine_s
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable.balm, R.drawable.computer,
            R.drawable.eardrop, R.drawable.lipstick,
            R.drawable.meizu, R.drawable.ukulele,
            R.drawable.watches, R.drawable.wine
    };

    // 获取默认的手机信息列表
    public static ArrayList<GoodInfo> getDefaultList() {
        ArrayList<GoodInfo> goodsList = new ArrayList<GoodInfo>();
        for (int i = 0; i < mNameArray.length; i++) {
            GoodInfo info = new GoodInfo();
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