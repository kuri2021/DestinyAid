package com.example.destinyaid;

import android.widget.ImageView;

public class Item {
    public int iv;//문양
    public String title;//제목
    public String contents;//내용

    public Item() {
    }

    public Item(int iv, String title, String contents) {
        this.iv = iv;
        this.title = title;
        this.contents = contents;
    }
}
