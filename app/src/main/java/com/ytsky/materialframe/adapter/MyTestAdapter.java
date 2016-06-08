package com.ytsky.materialframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ytsky.materialframe.R;
import com.ytsky.materialframe.base.BaseAdapter;
import com.ytsky.materialframe.holder.LoadingHolder;
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

    public static final int LOADING_TYPE = 1;
    public static final int SPECIAL_TYPE = 2;

    public MyTestAdapter(Context context, List<Integer> data) {
        this.mContext = context;
        mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SPECIAL_TYPE:

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_test, null);
                return new MyTestHolder(view);
            case LOADING_TYPE:
                View loadingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_loading_more, null);
                return new LoadingHolder(loadingView);

            default:
                break;
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " + " +
                "make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case SPECIAL_TYPE:
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
            case LOADING_TYPE:

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
            return SPECIAL_TYPE;
        }
        return position == getItemCount()-1  ? LOADING_TYPE : SPECIAL_TYPE;
    }

    public void addData(List<Integer> data) {
        if (data != null) {
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

}
