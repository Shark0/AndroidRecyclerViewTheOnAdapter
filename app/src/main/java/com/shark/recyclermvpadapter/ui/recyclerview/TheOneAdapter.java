package com.shark.recyclermvpadapter.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Shark0 on 2016/12/8.
 */

public class TheOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ItemTypeInterface> itemTypeList;

    public TheOneAdapter(Context context, List<ItemTypeInterface> itemTypeList) {
        this.context = context;
        this.itemTypeList = itemTypeList;
    }

    @Override
    public int getItemViewType(int position) {
        ItemTypeInterface itemType = getItemTypeByPosition(position);
        return itemType.getLayoutId();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(viewType, parent, false);
        ItemTypeInterface itemType = getItemTypeByViewType(viewType);
        return itemType.getViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemTypeInterface itemType = getItemTypeByPosition(position);
        int index = getItemTypeIndexByPosition(position);
        itemType.bindViewHolder(holder, index);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        for (ItemTypeInterface itemType: itemTypeList) {
            count = count + itemType.getCount();
        }
        return count;
    }

    private ItemTypeInterface getItemTypeByPosition(int position) {
        int count = 0;
        for (ItemTypeInterface itemType: itemTypeList) {
            count = count + itemType.getCount();
            if(position < count) {
                return itemType;
            }
        }
        return null;
    }

    private ItemTypeInterface getItemTypeByViewType(int viewType) {
        for (ItemTypeInterface itemType: itemTypeList) {
            if(itemType.getLayoutId() == viewType) {
                return itemType;
            }
        }
        return null;
    }

    private int getItemTypeIndexByPosition(int position) {
        int count = 0;
        for (ItemTypeInterface itemType: itemTypeList) {
            count = count + itemType.getCount();
            if(position < count) {
                int preItemCount = (count - itemType.getCount());
                return position - preItemCount;
            }
        }
        return -1;
    }

    public static interface ItemTypeInterface {
        public int getCount();
        public int getLayoutId();
        public RecyclerView.ViewHolder getViewHolder(View itemView);
        public void bindViewHolder(RecyclerView.ViewHolder viewHolder, int index);
    }
}
