package com.altice.manuel.rssreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;


public class TitulosRSSActivity extends AppCompatActivity {

    class FeedAdapterI extends ArrayAdapter<Article>{

        Article article;
        public FeedAdapterI(ArrayList<Article> list){
            super(TitulosRSSActivity.this, 0, list);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            article = getItem(position);
            if(convertView == null){
                convertView = LayoutInflater.from(TitulosRSSActivity.this).inflate(R.layout.rss_model, parent, false);
                TextView tituloText = (TextView) convertView.findViewById(R.id.list_view_titulo_noticia);
                TextView autorText= (TextView) convertView.findViewById(R.id.list_view_autor_noticia);
                TextView linkText = (TextView) convertView.findViewById(R.id.list_view_link_noticia);
                TextView fechaText = (TextView) convertView.findViewById(R.id.list_view_fecha_noticia);
                tituloText.setText(article.getTitle());
                autorText.setText(article.getAuthor());
                linkText.setText(article.getLink());
                fechaText.setText(article.getPubDate().toString());
            }
            return convertView;
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titulos_rss);
        final ListView titulosRss = (ListView) findViewById(R.id.list_view_titulos_rss);
        String url = getIntent().getExtras().getString("url");
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                titulosRss.setAdapter(new FeedAdapterI(list));
            }

            @Override
            public void onError() {

            }
        });
        titulosRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Article article = (Article) parent.getItemAtPosition(position);
                String link = article.getLink();
                Intent i = new Intent(TitulosRSSActivity.this, VistaWebNoticia.class);
                i.putExtra("link",link);
                startActivity(i);
            }
        });
        parser.execute(url);
    }

}
