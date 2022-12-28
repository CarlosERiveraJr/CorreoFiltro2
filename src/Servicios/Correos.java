//package com.telcel.csv.services;
package Servicios;

//import BuscarArchivo.Buscando;
//import static BuscarArchivo.Buscando.ArchivoError;
//import static BuscarArchivo.Buscando.Mensajito;
import BuscarArchivo.BuscandoCenam1;
import static BuscarArchivo.BuscandoCenam1.MensajitoCenam1;
import BuscarArchivo.BuscandoCenam2;
import static BuscarArchivo.BuscandoCenam2.MensajitoCenam2;
import BuscarArchivo.BuscandoCenam3;
import static BuscarArchivo.BuscandoCenam3.MensajitoCenam3;
import BuscarArchivo.BuscandoCenam4;
import static BuscarArchivo.BuscandoCenam4.MensajitoCenam4;
import javax.mail.MessagingException;
import javax.mail.Transport;
import java.util.Iterator;
import javax.mail.internet.AddressException;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import com.telcel.sir.pojos.CorreoOrder;
import Atributos.CorreoOrder;
import java.util.List;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import com.infomedia.utils.PropertyLoader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import static java.nio.file.Files.lines;
import java.nio.file.Paths;
import static java.sql.DriverManager.println;
import static java.util.Arrays.stream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.log4j.Logger;
import javax.mail.Session;
import java.util.Properties;
import java.util.logging.Level;
import java.util.stream.Stream;
import static javax.swing.DebugGraphics.logStream;

public class Correos
{
    Properties voPropertiesproperties;
    Session veEmailSession;
    
    //Declaración de Clientes de correos
    Properties prop = PropertyLoader.load("rutas.properties");
    static private String vsCliente1;
    public final Logger LOG;

    public Correos() {
       Correos.vsCliente1 = this.prop.getProperty("CLIENTE1");
       this.LOG = Logger.getLogger((Class)DescargaServices.class);
    }
    
    public void init() {
        (this.voPropertiesproperties = new Properties()).put("mail.host", this.prop.getProperty("HOST_MAIL"));
        this.voPropertiesproperties.put("mail.user", this.prop.getProperty("USER_MAIL"));
        this.voPropertiesproperties.put("mail.transport.protocol", "smtp");
        this.voPropertiesproperties.put("mail.smtp.sendpartial", "true");
        this.voPropertiesproperties.put("mail.debug", "true");
        (this.veEmailSession = Session.getInstance(this.voPropertiesproperties, (Authenticator)new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Correos.this.prop.getProperty("USER_MAIL"), Correos.this.prop.getProperty("G3l4t#n4"));
            }
        })).setDebug(true);
    }
 
    public  void fncEnviarCorreo() {
        try {
            if (!Correos.vsCliente1.isEmpty() || Correos.vsCliente1 != null || !Correos.vsCliente1.equals("NA")) {
                this.init();
                final MimeMessage voMensaje = new MimeMessage(this.veEmailSession);
                voMensaje.setFrom((Address)new InternetAddress("remedycontrol.amx@mail.telcel.com"));
                voMensaje.addRecipient(Message.RecipientType.TO, (Address)new InternetAddress(Correos.vsCliente1));
                voMensaje.setSubject(this.prop.getProperty("MOTIVO_MAIL"));
                String bajas = "\n\n";
 
                //Buscando.ArchivoError();
                BuscandoCenam1.ArchivoErrorCenam1();
                BuscandoCenam2.ArchivoErrorCenam2();
                BuscandoCenam3.ArchivoErrorCenam3();
                BuscandoCenam4.ArchivoErrorCenam4();
                
                //bajas = bajas + " MENSAJE: "+ Mensajito +"\n";
                bajas = bajas + " MENSAJE CENAM1: "+ MensajitoCenam1 +"\n";
                bajas = bajas + " MENSAJE CENAM2: "+ MensajitoCenam2 +"\n";
                bajas = bajas + " MENSAJE CENAM3: "+ MensajitoCenam3 +"\n";
                bajas = bajas + " MENSAJE CENAM4: "+ MensajitoCenam4 +"\n";

                voMensaje.setText(this.prop.getProperty("MENSAJE_MAIL") + bajas  );
                Transport voTransport = this.veEmailSession.getTransport("smtp");
                voTransport.connect();
                voTransport.sendMessage(voMensaje, voMensaje.getAllRecipients());
                voTransport.close();

                System.out.println("Enviando Correo3\n\n");
                           
            }
        } catch (AddressException var6) {
            this.LOG.error("ERROR AL ENVIAR EL CORREO: " + var6);
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(Correos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}