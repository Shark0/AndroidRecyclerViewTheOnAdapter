package com.shark.recyclermvpadapter.ui.recyclerview.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.shark.recyclermvpadapter.R;
import com.shark.recyclermvpadapter.ui.recyclerview.TheOneAdapter;

/**
 * Created by Shark0 on 2016/12/8.
 */

public class MessageViewType implements TheOneAdapter.ViewTypeInterface {

    private String message;

    public MessageViewType(String message) {
        this.message = message;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_message;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new MessageViewHolder(itemView);
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder viewHolder, int index) {
        bindMessageViewHolder((MessageViewHolder) viewHolder);
    }

    private void bindMessageViewHolder(MessageViewHolder viewHolder) {
        viewHolder.messageTextView.setText(message);
    }

    private class MessageViewHolder extends RecyclerView.ViewHolder {

        private TextView messageTextView;

        public MessageViewHolder(View itemView) {
            super(itemView);
            messageTextView = (TextView) itemView.findViewById(R.id.adapterMessage_messageTextView);
        }
    }
}
