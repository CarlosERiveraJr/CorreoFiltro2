
package BuscarArchivo;

//import com.telcel.csv.services.Correos;
import java.io.File;

public class BuscandoCenam2 {
    
        public static String MensajitoCenam2;
        public static String ArchivoErrorCenam2(){

        File archivo = new File("/home/remedy/FiltroCenamsh/CENAM2/HUR_ADM_USUARIOS_LDAP_ERROR.csv");
        if(!archivo.exists()){
      
           MensajitoCenam2="No se econtraron errores en el archivo HUR_ADM_USUARIOS_LDAP.TXT";
           System.out.println("¡NO existe el archivo!" + MensajitoCenam2);
        }else{
            
                MensajitoCenam2="Se detectaron errores en el archivo HUR_ADM_USUARIOS_LDAP.TXT favor de corregirlos.";
                System.out.println("El archivo si existe " + MensajitoCenam2 );

            }  
        return MensajitoCenam2;
       
    }
}
