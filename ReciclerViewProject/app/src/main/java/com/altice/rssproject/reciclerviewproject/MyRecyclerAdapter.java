package com.altice.rssproject.reciclerviewproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Manuel on 7/22/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecycleItemViewHolder>{

    private String[] items;
    private Context context;

    public MyRecyclerAdapter(Context context, String... items){
        this.context = context;
        this.items = items;
    }

    @Override
    public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        if(viewType==2000){
            view = LayoutInflater.from(context).inflate(R.layout.card_view_item2, parent, false);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.card_view_item, parent, false);
        }

        MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecycleItemViewHolder holder, int position) {
        final String item = items[position];
        if(holder.appNameTextView!=null){
            holder.appNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Elemento "+item+" seleccionado", Toast.LENGTH_SHORT).show();
                }
            });
        }
        holder.noItemTextView.setText(item);
    }


    @Override
    public int getItemCount() {
        return this.items.length;
    }

    @Override
    public int getItemViewType(int position){
        String s = items[position];
        //Se pone en ese orden para evitar un NullPointer Exception
        if("2".equals(s)){
            return 2000;
        }
        return 1000;
    }

    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {
        public TextView appNameTextView;
        public TextView noItemTextView;
        public MyRecycleItemViewHolder(View itemView, int viewType){
            super(itemView);
            TextView noItemTextView = (TextView) itemView.findViewById(R.id.item_no_text_view);
            this.noItemTextView = noItemTextView;
            if(viewType!=2000){
                TextView appNameTextView = (TextView) itemView.findViewById(R.id.app_name_text_view);
                this.appNameTextView = appNameTextView;
            }

        }
    }
}
