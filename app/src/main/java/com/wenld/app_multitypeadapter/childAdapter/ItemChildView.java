package com.wenld.app_multitypeadapter.childAdapter;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wenld.app_multitypeadapter.R;
import com.wenld.multitypeadapter.base.MultiItemView;
import com.wenld.multitypeadapter.base.ViewHolder;

public class ItemChildView extends MultiItemView<String> {

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.lv_child_item;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @NonNull String item, int position) {
        ImageView iv = holder.getView(R.id.iv_item);

        Glide.with(iv.getContext())
                .load(item)
//                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
//                .error(R.mipmap.cheese) // will be displayed if the image cannot be loaded
                .centerCrop()
                .into(iv);
    }


}
