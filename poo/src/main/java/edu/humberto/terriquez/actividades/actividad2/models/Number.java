package edu.humberto.terriquez.actividades.actividad2.models;

public class Number {
    public static int[] generarNumerosPares() {
        int[] numerosPares = new int[50];
        int index = 0;

        for (int i = 2; i <= 100; i += 2) {
            numerosPares[index] = i;
            index++;
        }
        return numerosPares;
    }
}
