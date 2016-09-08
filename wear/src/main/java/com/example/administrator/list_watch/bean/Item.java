package com.example.administrator.list_watch.bean;

/**
 * Created by Administrator on 2016/8/20.
 */
public class Item {
    private String text;

    public Item(String text) {
        super();
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
