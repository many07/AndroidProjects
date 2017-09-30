package com.altice.jsonconsume.jsonconsumeproyect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manuel on 8/5/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecycleItemViewHolder>
{

    Context context;
    List<Item> list;

    public MyRecyclerAdapter(Context context, List list){
        this.context = context;
        this.list = list;
    }

    @Override
    public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.card_view_item, parent, false);

        MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecycleItemViewHolder holder, int position) {
        Item item = list.get(position);

        holder.nombreTexTView.setText(item.name);
        holder.descriptionTextView.setText(item.description);
        Glide.with(context)
                .load(item.image_url)
                .into(holder.imageView);

        /*GlideApp.with(this)
                .load("http://vinrosa.com/example/1.png")
                .into(imageView);
        Log.d("ImageTag",imageView.toString());*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nombreTexTView;
        public TextView descriptionTextView;

        public MyRecycleItemViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.my_image);
            this.nombreTexTView = (TextView) itemView.findViewById(R.id.my_name);
            this.descriptionTextView = (TextView) itemView.findViewById(R.id.my_description);
        }
    }
}
