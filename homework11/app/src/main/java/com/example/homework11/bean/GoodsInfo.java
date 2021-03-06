package com.example.homework11.bean;

import com.example.homework11.R;

import java.util.ArrayList;

public class GoodsInfo {
    public int pic_id;
    public String title;
    public String desc;
    public boolean bPressed;
    public int id;
    private static int seq = 0;

    public GoodsInfo(int pic_id, String title, String desc) {
        this.pic_id = pic_id;
        this.title = title;
        this.desc = desc;
        this.bPressed = false;
        this.id = this.seq;
        this.seq++;
    }

    private static int[] listImageArray = {
            R.drawable.public_01, R.drawable.public_02
            , R.drawable.public_03, R.drawable.public_04, R.drawable.public_05};
    private static String[] listTitleArray = {
            "首都日报", "海峡时报", "北方周末", "参照消息", "挨踢杂志"};
    private static String[] listDescArray = {
            "金秋时节香山染红，市民纷纷登山赏叶",
            "台风接踵而来，出门小心暴雨",
            "俄罗斯老人在东北，生活滋润乐不思蜀",
            "蒙内铁路建成通车，中国标准再下一城",
            "米6大战Mate10，千元智能机谁领风骚"};

    public static ArrayList<GoodsInfo> getDefaultList() {
        ArrayList<GoodsInfo> listArray = new ArrayList<GoodsInfo>();
        for (int i = 0; i < listImageArray.length; i++) {
            listArray.add(new GoodsInfo(listImageArray[i], listTitleArray[i], listDescArray[i]));
        }
        return listArray;
    }

    private static int[] gridImageArray = {
            R.drawable.pic_01, R.drawable.pic_02, R.drawable.pic_03,
            R.drawable.pic_04, R.drawable.pic_05, R.drawable.pic_06,
            R.drawable.pic_07, R.drawable.pic_08, R.drawable.pic_09,
            R.drawable.pic_10};
    private static String[] gridTitleArray = {
            "商场", "超市", "百货",
            "便利店", "地摊", "食杂店",
            "饭店", "餐厅", "会所", "菜市场"};

    public static ArrayList<GoodsInfo> getDefaultGrid() {
        ArrayList<GoodsInfo> gridArray = new ArrayList<GoodsInfo>();
        for (int i = 0; i < gridImageArray.length; i++) {
            gridArray.add(new GoodsInfo(gridImageArray[i], gridTitleArray[i], null));
        }
        return gridArray;
    }

    private static int[] stagImageArray = {
            R.drawable.earrings_1, R.drawable.earrings_2, R.drawable.earrings_3,
            R.drawable.earrings_4, R.drawable.earrings_5, R.drawable.earrings_6,
            R.drawable.earrings_7, R.drawable.earrings_8, R.drawable.earrings_9,
            R.drawable.earrings_10, R.drawable.earrings_11, R.drawable.earrings_12,
            R.drawable.earrings_13, R.drawable.earrings_14, R.drawable.earrings_15,
            R.drawable.earrings_16, R.drawable.earrings_17, R.drawable.earrings_18,
            R.drawable.earrings_19, R.drawable.earrings_20, R.drawable.earrings_21,
            R.drawable.earrings_22, R.drawable.earrings_23};
    private static String[] stagTitleArray = {
            "奈良鹿丸", "旗木卡卡西", "宇智波鼬",
            "雏田樱乃", "忍犬卡卡西", "漩涡鸣人",
            "Q版九尾", "纲手婆婆", "九尾妖狐",
            "宇智波斑", "宇智波佐助一版", "宇智波佐助二版",
            "宇智波佐助三版", "暗部雏田樱乃", "雷切卡卡西",
            "热血卡卡西", "暗部卡卡西", "千手纲手",
            "六道漩涡鸣人", "雷传卡卡西", "卡卡西",
            "宇智波斑", "长大漩涡鸣人"};

    public static ArrayList<GoodsInfo> getDefaultStag() {
        ArrayList<GoodsInfo> stagArray = new ArrayList<GoodsInfo>();
        for (int i = 0; i < stagImageArray.length; i++) {
            stagArray.add(new GoodsInfo(stagImageArray[i], stagTitleArray[i], null));
        }
        return stagArray;
    }

    private static int[] combineImageArray = {
            R.drawable.cainixihuan, R.drawable.dapaijiadao
            , R.drawable.trip_01, R.drawable.trip_02, R.drawable.trip_03, R.drawable.trip_04};
    private static String[] combineTitleArray = {
            "猜你喜欢", "大牌驾到", "买哪个", "别想了", "先下单", "包你满意"};

    public static ArrayList<GoodsInfo> getDefaultCombine() {
        ArrayList<GoodsInfo> combineArray = new ArrayList<GoodsInfo>();
        for (int i = 0; i < combineImageArray.length; i++) {
            combineArray.add(new GoodsInfo(combineImageArray[i], combineTitleArray[i], null));
        }
        return combineArray;
    }

    private static int[] appiImageArray = {R.drawable.dian01, R.drawable.dian02, R.drawable.dian03
            , R.drawable.dian04, R.drawable.dian05, R.drawable.dian06, R.drawable.dian07
            , R.drawable.dian08, R.drawable.dian09, R.drawable.dian10, R.drawable.dian11
            , R.drawable.dian12, R.drawable.dian13, R.drawable.dian14, R.drawable.dian15};
    private static String[] appiTitleArray = {"双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "包安装", "再返券",
            "白送你", "想得美", "干活去", "好好学", "才有钱"};

    public static ArrayList<GoodsInfo> getDefaultAppi() {
        ArrayList<GoodsInfo> appiArray = new ArrayList<GoodsInfo>();
        for (int i = 0; i < appiImageArray.length; i++) {
            appiArray.add(new GoodsInfo(appiImageArray[i], appiTitleArray[i], null));
        }
        return appiArray;
    }

}