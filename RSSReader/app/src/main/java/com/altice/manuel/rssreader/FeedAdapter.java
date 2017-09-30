package com.altice.manuel.rssreader;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.prof.rssparser.Article;

import java.util.ArrayList;

/**
 * Created by Manuel on 15/7/2017.
 */

public class FeedAdapter extends ArrayAdapter<Article> {
    Article article;

    public FeedAdapter(@NonNull Context context, @NonNull ArrayList<Article> objects){
        this(context,0, objects);
    }
    public FeedAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Article> objects){
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        article = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rss_model, parent, false);
            TextView tituloRss = (TextView) convertView.findViewById(R.id.list_view_titulo_noticia);
            TextView autorRss = (TextView) convertView.findViewById(R.id.list_view_autor_noticia);
            //TextView descripcionRss = (TextView) convertView.findViewById(R.id.list_view_descripcion_noticia);
            TextView linkRss = (TextView) convertView.findViewById(R.id.list_view_link_noticia);
            TextView fechaRss = (TextView) convertView.findViewById(R.id.list_view_fecha_noticia);
            tituloRss.setText(article.getTitle());
            autorRss.setText(article.getAuthor());
            fechaRss.setText(article.getPubDate().toString());
            //descripcionRss.setText(article.getDescription());
            linkRss.setText(article.getLink());

        }
        return convertView;
    }

}
