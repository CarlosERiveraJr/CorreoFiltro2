
package BuscarArchivo;

//import com.telcel.csv.services.Correos;
import java.io.File;

public class BuscandoCenam4 {
    
        public static String MensajitoCenam4;
        public static String ArchivoErrorCenam4(){

        File archivo = new File("/home/remedy/FiltroCenamsh/CENAM4/ONBOARDING_ADM_USUARIOS_LDAP_EXTERNOS_ERROR.csv");
        if(!archivo.exists()){
      
           MensajitoCenam4="No se econtraron errores en el archivo ONBOARDING_ADM_USUARIOS_LDAP_EXTERNOS.TXT";
           System.out.println("¡NO existe el archivo!" + MensajitoCenam4);
        }else{
            
                MensajitoCenam4="Se detectaron errores en el archivo ONBOARDING_ADM_USUARIOS_LDAP_EXTERNOS.TXT favor de corregirlos.";
                System.out.println("El archivo si existe " + MensajitoCenam4);

            }  
        return MensajitoCenam4;
       
    }
}
