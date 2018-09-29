package com.wenld.app_multitypeadapter.childAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenld.app_multitypeadapter.R;
import com.wenld.app_multitypeadapter.decoration.ItemDecoration;
import com.wenld.multitypeadapter.MultiTypeAdapter;
import com.wenld.multitypeadapter.base.MultiItemView;
import com.wenld.multitypeadapter.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ItemView extends MultiItemView<Item1> {
    private RecyclerView mRecyclerView;
    private MultiTypeAdapter mAdapter;
    private List<Object> items;

    public ItemView() {
        super();
    }

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.ll_child_item;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Item1 item, int position) {
        holder.setText(R.id.tv_name, item.title);
        mRecyclerView = holder.getView(R.id.rv_child);

        mAdapter =  new MultiTypeAdapter();
        mAdapter.register(String.class, new ItemChildView());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        items = new ArrayList<>();
        items.add(item.imgUrl1);
        items.add(item.imgUrl2);
        items.add(item.imgUrl3);
        mAdapter.setItems(items);
        mAdapter.notifyDataSetChanged();

    }





}







