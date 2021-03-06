package com.shark.recyclermvpadapter.ui.recyclerview.viewtype;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.shark.recyclermvpadapter.R;
import com.shark.recyclermvpadapter.ui.recyclerview.TheOneAdapter;

/**
 * Created by Shark0 on 2016/12/8.
 */

public class ButtonViewType implements TheOneAdapter.ViewTypeInterface {

    private ButtonViewTypeListener listener;
    private String buttonText;

    public ButtonViewType(ButtonViewTypeListener listener, String buttonText) {
        this.listener = listener;
        this.buttonText = buttonText;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_button;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new ButtonViewHolder(itemView, listener);
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder viewHolder, int index) {
        bindButtonViewHolder((ButtonViewHolder) viewHolder);
    }

    private void bindButtonViewHolder(ButtonViewHolder viewHolder) {
        viewHolder.button.setText(buttonText);
    }

    private class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ButtonViewTypeListener listener;
        private Button button;

        public ButtonViewHolder(View itemView, ButtonViewTypeListener listener) {
            super(itemView);
            this.listener = listener;
            button = (Button) itemView.findViewById(R.id.adapterButton_button);
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onButtonItemClick();
        }
    }

    public interface ButtonViewTypeListener {
        public void onButtonItemClick();
    }
}
