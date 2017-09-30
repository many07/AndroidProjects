package com.altice.rssproject.rssproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;

public class RSSActivity extends AppCompatActivity {

    RecyclerView rv;

    /*class FeedAdapterI extends ArrayAdapter<Article> {

        Article article;
        public FeedAdapterI(ArrayList<Article> list){
            super(RSSActivity.this, 0, list);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            article = getItem(position);
            if(convertView == null){
                convertView = LayoutInflater.from(RSSActivity.this).inflate(R.layout.rss_item, parent, false);
                TextView tituloText = (TextView) convertView.findViewById(R.id.list_view_titulo_noticia);
                TextView autorText= (TextView) convertView.findViewById(R.id.list_view_autor_noticia);
                TextView linkText = (TextView) convertView.findViewById(R.id.list_view_link_noticia);
                TextView fechaText = (TextView) convertView.findViewById(R.id.list_view_fecha_noticia);
                ImageView image = (ImageView) convertView.findViewById(R.id.list_view_imagen_noticia);
                tituloText.setText(article.getTitle());
                autorText.setText(article.getAuthor());
                linkText.setText(article.getLink());
                fechaText.setText(article.getPubDate().toString());
                try{
                    image.setImageURI(Uri.parse(article.getImage()));
                }catch (Exception ex){

                }

            }
            return convertView;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss);

        String url = getIntent().getExtras().getString("url");
        String nombrePeriodico = getIntent().getExtras().getString("nombrePeriodico");
        setTitle(nombrePeriodico);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(RSSActivity.this, LinearLayoutManager.VERTICAL, false));
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                rv.setAdapter(new RecyclerViewAdapter(RSSActivity.this, list));
            }

            @Override
            public void onError() {

            }
        });
        /*titulosRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Article article = (Article) parent.getItemAtPosition(position);
                String link = article.getLink();
                Intent i = new Intent(RSSActivity.this, WebViewActivity.class);
                i.putExtra("link",link);
                startActivity(i);
            }
        });*/
        parser.execute(url);
    }
}
