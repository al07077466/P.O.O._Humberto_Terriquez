package edu.humberto.terriquez.actividades.actividad2.process;
import edu.humberto.terriquez.actividades.actividad2.models.Data;

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
