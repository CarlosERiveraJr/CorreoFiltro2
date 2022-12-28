
//package com.telcel.csv.services;
package Servicios;

import java.net.MalformedURLException;
import javax.xml.ws.Service;
import java.net.URL;
import javax.xml.namespace.QName;
import com.telcel.rcontrol.services.remedy.generic.UpdateStatus;
import com.telcel.rcontrol.services.remedy.generic.InsertStatus;
import java.util.Iterator;
import com.telcel.rcontrol.services.remedy.generic.RemedyPort;
import com.telcel.rcontrol.services.remedy.generic.Field;
import com.telcel.rcontrol.services.remedy.generic.ListOfFields;
//import com.telcel.sir.pojos.CorreoOrder;
import Atributos.CorreoOrder;
import java.util.List;
import com.infomedia.utils.PropertyLoader;
import java.util.Properties;
import org.apache.log4j.Logger;

public class RemedyControl
{
    private static final Logger log;
    Properties prop;
    private final String vsUsuarioRC;
    private final String vsFormularioRM;
    
    public RemedyControl() {
        this.prop = PropertyLoader.load("rutas.properties");
        this.vsUsuarioRC = this.prop.getProperty("USER_RM");
        this.vsFormularioRM = this.prop.getProperty("FORM_RM");
    }
    
    public boolean fncInsertRutinas(final List<CorreoOrder> poListWO) {
        boolean vbStatus = false;
        try {
            final RemedyPort voRP = this.getPort(this.prop.getProperty("wsdlURL"));
            for (final CorreoOrder ordenVO : poListWO) {
                final ListOfFields voFields = new ListOfFields();

               try {
              final InsertStatus localInsertStatus = voRP.rmdInsert(this.vsUsuarioRC, this.vsFormularioRM, voFields, (String)null);
         
                }
                catch (Exception e) {
                    RemedyControl.log.error((Object)e);
               }
            }
        }
        catch (Exception e2) {
            RemedyControl.log.error((Object)e2);
        }
        return vbStatus;
    }
    
    private ListOfFields fncParciar(final String psValor) {
        final ListOfFields voFields = new ListOfFields();
        for (String vsFiel : psValor.split("' '")) {
            final Field voField = new Field();
            vsFiel = vsFiel.replaceAll("'", "");
            final String[] voAux = vsFiel.split("=");
            voField.setId(Integer.parseInt(voAux[0]));
            voField.setValue(voAux[1]);
            voFields.addField(voField);
        }
        return voFields;
    }
    
    private RemedyPort getPort(final String psEndPoint) throws MalformedURLException {
        final QName serviceQN = new QName(this.prop.getProperty("namespace"), this.prop.getProperty("serviceName"));
        final QName portQN = new QName(this.prop.getProperty("namespace"), this.prop.getProperty("portName"));
        final Service service = Service.create(new URL(psEndPoint), serviceQN);
        return (RemedyPort)service.getPort(portQN, (Class)RemedyPort.class);
    }
    
    static {
        log = Logger.getLogger((Class)RemedyControl.class);
    }

    void fncInsertRutinas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
