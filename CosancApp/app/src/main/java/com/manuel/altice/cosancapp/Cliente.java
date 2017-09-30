package com.manuel.altice.cosancapp;

/**
 * Created by manuel on 31/08/17.
 */

public class Cliente {

    public int id; //Codigo del cliente
    public Vendedor vendedor; // Indica el vendedor al que esta asignado el cliente
    public String direccion; //direccion del establecimiento
    public double deuda; //deuda que el cliente posee
    public boolean esta90dias; //indica si el cliente esta a 90 dias
    public int RNC; //indica el RNC del cliente
}
