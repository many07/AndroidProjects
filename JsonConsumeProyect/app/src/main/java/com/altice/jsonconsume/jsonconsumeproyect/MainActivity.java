package com.altice.jsonconsume.jsonconsumeproyect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vinrosa.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyRemoteService service = retrofit.create(MyRemoteService.class);

        service.getItem().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                RecyclerView rv = (RecyclerView) findViewById(R.id.my_recycler_view);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));


                rv.setAdapter(new MyRecyclerAdapter(MainActivity.this, response.body()));
                Log.d("LOG_TAG","Response: "+response.body());
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.e("LOG_TAG","Error : "+ t);
            }
        });





        //rv.setAdapter(new MyRecyclerAdapter(MainActivity.this,"1","2","3","1","2","3","1","2","3","1"));

    }
}
