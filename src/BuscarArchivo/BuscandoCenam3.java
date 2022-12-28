
package BuscarArchivo;

//import com.telcel.csv.services.Correos;
import java.io.File;

public class BuscandoCenam3 {
    
    public static String MensajitoCenam3;
        public static String ArchivoErrorCenam3(){

        File archivo = new File("/home/remedy/FiltroCenamsh/CENAM3/HRMS_ADM_USUARIOS_LDAP_ERROR.csv");
        if(!archivo.exists()){
      
           MensajitoCenam3="No se econtraron errores en el archivo HRMS_ADM_USUARIOS_LDAP.TXT";
           System.out.println("¡NO existe el archivo!" + MensajitoCenam3);
        }else{
            
                MensajitoCenam3="Se detectaron errores en el archivo HRMS_ADM_USUARIOS_LDAP.TXT favor de corregirlos.";
                System.out.println("El archivo si existe " + MensajitoCenam3);

            }  
        return MensajitoCenam3;
       
    }
}
