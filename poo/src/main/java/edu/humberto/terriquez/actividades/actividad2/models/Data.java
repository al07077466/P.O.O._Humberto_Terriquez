package edu.humberto.terriquez.actividades.actividad2.models;

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
