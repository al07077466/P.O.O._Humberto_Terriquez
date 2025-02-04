package edu.humberto.terriquez.actividades.actividad2.process;
import edu.humberto.terriquez.actividades.actividad2.models.Data;

/**
 * NameValidator es el nombre que se le dio a la calse encargada de validar si un nombre
 * se encuentra en la lista predefinida de Data.nombres. Convierte el nombre ingresado a
 * minusculas para evitar errores, compara cada nombre con el valor ingresado con un
 * buclefor-each y returna true o false dependiendo del input ingresado.
 */
public class NameValidator {
    public static boolean validateName(String name){
        String storedName = name.toLowerCase();
        boolean isValid = false;
        for(String nameToValidate: Data.nombres){
            if(nameToValidate.toLowerCase().equals(storedName)){
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
