package com.recyclerviewadaptertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.recyclerviewlibrary.SimpleRecyclerViewAdapter;
import com.recyclerviewlibrary.SimpleRecyclerViewViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    SimpleRecyclerViewAdapter<String> mAdapter;
    List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mDatas = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.rl);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        for (int i = 0; i < 12; i++) {
            mDatas.add("第" + i + "条");
        }

        mAdapter = new SimpleRecyclerViewAdapter<String>(MainActivity.this, mDatas, R.layout.adapter_item) {
            @Override
            public void convert(SimpleRecyclerViewViewHolder holder, String s) {
                holder.setText(R.id.textView, s);
                CardView mCardView = holder.getView(R.id.cardView);
                int screenWidthTwo = getResources().getDisplayMetrics().widthPixels;
                mCardView.setLayoutParams(new LinearLayout.LayoutParams(screenWidthTwo, LinearLayout.LayoutParams.WRAP_CONTENT));
                mCardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, MultiItemRecyclerViewActivity.class));
                    }
                });
            }
        };
        mRecyclerView.setAdapter(mAdapter);

    }
}
