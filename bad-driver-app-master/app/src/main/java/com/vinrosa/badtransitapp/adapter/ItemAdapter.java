package com.vinrosa.badtransitapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.vinrosa.badtransitapp.R;
import com.vinrosa.badtransitapp.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinliangx on 8/7/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final Context context;
    private List<Item> items;

    public ItemAdapter(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        final Item item = this.items.get(position);
        holder.mDescTextView.setText(item.description);
        holder.mRatingTextView.setText(item.rating != null ? item.rating.toString() : "N/A");
        holder.mEmailTextView.setText(item.email);
        holder.mImageView.setImageBitmap(null);
        FirebaseStorage storage = FirebaseStorage.getInstance();
        storage.getReference("Images").child(item.image).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).into(holder.mImageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void addItem(Item item){
        this.items.add(0, item);
        this.notifyItemInserted(0);
    }

    public void updateItem (Item item){
        int position = this.items.indexOf(item);
        if (position >= 0){
            this.items.remove(position);
            this.items.add(position, item);
        }
        this.notifyItemChanged(position);
    }

    public void removeItem(Item item) {
        int position = this.items.indexOf(item);
        if (position >= 0){
            this.items.remove(position);
        }
        this.notifyItemRemoved(position);
    }


    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final ImageView mImageView;
        private final TextView mDescTextView;
        private final TextView mRatingTextView;
        private final TextView mEmailTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image_view);
            mDescTextView = (TextView) itemView.findViewById(R.id.item_description_text_view);
            mRatingTextView = (TextView) itemView.findViewById(R.id.item_rating_text_view);
            mEmailTextView = (TextView) itemView.findViewById(R.id.item_email_text_view);
        }
    }
}
