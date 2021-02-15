package com.example.destinyaid;

import android.widget.ImageView;

public class Item {
//    ImageView iv;//문양
    public String title;//제목
    public String contents;//내용

    public Item() {
    }

    public Item( String title, String contents) {
//        this.iv = iv;
        this.title = title;
        this.contents = contents;
    }
}
