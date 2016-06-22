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
public class LoadingMoreHolder extends BaseHolder {

    private TextView mItemLoading;//加载中
    private TextView mItemNone;//没有更多了
    private TextView mItemRetry;//重试，加载失败

    public static final int LOADMORE_LOADING = 0;//正在加载更多
    public static final int LOADMORE_ERROR   = 1;//加载更多失败
    public static final int LOADMORE_NONE    = 2;//没有加载更多

    public LoadingMoreHolder(View itemView) {
        super(itemView);
        findChildView(itemView);
    }

    private void findChildView(View parent) {
        mItemLoading = (TextView) parent.findViewById(R.id.tv_loading);
        mItemNone = (TextView) parent.findViewById(R.id.tv_none);
        mItemRetry = (TextView) parent.findViewById(R.id.tv_retry);
    }

    //刷新视图的方法
    public void refreshHolderView(int state) {
        // 数据和视图绑定的时候会根据 state这个数据去决定我们ui的展现
        //隐藏所有的
        mItemLoading.setVisibility(View.GONE);
        mItemRetry.setVisibility(View.GONE);
        mItemNone.setVisibility(View.GONE);
        switch (state) {
            case LOADMORE_LOADING:
                mItemLoading.setVisibility(View.VISIBLE);
                break;
            case LOADMORE_ERROR:
                mItemRetry.setVisibility(View.VISIBLE);
                break;
            case LOADMORE_NONE:
                mItemNone.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
}
