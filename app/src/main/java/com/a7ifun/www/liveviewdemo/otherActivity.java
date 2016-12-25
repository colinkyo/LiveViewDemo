package com.a7ifun.www.liveviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class otherActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        lv = (ListView) findViewById(R.id.lv);
        list = new ArrayList<String>();
        for(int i=0;i<20;i++){
            list.add("Item"+i);
        }

        adapter = new ArrayAdapter<String>(otherActivity.this,android.R.layout.simple_list_item_1,list);
        //默认加载方法
        //lv.setAdapter(adapter);
        ImageView iv= new ImageView(otherActivity.this);

        iv.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
        iv.setImageResource(R.mipmap.sj);
        //添加动态创建的视图
        //lv.addHeaderView(iv);
        //也可以添加由xml 转换的视图
        View headerView = LayoutInflater.from(otherActivity.this).inflate(R.layout.iv_header,null);
        lv.addHeaderView(headerView);

        Button btn = new Button(otherActivity.this);
        btn.setText("加载更多....");
        btn.setTextSize(20);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idx = list.size();
                for(int i=idx;i<idx+20;i++){
                    list.add("Item"+i);
                }
                adapter.notifyDataSetChanged();
            }
        });
        lv.addFooterView(btn);
        lv.setAdapter(adapter);

    }
}
