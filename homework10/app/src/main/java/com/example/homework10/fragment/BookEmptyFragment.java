package com.example.homework10.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;

import com.example.homework10.R;
import com.example.homework10.utils.DateUtil;


public class BookEmptyFragment extends Fragment implements View.OnClickListener{
    protected View mView; // 声明一个视图对象
    protected Context mContext; // 声明一个上下文对象
    private RatingBar ratingBar;
    private Group gp_content;
    private Group gp_empty;
    private TextView user;
    private TextView comment;
    private EditText et_text;
    private Button btn;
    private boolean isComment;
    public static String name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity(); // 获取活动页面的上下文
        // 根据布局文件fragment_book_cover.xml生成视图对象
        mView = inflater.inflate(R.layout.fragment_book_empty, container, false);
        ratingBar = mView.findViewById(R.id.ratingBar);
        gp_content = mView.findViewById(R.id.gp_content);
        gp_empty = mView.findViewById(R.id.gp_empty);
        user = mView.findViewById(R.id.user);
        comment = mView.findViewById(R.id.comment);
        et_text = mView.findViewById(R.id.editTextTextMultiLine);
        btn = mView.findViewById(R.id.button);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(mContext,"您的评分:"+String.valueOf(rating),Toast.LENGTH_LONG).show();
            }
        });
        btn.setOnClickListener(this);
        showCount();
        return mView;
    }
    private void showCount() {
        if (isComment == false) {
            gp_content.setVisibility(View.GONE);
            gp_empty.setVisibility(View.VISIBLE);
        } else {
            gp_content.setVisibility(View.VISIBLE);
            gp_empty.setVisibility(View.GONE);
            et_text.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        user.setText(name+"  "+DateUtil.getNowTimeDetail());
        String cm = et_text.getText().toString();
        comment.setText(cm);
        et_text.setText("");
        isComment = true;
        showCount();
    }
}

