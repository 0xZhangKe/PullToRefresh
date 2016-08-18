package com.zhangke.pulltorefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> data=new ArrayList<String>();
    private ArrayAdapter adapter;
    private boolean isReset=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }
    private void initView(){
        listView=(ListView)findViewById(R.id.main_listview);
        for(int i=0;i<20;i++){
            data.add(""+i);
        }
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isReset) {
                    isReset=false;
                    data.clear();
                    adapter.notifyDataSetChanged();
                }else{
                    isReset=true;
                    for(int i=0;i<20;i++){
                        data.add(""+i);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
