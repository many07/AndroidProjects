package com.altice.rssproject.rssproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prof.rssparser.Article;

import java.util.ArrayList;

/**
 * Created by Manuel on 7/28/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyRecycleItemViewHolder> {

    private Context context;
    private ArrayList<Article> items;

    public RecyclerViewAdapter(Context context, ArrayList<Article> items){
        this.context = context;
        this.items = items;
    }



    @Override
    public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(context).inflate(R.layout.rss_item, parent, false);

        MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyRecycleItemViewHolder holder, int position) {

        final Article article = items.get(position);
        holder.tituloTextView.setText(article.getTitle());
        holder.autorTextView.setText(article.getAuthor());
        holder.fechaTextView.setText(String.valueOf(article.getPubDate()));
        holder.linkTextView.setText(article.getLink());

        holder.linkTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.linkTextView.setTextColor(holder.linkTextView.getResources().getColor(R.color.cardview_dark_background));
                Intent i = new Intent(context, WebViewActivity.class);
                i.putExtra("link",article.getLink());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {

        TextView tituloTextView;
        TextView autorTextView;
        TextView fechaTextView;
        TextView linkTextView;

        public MyRecycleItemViewHolder(View itemView) {
            super(itemView);
            TextView tituloTextView = (TextView) itemView.findViewById(R.id.list_view_titulo_noticia);
            this.tituloTextView = tituloTextView;
            TextView autorTextView = (TextView) itemView.findViewById(R.id.list_view_autor_noticia);
            this.autorTextView = autorTextView;
            TextView fechaTextView = (TextView) itemView.findViewById(R.id.list_view_fecha_noticia);
            this.fechaTextView = fechaTextView;
            TextView linkTextView = (TextView) itemView.findViewById(R.id.list_view_link_noticia);
            this.linkTextView = linkTextView;


        }
    }

}
