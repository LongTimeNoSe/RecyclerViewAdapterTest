package com.recyclerviewlibrary;

/**
 * Created by XuYanping on 2017/5/16.
 */

public interface MultiItemTypeSupport<T> {

    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);

}
