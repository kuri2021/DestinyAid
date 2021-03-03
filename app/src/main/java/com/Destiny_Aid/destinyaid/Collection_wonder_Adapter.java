package com.Destiny_Aid.destinyaid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Collection_wonder_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Collection_wonder_Item> items;

    public Collection_wonder_Adapter(Context context, ArrayList<Collection_wonder_Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemview=inflater.inflate(R.layout.recycler_inventory,parent,false);
        VH holder=new VH(itemview);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        Collection_wonder_Item item=items.get(position);

        vh.Equipitemname_tv.setText(item.Equipitemname_tv);
        vh.kategorie.setText(item.kategorie);

        Glide.with(context).load(item.Equipitem_iv).into(vh.Equipitem_iv);
        Glide.with(context).load(item.Equipitemlock_iv).into(vh.Equipitemlock_iv);
        Glide.with(context).load(item.ability1).into(vh.ability1);
        Glide.with(context).load(item.ability2).into(vh.ability2);
        Glide.with(context).load(item.ability3).into(vh.ability3);
        Glide.with(context).load(item.ability4).into(vh.ability4);

    }

    @Override
    public int getItemCount() { return items.size(); }


    class VH extends RecyclerView.ViewHolder {

        TextView Equipitemname_tv;
        TextView kategorie;
        ImageView Equipitem_iv;
        ImageView Equipitemlock_iv;
        ImageView ability1;
        ImageView ability2;
        ImageView ability3;
        ImageView ability4;

        public VH(@NonNull View itemView) {
            super(itemView);

            Equipitemname_tv=itemView.findViewById(R.id.Equipitemname_tv);
            kategorie=itemView.findViewById(R.id.kategorie);
            Equipitemlock_iv=itemView.findViewById(R.id.Equipitemlock_iv);
            Equipitem_iv=itemView.findViewById(R.id.Equipitem_iv);
            ability1=itemView.findViewById(R.id.ability1);
            ability2=itemView.findViewById(R.id.ability2);
            ability3=itemView.findViewById(R.id.ability3);
            ability4=itemView.findViewById(R.id.ability4);

            Equipitem_iv.bringToFront();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();

                    String name=items.get(position).Equipitemname_tv;
                    int Equipitem_iv=items.get(position).Equipitem_iv;

                    Intent intent=new Intent(context, Item_DetailActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("img",Equipitem_iv);

                    context.startActivity(intent);


                }
            });

        }
    }
}
