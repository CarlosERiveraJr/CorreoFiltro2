package com.telcel.csv.controllers;

import BuscarArchivo.Buscando;
import com.telcel.csv.services.Correos;
import com.telcel.csv.services.DescargaServices;
import java.io.IOException;
import javax.mail.MessagingException;

public class ControllerP{
    
    public ControllerP() {
    }

    public static void main(String[] args) throws MessagingException, IOException {
        DescargaServices voService = new DescargaServices();
        //voService.fncControl();
        new Correos().fncEnviarCorreo();//Llamando método correo
        
    }
}