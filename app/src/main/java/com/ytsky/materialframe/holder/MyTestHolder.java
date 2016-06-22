package com.ytsky.materialframe.holder;

import android.view.View;
import android.widget.TextView;

import com.ytsky.materialframe.R;
import com.ytsky.materialframe.base.BaseHolder;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/2 20:43
 * 描述：
 */
public class MyTestHolder extends BaseHolder {
    private TextView mTextView;
    public MyTestHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.tv_item);
    }
    public void setContent(int data){
        mTextView.setText(data+"");
    }

}
