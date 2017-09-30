package com.example.android.elboton;

/**
 * Created by Manuel on 21/2/2017.
 */

public class Boton {

    int direccionDeImagen;
    int direccionDeMusica;

    public Boton(int direccionDeImagen, int direccionDeMusica){
        this.direccionDeImagen = direccionDeImagen;
        this.direccionDeMusica = direccionDeMusica;
    }

    //Getter para la dirección de la imagen
    public int getDireccionDeImagen(){
        return direccionDeImagen;
    }

    //Getter para la direccion de musica
    public int getDireccionDeMusica(){
        return direccionDeMusica;
    }

}
