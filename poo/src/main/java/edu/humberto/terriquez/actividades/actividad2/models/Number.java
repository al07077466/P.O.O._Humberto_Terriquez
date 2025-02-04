package edu.humberto.terriquez.actividades.actividad2.models;

/**
 * La clase Number, utiliza un bucle for para generar todos los numerospares del 1 al 100
 * en un arreglo llamado numerosPares el cual solo tiene espacio para 50 elementos.
 */
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
