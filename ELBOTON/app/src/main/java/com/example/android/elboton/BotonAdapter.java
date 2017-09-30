package com.example.android.elboton;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Manuel on 21/2/2017.
 */

public class BotonAdapter extends ArrayAdapter<Boton>{

    public BotonAdapter (Activity context, ArrayList<Boton> botones){
        super(context,0, botones);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Boton currentBoton = getItem(position);
        ImageView currentImage;
        return convertView;

    }

}
