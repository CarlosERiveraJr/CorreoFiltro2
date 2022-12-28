
package BuscarArchivo;

//import com.telcel.csv.services.Correos;
import java.io.File;

public class BuscandoCenam1 {
    
    public static String MensajitoCenam1;
    public static String ArchivoErrorCenam1(){

        File archivo = new File("/home/remedy/FiltroCenamsh/CENAM1/GENSYS_ADM_USUARIOS_LDAP_ERROR.csv");
        if(!archivo.exists()){
      
           MensajitoCenam1="No se econtraron errores en el archivo GENSYS_ADM_USUARIOS_LDAP.TXT";
           System.out.println("¡NO existe el archivo!" + MensajitoCenam1);
        }else{
            
                MensajitoCenam1="Se detectaron errores en el archivo GENSYS_ADM_USUARIOS_LDAP.TXT favor de corregirlos.";
                System.out.println("El archivo si existe " + MensajitoCenam1 );

            }  
        return MensajitoCenam1;
       
    }
}
