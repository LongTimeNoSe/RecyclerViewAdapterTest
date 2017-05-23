功能说明：
1：一键配置RecyclerViewAdapter，免去繁琐的重复配置；
2：支持多布局Item;
3：暂不支持下拉刷新与上拉加载（正在紧急开发中...）。

使用方式：

1：配置
Gradle中：compile 'com.xyp.use:recyclerviewlibrary:1.0.1'
  
2：实现：
（1）：单一布局实现：
![image](https://github.com/MissYouAllTheTime/RecyclerViewAdapterTest/blob/master/images/single_layout.png)
（2）：多布局实现：
![image](https://github.com/MissYouAllTheTime/RecyclerViewAdapterTest/blob/master/images/mutiItem_layout.png)


注：
其中String是数据类型（实体类Bean）;mData是List数据。
由于item根布局我使用了CardView，在配合RecyclerView使用时会造成子布局不能横向完全填充RecyclerView，所以此处使用了setLayoutParms方法设置item横向完全填充。

Git地址：
https://github.com/MissYouAllTheTime/RecyclerViewAdapterTest
邮箱：
China.XuYanping@gmail.com

欢迎各位大佬批评指正。

 一行朱砂
        2017年5月18日
