package com.Destiny_Aid.destinyaid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class G {
    public static String nickname;
    public static String profileImageUrl;

    public static class Information_ViewPager_Adapter extends PagerAdapter {

        Context context;
        ArrayList<Integer> img;

        public Information_ViewPager_Adapter(Context context, ArrayList<Integer> img) {
            this.context = context;
            this.img=img;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater=LayoutInflater.from(context);
            View page=inflater.inflate(R.layout.information_vp_adapter,null);

            ImageView iv=page.findViewById(R.id.iv);
            iv.setImageResource(img.get(position));
            container.addView(page);
            return page;
        }

        @Override
        public int getCount() { return img.size(); }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

            return view==object;
        }
    }
}
