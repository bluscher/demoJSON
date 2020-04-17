/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author e10934a
 */
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class JacksonSimpleTest {
    
    public static void main(String args[]){
    
        ObjectMapper mapper = new ObjectMapper();
        //nombre nombre variables deben ser los mismos
        String jsonString = "{\"nombre\":\"Berni\", \"edad\":38}";
        String jsonString2 = "{\"nombre\":\"Pepe\", \"edad\":20}";
        
     
        try {
            //readValue() metodo para obtener el Objeto de un String con formato JSON 
            Empleado empleado = mapper.readValue(jsonString, Empleado.class);
            System.out.println("OBJETO EMPLEADO INSTANCIADO desde string con formato json:\n" +empleado);
            
            System.out.println("----CREO ARCHIVO .json------");
            //creo a partir del objecto instanciado el archivo .json
            mapper.writeValue(new File("pruebaEmpleado.json"), empleado);
            Empleado empleado2 = mapper.readValue(new File("pruebaEmpleado.json"), Empleado.class);
            
            //metodo writeValueAsString, para obtener representacion de JSON de un objeto
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(empleado);
            System.out.println(jsonString);
            
        } catch (JsonParseException e) {e.printStackTrace();}
          catch (JsonMappingException e){e.printStackTrace();}
          catch (IOException e){e.printStackTrace();}
    }

    private static class Empleado {

        private String nombre;
        private int edad;
        public Empleado(){}
        public String getNombre(){
            return nombre;
        }
        public void setNombre(String n){
            this.nombre = n;
        }
        public int getEdad(){
            return this.edad;
        }
        public void setEdad(int e){
            this.edad = e;
        }
        public String toString(){
         return "Empleado [ nombre: "+nombre+", edad: "+ edad+ "]";
        }
    }//end Empleado
    
}
