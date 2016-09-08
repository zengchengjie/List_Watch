package com.example.administrator.list_watch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.list_watch.R;
import com.example.administrator.list_watch.bean.Item;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class List_Adapter extends WearableListView.Adapter {
    private Context context;
    private List<Item> list;

    public List_Adapter(Context context, List<Item> list) {
        super();
        this.context = context;
        this.list = list;
    }

  /*  @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = list.get(position);
        holder.textView.setText(item.getText());

    }*/

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
        TextView view = (TextView) holder.itemView.findViewById(R.id.list_text);
        view.setText(list.get(position).getText());
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends WearableListView.ViewHolder {
//        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
//            textView = (TextView) itemView.findViewById(R.id.list_text);
        }
    }

   /* @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null);
        TextView textView = (TextView) view.findViewById(R.id.list_text);
        textView.setText(list.get(position).getText());
        return view;
    }*/
}
