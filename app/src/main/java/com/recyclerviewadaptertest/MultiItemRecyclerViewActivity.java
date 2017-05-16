package com.recyclerviewadaptertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.recyclerviewlibrary.MultiItemSimpleRecyclerViewAdapter;
import com.recyclerviewlibrary.MultiItemTypeSupport;
import com.recyclerviewlibrary.SimpleRecyclerViewViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XuYanping on 2017/5/16.
 */

public class MultiItemRecyclerViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MultiItemSimpleRecyclerViewAdapter<DataBean> mAdapter;
    List<DataBean> mDatas;
    MultiItemTypeSupport<DataBean> mSupport;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_item_recyclerview);
        initView();
    }

    private void initView() {
        mDatas = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.rl);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MultiItemRecyclerViewActivity.this));
        for (int i = 0; i < 3; i++) {
            DataBean mDataBean = new DataBean();
            mDataBean.setName("第" + i + "名");
            mDataBean.setType(i);
            mDatas.add(mDataBean);
        }
        mSupport = new MultiItemTypeSupport<DataBean>() {
            @Override
            public int getLayoutId(int itemType) {
                if (itemType % 2 == 0) {
                    return R.layout.adapter_item;
                } else {
                    return R.layout.adapter_item_copy;
                }
            }

            @Override
            public int getItemViewType(int position, DataBean bean) {
                return bean.getType();
            }
        };
        mAdapter = new MultiItemSimpleRecyclerViewAdapter<DataBean>(MultiItemRecyclerViewActivity.this, mDatas, mSupport) {
            @Override
            public void convert(SimpleRecyclerViewViewHolder holder, DataBean bean) {
                CardView mCardView = holder.getView(R.id.cardView);
                int screenWidthTwo = getResources().getDisplayMetrics().widthPixels;
                mCardView.setLayoutParams(new LinearLayout.LayoutParams(screenWidthTwo, LinearLayout.LayoutParams.WRAP_CONTENT));
                if (bean.getType() % 2 == 0) {
                    holder.setText(R.id.textView, bean.getName());
                } else {
                    holder.setText(R.id.textViewCopy, bean.getName() + "COPY");
                }
            }
        };
        mRecyclerView.setAdapter(mAdapter);
    }
}
