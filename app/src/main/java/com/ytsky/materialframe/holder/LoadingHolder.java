package com.ytsky.materialframe.holder;

import android.view.View;
import android.widget.TextView;

import com.ytsky.materialframe.R;
import com.ytsky.materialframe.base.BaseHolder;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/3 16:13
 * 描述：
 */
public class LoadingHolder extends BaseHolder {

    private TextView mItemLoadmoreLoading;//加载中
    private TextView mItemLoadmoreNone;//没有更多了
    private TextView mItemLoadmoreRetry;//重试，加载失败

    public static final int LOADMORE_LOADING = 0;//正在加载更多
    public static final int LOADMORE_ERROR   = 1;//加载更多失败
    public static final int LOADMORE_NONE    = 2;//没有加载更多

    public LoadingHolder(View itemView) {
        super(itemView);
        findChildView(itemView);
    }

    private void findChildView(View parent) {
        mItemLoadmoreLoading= (TextView) parent.findViewById(R.id.tv_loading);
        mItemLoadmoreNone= (TextView) parent.findViewById(R.id.tv_none);
        mItemLoadmoreRetry= (TextView) parent.findViewById(R.id.tv_retry);
    }

    //刷新视图的方法
    public void refreshHolderView(int state) {
        // 数据和视图绑定的时候会根据 state这个数据去决定我们ui的展现
        //隐藏所有的
        mItemLoadmoreLoading.setVisibility(View.GONE);
        mItemLoadmoreRetry.setVisibility(View.GONE);
        mItemLoadmoreNone.setVisibility(View.GONE);
        switch (state) {
            case LOADMORE_LOADING:
                mItemLoadmoreLoading.setVisibility(View.VISIBLE);
                break;
            case LOADMORE_ERROR:
                mItemLoadmoreRetry.setVisibility(View.VISIBLE);
                break;
            case LOADMORE_NONE:
                mItemLoadmoreNone.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
