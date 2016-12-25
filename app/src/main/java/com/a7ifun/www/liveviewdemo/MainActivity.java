package com.a7ifun.www.liveviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv,lv1;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        lv1=(ListView) findViewById(R.id.lv1);
        final String[] citys =getResources().getStringArray(R.array.citys);

        adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,citys);

        lv1.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,otherActivity.class);
                startActivity(intent);
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //数据源获取
                String s1 = citys[position];
                //适配器中获取
                String s2 = adapter.getItem(position);
                //在parent中获取
                String s3= parent.getItemAtPosition(position).toString();
                //在listview控件中获取
                String s4 = lv1.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, s1 + " " + s2 + " " + s3 + " " + s4, Toast.LENGTH_SHORT).show();
            }
        });
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            //返回值为false时，会响应单击事件
            //返回值为true时,不会响应单击事件
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "这是长按事件", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
