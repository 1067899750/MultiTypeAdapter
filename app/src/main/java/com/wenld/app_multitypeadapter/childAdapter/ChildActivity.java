package com.wenld.app_multitypeadapter.childAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.wenld.app_multitypeadapter.R;
import com.wenld.app_multitypeadapter.decoration.ItemDecoration;
import com.wenld.app_multitypeadapter.manyData.adapter.ItemVIew01;
import com.wenld.app_multitypeadapter.manyData.adapter.ItemVIew02;
import com.wenld.app_multitypeadapter.manyData.adapter.ItemVIewNormal;
import com.wenld.app_multitypeadapter.manyData.bean.Bean01;
import com.wenld.app_multitypeadapter.manyData.bean.Bean02;
import com.wenld.app_multitypeadapter.manyData.bean.Bean03;
import com.wenld.app_multitypeadapter.one2many.Bean04;
import com.wenld.multitypeadapter.MultiTypeAdapter;
import com.wenld.multitypeadapter.wrapper.LoadMoreWrapper2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ChildActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private LoadMoreWrapper2 loadMoreWrapper2;
    ;
    private List<Object> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);


        mRecyclerView = (RecyclerView) findViewById(R.id.rl_child);
        mAdapter = new MultiTypeAdapter();

        mAdapter.register(String.class, new ItemVIewNormal());
        mAdapter.register(Bean01.class, new ItemVIew01());
        mAdapter.register(Bean02.class, new ItemVIew02());
        mAdapter.register(Item1.class, new ItemView());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
        mRecyclerView.addItemDecoration(new ItemDecoration(space));
        mRecyclerView.setAdapter(mAdapter);
        items = new ArrayList<>();
        for (int j = 0; j < 1; j++) {
            items.add("混合式 \n 多数据 -> 多类型  单数据 -> 多类型");
            for (int i = 0; i < 8; i++) {

            }
            for (int i = 0; i < 3; i++) {
                items.add(new Bean02("bean02_" + i));
                items.add(new Bean01("bean01_" + i));
                items.add(new Item1("标题—" + i));
            }


        }
        mAdapter.setItems(items);
//        mAdapter.notifyDataSetChanged();
        loadMoreWrapper2 = new LoadMoreWrapper2(mAdapter);
        loadMoreWrapper2.setLoadMoreView(LayoutInflater.from(this).inflate(R.layout.default_loading, mRecyclerView, false));
        mRecyclerView.setAdapter(loadMoreWrapper2);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int j = 0; j < 1; j++) {
                    items.add("混合式 \n 多数据 -> 多类型  单数据 -> 多类型");
                    for (int i = 0; i < 8; i++) {

                    }
                    for (int i = 0; i < 3; i++) {

                        items.add(new Bean02("bean02_" + i));
                        items.add(new Bean01("bean01_" + i));
                        items.add(new Item1("标题—" + System.currentTimeMillis()));
                    }


                }
//                mAdapter.setItems(items);
                loadMoreWrapper2.notifyDataSetChanged();
//                mAdapter.notifyDataSetChanged();
            }
        }, 100, 200);
    }


}





















