package com.example.administrator.list_watch;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.support.wearable.view.WearableListView;
import android.util.Log;
import android.widget.ListView;

import com.mobvoi.android.common.ConnectionResult;
import com.mobvoi.android.common.api.MobvoiApiClient;

import com.example.administrator.list_watch.adapter.List_Adapter;
import com.example.administrator.list_watch.bean.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends WearableActivity implements MobvoiApiClient.ConnectionCallbacks,MobvoiApiClient.OnConnectionFailedListener{
    private List<Item> list;
    private WearableListView listView;
    private List_Adapter list_adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private BoxInsetLayout mContainerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listSet("这是刷新以后的列表数据");
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        listSet("这是手表项目的测试");
    }

    private void listSet(String text) {
        list =new ArrayList<>();
        listView = (WearableListView) findViewById(R.id.listView);
        for (int i=0;i<30;i++){
            list.add(new Item(text));
        }
        list_adapter = new List_Adapter(MainActivity.this,list);
        listView.setAdapter(list_adapter);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));

        } else {
            mContainerView.setBackground(null);

        }
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
