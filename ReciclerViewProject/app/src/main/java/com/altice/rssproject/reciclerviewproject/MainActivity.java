package com.altice.rssproject.reciclerviewproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    /*class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecycleItemViewHolder> {

        private final String[] items;
        private final Context context;


        public MyRecyclerAdapter(Context context, String... items){
            this.context = context;
            this.items = items;
        }


        @Override
        public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MyRecycleItemViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {
            public MyRecycleItemViewHolder(View itemView){
                super(itemView);
            }
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rv.setAdapter(new MyRecyclerAdapter(MainActivity.this,"1","2","3","1","2","3","1","2","3","1"));

    }
}
