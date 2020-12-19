package com.example.homework10.fragment;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homework10.MainActivity;
import com.example.homework10.R;
import com.example.homework10.ShoppingCartActivity;
import com.example.homework10.bean.CartInfo;
import com.example.homework10.bean.GoodsInfo;
import com.example.homework10.database.CartDBHelper;
import com.example.homework10.database.GoodsDBHelper;
import com.example.homework10.utils.DateUtil;
import com.example.homework10.utils.SharedUtil;

public class BookDetailFragment extends Fragment implements View.OnClickListener{
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象
    private TextView tv_title;
    private TextView tv_count;
    private TextView tv_goods_price;
    private TextView tv_goods_desc;
    private ImageView iv_goods_pic;
    private int mCount; // 购物车中的商品数量
    public static long mGoodsId; // 当前商品的商品编号
    private GoodsDBHelper mGoodsHelper; // 声明一个商品数据库的帮助器对象
    private CartDBHelper mCartHelper; // 声明一个购物车数据库的帮助器对象

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_book_detail.xml生成视图对象
        mView = inflater.inflate(R.layout.activity_shopping_detail, container, false);
        tv_title = mView.findViewById(R.id.tv_title);
        tv_count = mView.findViewById(R.id.tv_count);
        tv_goods_price = mView.findViewById(R.id.tv_goods_price);
        tv_goods_desc = mView.findViewById(R.id.tv_goods_desc);
        iv_goods_pic = mView.findViewById(R.id.iv_goods_pic);

        mView.findViewById(R.id.iv_cart).setOnClickListener(this);
        mView.findViewById(R.id.btn_add_cart).setOnClickListener(this);
        return mView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_cart) { // 点击了购物车图标
            // 跳转到购物车页面
            Intent intent = new Intent(mContext, ShoppingCartActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_add_cart) { // 点击了“添加”按钮
            // 把该商品添加到购物车
            addToCart(mGoodsId);
            Toast.makeText(mContext, "成功添加至购物车", Toast.LENGTH_SHORT).show();
        }
    }
    // 把指定编号的商品添加到购物车
    private void addToCart(long goods_id) {
        mCount++;
        tv_count.setText("" + mCount);
        // 把购物车中的商品数量写入共享参数
        SharedUtil.getIntance(mContext).writeShared("count", "" + mCount);
        // 根据商品编号查询购物车中的商品记录
        CartInfo info = mCartHelper.queryByGoodsId(goods_id);
        if (info != null) { // 购物车已存在该商品记录
            info.count++; // 该商品的数量加一
            info.update_time = DateUtil.getNowDateTime("");
            // 更新购物车数据库中的商品记录信息
            mCartHelper.update(info);
        } else { // 购物车不存在该商品记录
            info = new CartInfo();
            info.goods_id = goods_id;
            info.count = 1;
            info.update_time = DateUtil.getNowDateTime("");
            // 往购物车数据库中添加一条新的商品记录
            mCartHelper.insert(info);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // 获取共享参数保存的购物车中的商品数量
        mCount = Integer.parseInt(SharedUtil.getIntance(mContext).readShared("count", "0"));
        tv_count.setText("" + mCount);
        // 获取商品数据库的帮助器对象
        mGoodsHelper = GoodsDBHelper.getInstance(mContext, 1);
        // 打开商品数据库的读连接
        mGoodsHelper.openReadLink();
        // 获取购物车数据库的帮助器对象
        mCartHelper = CartDBHelper.getInstance(mContext, 1);
        // 打开购物车数据库的写连接
        mCartHelper.openWriteLink();
        // 展示商品详情
        showDetail();
    }

    @Override
    public void onPause() {
        super.onPause();
        // 关闭商品数据库的数据库连接
        mGoodsHelper.closeLink();
        // 关闭购物车数据库的数据库连接
        mCartHelper.closeLink();
    }

    private void showDetail() {
        // 获取前一个页面传来的商品编号
        if (mGoodsId > 0) {
            // 根据商品编号查询商品数据库中的商品记录
            GoodsInfo info = mGoodsHelper.queryById(mGoodsId);
            tv_title.setText(info.name);
            tv_goods_desc.setText(info.desc);
            tv_goods_price.setText("" + info.price);
            // 从指定路径读取图片文件的位图数据
            Bitmap pic = BitmapFactory.decodeFile(info.pic_path);
            iv_goods_pic.setImageBitmap(pic);
        }
    }


}

