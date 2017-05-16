package com.recyclerviewlibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by XuYanping on 2017/5/15.
 */

public class SimpleRecyclerViewViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;

    public SimpleRecyclerViewViewHolder(Context context, View itemView, ViewGroup parent) {
        super(itemView);
        this.mContext = context;
        this.mViews = new SparseArray<>();
        this.mConvertView = itemView;
    }

    public static SimpleRecyclerViewViewHolder getHolder(Context context, ViewGroup parent, int layoutId) {

        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, null);

        SimpleRecyclerViewViewHolder simpleRecyclerViewViewHolder = new SimpleRecyclerViewViewHolder(context, view, parent);

        return simpleRecyclerViewViewHolder;
    }

    public <T extends View> T getView(int viewId) {

        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }

    public SimpleRecyclerViewViewHolder setText(int viewId, String str) {

        TextView mTextView = getView(viewId);
        mTextView.setText(str);

        return this;
    }

    public SimpleRecyclerViewViewHolder setImageResource(int viewId, int resId) {

        ImageView mImageView = getView(viewId);
        mImageView.setImageResource(resId);

        return this;
    }

    public SimpleRecyclerViewViewHolder setImageResource(int viewId, String url) {

        ImageView mImageView = getView(viewId);
        Glide.with(mContext).load(url).into(mImageView);

        return this;
    }

    public SimpleRecyclerViewViewHolder setOnClick(int viewId, View.OnClickListener listener) {

        View view = getView(viewId);
        view.setOnClickListener(listener);

        return this;
    }

}
