//package com.telcel.sir.pojos;
package Atributos;
        
public class CorreoOrder
{
   
    private String Fecha;//elemento9 

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }


    public String getFecha() {
        return Fecha;
    }

   @Override
    public String toString() {                                                                                                              //mio
        return "CorreoOrder{Fecha=" + this.Fecha +'}' ;
    }
    
}