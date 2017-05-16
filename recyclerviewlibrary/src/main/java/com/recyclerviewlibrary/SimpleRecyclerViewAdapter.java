package com.recyclerviewlibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by XuYanping on 2017/5/15.
 */

public abstract class SimpleRecyclerViewAdapter<T> extends Adapter<SimpleRecyclerViewViewHolder> {

    public Context mContext;
    public List<T> mDatas;
    public int layoutId;

    public SimpleRecyclerViewAdapter(Context context, List<T> mDatas, int layoutId) {
        mContext = context;
        this.mDatas = mDatas;
        this.layoutId = layoutId;
    }

    @Override
    public SimpleRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SimpleRecyclerViewViewHolder simpleRecyclerViewViewHolder = SimpleRecyclerViewViewHolder.getHolder(mContext, parent, layoutId);
        return simpleRecyclerViewViewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleRecyclerViewViewHolder holder, int position) {
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(SimpleRecyclerViewViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
