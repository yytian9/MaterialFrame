package com.ytsky.materialframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ytsky.materialframe.R;
import com.ytsky.materialframe.base.BaseAdapter;
import com.ytsky.materialframe.holder.LoadingMoreHolder;
import com.ytsky.materialframe.holder.MyTestHolder;

import java.util.List;

/**
 * 创建者：     yytian
 * 创建时间：   2016/6/2 20:41
 * 描述：
 */
public class MyTestAdapter extends BaseAdapter {
    private List<Integer> mData;
    private Context mContext;

    private boolean mIsFooterEnable = false;//是否允许加载更多
    private boolean mIsHeaderEnable = true;//是否允许头布局

    /**
     * 标记是否正在加载更多，防止再次调用加载更多接口
     */
    private boolean mIsLoadingMore;


    /***
     * item 类型
     */
    public final static int TYPE_NORMAL = 0;
    public final static int TYPE_HEADER = 1;//头部--支持头部增加一个headerView
    public final static int TYPE_FOOTER = 2;//底部--往往是loading_more

    public MyTestAdapter(Context context, List<Integer> data) {
        this.mContext = context;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_NORMAL:

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_test, null);
                return new MyTestHolder(view);
            case TYPE_FOOTER:
                View loadingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_loading_more, null);
                return new LoadingMoreHolder(loadingView);

            default:
                break;
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + " +
                "make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_NORMAL:
                MyTestHolder myTestHolder = (MyTestHolder) holder;
                myTestHolder.setContent(mData.get(position));
                myTestHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mOnItemClickListener != null) {
                            mOnItemClickListener.onItemClick();
                        }
                    }
                });
                break;
            case TYPE_FOOTER:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        if (mData == null) {
            return TYPE_NORMAL;
        }
        return position == getItemCount() - 1 ? TYPE_FOOTER : TYPE_NORMAL;
    }

    public void addData(List<Integer> data) {
        if (data != null) {
            mData.addAll(data);
            notifyItemRemoved(getItemCount());
        }
    }

}
