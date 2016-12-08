package com.shark.recyclermvpadapter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.shark.recyclermvpadapter.R;
import com.shark.recyclermvpadapter.ui.recyclerview.TheOneAdapter;
import com.shark.recyclermvpadapter.ui.recyclerview.itemtype.ButtonItemType;
import com.shark.recyclermvpadapter.ui.recyclerview.itemtype.ContentItemType;
import com.shark.recyclermvpadapter.ui.recyclerview.itemtype.MessageItemType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonItemType.ButtonItemTypeListener, ContentItemType.ContentItemTypeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindContentRecyclerView();
    }

    private void bindContentRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activityMain_contentRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<TheOneAdapter.ItemTypeInterface> itemTypeList = new ArrayList<>();
        itemTypeList.add(new MessageItemType("This Is Header"));
        itemTypeList.add(new ContentItemType(this, 10));
        itemTypeList.add(new MessageItemType("This Is Middle"));
        itemTypeList.add(new ContentItemType(this, 10));
        itemTypeList.add(new MessageItemType("This Is Footer"));
        itemTypeList.add(new ButtonItemType(this, "This is Footer Button"));
        recyclerView.setAdapter(new TheOneAdapter(this, itemTypeList));
    }

    @Override
    public void onContentItemClick(int index) {
        Toast.makeText(this, "onContentItemClick index: " + index, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonItemClick() {
        Toast.makeText(this, "onButtonItemClick", Toast.LENGTH_SHORT).show();
    }
}
