package com.example.homework05.bean;

import com.example.homework05.R;

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

    private static int[] iconArray = {R.drawable.pika, R.drawable.jieni, R.drawable.miaowa,
            R.drawable.keda, R.drawable.tanglang, R.drawable.menhuan,R.drawable.kabi,R.drawable.penhuo};
    private static String[] nameArray = {"皮卡丘", "杰尼龟","妙蛙种子","可达鸭", "飞天螳螂", "超梦", "卡比兽","喷火龙"};
    private static String[] descArray = {
            "皮卡丘脸颊两边有着小小的电力袋。遇到危险时就会放电。会将尾巴竖起来，去感觉周围是否安全。",
            "杰尼龟可以喷水。它们是天生的游泳健将，虽然体型小，但可以使用火箭头槌、高速回转、守住、铁壁、缩壳等技能",
            "妙蛙种子可以学会大量的草系技能，类似寄生种子､藤鞭､飞叶快刀､花之舞､叶暴风､能量鞭打､种子机关枪等｡",
            "可达鸭平时经常头痛，这使它经常忘记事情。可达鸭完全不具有进攻性，神情经常处于呆滞状态。",
            "飞天螳螂是一种两足的昆虫生物。在它爬行动物般头的上面有三个分立的角，前臂是两只用于捕猎以及战斗的白色大镰刀。",
            "超梦可以随心所欲地使用诸如远程移物、操纵天候、意念造物、时间回溯、修改记忆、控制他人思想等各种超能力。",
            "卡比兽，睡觉宝可梦。只要它吃得很饱，就会懒散到不肯动手指，此时坐在它的肚子上也没关系。",
            "喷火龙可以飞，可以使用许多的飞行系技能，但不是龙系，它却有龙系的技能，如龙爪，龙吸，龙之怒等"
    };

    public static ArrayList<Planet> getDefaultList() {
        ArrayList<Planet> planetList = new ArrayList<Planet>();
        for (int i = 0; i < iconArray.length; i++) {
            planetList.add(new Planet(iconArray[i], nameArray[i], descArray[i]));
        }
        return planetList;
    }
}
