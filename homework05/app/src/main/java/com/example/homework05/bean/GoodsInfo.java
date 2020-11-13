package com.example.homework05.bean;

import com.example.homework05.R;

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
            "皮卡丘", "杰尼龟","妙蛙种子","可达鸭", "飞天螳螂", "超梦", "卡比兽","喷火龙"
    };
    // 声明一个手机商品的描述数组
    private static String[] mDescArray = {
            "皮卡丘脸颊两边有着小小的电力袋。遇到危险时就会放电。会将尾巴竖起来，去感觉周围是否安全。",
            "杰尼龟可以喷水。它们是天生的游泳健将，虽然体型小，但可以使用火箭头槌、高速回转、守住、铁壁、缩壳等技能",
            "妙蛙种子可以学会大量的草系技能，类似寄生种子､藤鞭､飞叶快刀､花之舞､叶暴风､能量鞭打､种子机关枪等｡",
            "可达鸭平时经常头痛，这使它经常忘记事情。可达鸭完全不具有进攻性，神情经常处于呆滞状态。",
            "飞天螳螂是一种两足的昆虫生物。在它爬行动物般头的上面有三个分立的角，前臂是两只用于捕猎以及战斗的白色大镰刀。",
            "超梦可以随心所欲地使用诸如远程移物、操纵天候、意念造物、时间回溯、修改记忆、控制他人思想等各种超能力。",
            "卡比兽，睡觉宝可梦。只要它吃得很饱，就会懒散到不肯动手指，此时坐在它的肚子上也没关系。",
            "喷火龙可以飞，可以使用许多的飞行系技能，但不是龙系，它却有龙系的技能，如龙爪，龙吸，龙之怒等"
    };
    // 声明一个手机商品的价格数组
    private static float[] mPriceArray = {1000, 800, 1200, 100, 2000, 9999,3000,5000};
    // 声明一个手机商品的小图数组
    private static int[] mThumbArray = {
            R.drawable .pika, R.drawable.jieni, R.drawable.miaowa,R.drawable.keda,R.drawable.tanglang,
            R.drawable.menhuan, R.drawable.kabi, R.drawable.penhuo
    };
    // 声明一个手机商品的大图数组
    private static int[] mPicArray = {
            R.drawable .pikaa, R.drawable.jienia,R.drawable.miaowaa,R.drawable.kedaa,R.drawable.tanglanga,
            R.drawable.menhuana, R.drawable.kabia, R.drawable.penhuoa
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