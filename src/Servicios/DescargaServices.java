//package com.telcel.csv.services;
package Servicios;

import com.infomedia.utils.PropertyLoader;
import com.csvreader.CsvReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import com.telcel.sir.pojos.CorreoOrder;
import java.util.List;
import javax.mail.MessagingException;
import java.util.logging.Level;
import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import java.util.Properties;

public class DescargaServices
{

    public static final Properties vpProp = PropertyLoader.load("rutas.properties");
    private static final Logger log = Logger.getLogger(DescargaServices.class);
    private String vsRutaLocal;
  
    public DescargaServices() {
        this.vsRutaLocal = DescargaServices.vpProp.getProperty("RUTA_LOCAL");
    }
    
    
    //Validando la presencia de archivo .log en la carpeta
    //public boolean fncControl() throws MessagingException, IOException {
        /*System.out.println("Inicio");
        final boolean vbRes = false;
        String file4 = "";
        final RemedyControl voRControl = new RemedyControl();
        final Correos co = new Correos();
        final File folder = new File(this.vsRutaLocal);
        File[] var6 = folder.listFiles();
        int var7 = var6.length;
        for(int var8 = 0; var8 < var7; ++var8) {
         File fileEntry = var6[var8];
            
            if (fileEntry.getName().endsWith("LogNomina.log")) {
                System.out.println(fileEntry.getName());
                file4 = this.vsRutaLocal + fileEntry.getName();
                List<CorreoOrder> poWorkOrders = (List<CorreoOrder>) this.fncLeerWorkOrders(file4);
*/
 //                   co.fncEnviarCorreo(poWorkOrders);//envia correo
                  
   //         }
     //   }
        
        //System.out.println("Completed");
        //return false;
    //}


    public String fncFecha() {
        SimpleDateFormat voFormat = new SimpleDateFormat("ddMMyyyy");
        Calendar voCalendario = new GregorianCalendar();
        voCalendario.add(6, 0);
        String fecha = voFormat.format(voCalendario.getTime());
        return fecha;
    }


    //Enviando Correo
    public List<CorreoOrder> fncLeerWorkOrders(String psRuta) {
      
      List<CorreoOrder> voCorreoOrders = new ArrayList();
        CsvReader voLector = null;

        try {
            voLector = new CsvReader(psRuta);
            voLector.readHeaders();

            while(voLector.readRecord()) {
                if (!voLector.get(0).isEmpty()) {
                
                    CorreoOrder voCorreoOrder = new CorreoOrder();
                    voCorreoOrders.add(voCorreoOrder);
                }
            }

            voLector.close();
        } catch (Exception var8) {
            log.error(var8);
        } finally {
            if (voLector != null) {
                voLector.close();
            }

        }

       return voCorreoOrders;
    }

    public void fncControl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
