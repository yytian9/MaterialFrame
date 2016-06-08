package com.ytsky.materialframe.base;

import android.support.v7.widget.RecyclerView;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/2 20:33
 * 描述：	   所有类的基类
 */
public abstract class BaseAdapter extends RecyclerView.Adapter{

    //****************start********点击事套餐*******************************//
    protected OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onItemClick();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener=onItemClickListener;
    }
    //****************end*********点击事套餐*******************************//


}
