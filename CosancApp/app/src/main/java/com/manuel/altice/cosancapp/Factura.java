package com.manuel.altice.cosancapp;

import java.util.List;

/**
 * Created by manuel on 09/09/17.
 */

public class Factura {
    public int id; //indica el id de la factura
    public double subtotal; //Indica el valor neto de la factura sin aplicarle impuestos ni descuentos
    public double itebis; //Indica el impuesto que la misma tendrá
    public double descuento; //Indica el descuento que se le hace a la factura
    public double total; //Indica el total aplicandole impuestos y descuentos
    public Cliente cliente; //Indica el cliente al que se le hace la factura
    public List<DetalleDeFactura> detalleDeFacturaList;
}
