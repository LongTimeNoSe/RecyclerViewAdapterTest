package com.recyclerviewlibrary;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by XuYanping on 2017/5/16.
 */

public abstract class MultiItemSimpleRecyclerViewAdapter<T> extends SimpleRecyclerViewAdapter<T> {

    protected MultiItemTypeSupport<T> mSupport;

    public MultiItemSimpleRecyclerViewAdapter(Context context, List<T> mDatas, MultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, mDatas, -1);
        this.mSupport = multiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {

        return mSupport.getItemViewType(position, mDatas.get(position));
    }

    @Override
    public SimpleRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutId = mSupport.getLayoutId(viewType);
        SimpleRecyclerViewViewHolder holder = SimpleRecyclerViewViewHolder.getHolder(mContext, parent, layoutId);
        return holder;
    }
}
