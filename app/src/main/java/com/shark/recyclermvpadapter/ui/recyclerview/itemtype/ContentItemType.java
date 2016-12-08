package com.shark.recyclermvpadapter.ui.recyclerview.itemtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shark.recyclermvpadapter.R;
import com.shark.recyclermvpadapter.ui.recyclerview.TheOneAdapter;

/**
 * Created by Shark0 on 2016/12/8.
 */

public class ContentItemType implements TheOneAdapter.ItemTypeInterface {

    private ContentItemTypeListener listener;
    private int contentSize;


    public ContentItemType(ContentItemTypeListener listener, int contentSize) {
        this.listener = listener;
        this.contentSize = contentSize;
    }

    @Override
    public int getCount() {
        return contentSize;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_content_item;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new ContentViewHolder(itemView, listener);
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder viewHolder, int index) {
        bindContentViewHolder((ContentViewHolder) viewHolder, index);
    }

    private void bindContentViewHolder(ContentViewHolder viewHolder, int index) {
        viewHolder.itemView.setTag(index);
        viewHolder.itemTextView.setText("item" + index);
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ContentItemTypeListener listener;
        private TextView itemTextView;

        public ContentViewHolder(View itemView, ContentItemTypeListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            itemTextView = (TextView) itemView.findViewById(R.id.adapterContent_itemTextView);

        }

        @Override
        public void onClick(View v) {
            listener.onContentItemClick((Integer) v.getTag());
        }
    }

    public interface ContentItemTypeListener {
        public void onContentItemClick(int index);
    }
}
