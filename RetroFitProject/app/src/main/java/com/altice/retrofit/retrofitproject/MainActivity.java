package com.altice.retrofit.retrofitproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

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
                Log.d("LOG_TAG1","Items: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.d("LOG_TAG1","Items: " + "Error: ", t);
            }


        });

        service.postForm(" Tamo en vivo").enqueue(new Callback<FormResponse>() {
            @Override
            public void onResponse(Call<FormResponse> call, Response<FormResponse> response) {
                Log.d("LOG_TAG", "Form Response: "+response.body());
            }

            @Override
            public void onFailure(Call<FormResponse> call, Throwable t) {
                Log.e("LOG_TAG","ERROR: " + t);
            }
        });

        imageView = (ImageView) findViewById(R.id.my_image_view);
        GlideApp.with(this)
                .load("http://vinrosa.com/example/1.png")
                .into(imageView);
        Log.d("ImageTag",imageView.toString());

    }
}
