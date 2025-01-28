package edu.humberto.terriquez.actividades.actividad2.models;

/**
 * La clase "Data", se encarga de almacenar el array de nombres predefinidos
 * junto con los metodos getName y setName los cuales acceden al array.
 */
public class Data {
    private String name;
    public static String[] nombres= {"Humberto", "Esteban", "Alex", "Felipe", "Carlos"};

    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
