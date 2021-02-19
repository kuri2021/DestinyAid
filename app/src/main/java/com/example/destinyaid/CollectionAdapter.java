package com.example.destinyaid;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CollectionAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<CollectionItem> collectionItems;

    public CollectionAdapter(Context context, ArrayList<CollectionItem> collectionItems) {
        this.context = context;
        this.collectionItems = collectionItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);

        View itemview=inflater.inflate(R.layout.collection_category,parent,false);
        VH holder=new VH(itemview);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        CollectionItem collectionItem=collectionItems.get(position);
        vh.category_name.setText(collectionItem.name);
        vh.category_quantity.setText(collectionItem.quantity);
        Glide.with(context).load(collectionItem.iv).into(vh.category_iv);
    }

    @Override
    public int getItemCount() { return collectionItems.size(); }

    class VH extends RecyclerView.ViewHolder{
        ImageView category_iv;
        TextView category_name,category_quantity;
        public VH(@NonNull View itemView) {
            super(itemView);
            category_iv=itemView.findViewById(R.id.category_iv);
            category_name=itemView.findViewById(R.id.category_name);
            category_quantity=itemView.findViewById(R.id.category_quantity);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                    switch (position){
                        case 0:
                            Intent intent=new Intent(context,Collection_Wonder.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;

                    }
                }
            });
        }
    }


}
