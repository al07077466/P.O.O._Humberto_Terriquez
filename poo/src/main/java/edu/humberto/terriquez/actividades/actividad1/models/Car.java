package edu.humberto.terriquez.actividades.actividad1.models;

/**
 * Declaracion de la clase "Car", con atrivutos privados String & Int
 * usados para almacenar la informacion sobre un carro. (More on next comments)
 */
public class Car {
    private String modelo;
    private String marca;
    private String color;
    private int numeroPuertas;
    private String placa;

    /**
    * Metodo toString que convierte el objeto Car a una cadena de texto,
    * utilizado para imprimir los atributos del objeto de manera legible.
    */
    public String toString() {
        return "Car{ " +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", numeroPuertas='" + numeroPuertas + '\'' +
                ", Placa='" + placa + '\'' +
                '}';
    }

    /**
    * Constructor de la clase Car, utilizado para crear nuevos objetos de tipo Car
    * Cuenta con modelo, marca, color, numeroPuertas y placa como parametros.
    */
    public Car(String modelo, String marca, String color, int numeroPuertas, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.setNumeroPuertas(numeroPuertas);
        this.placa = placa;
    }

    /**
    * Metodos get y set,
    * donde los getter devuelven el valor de los atributos privados de la clase &
    * setter permiten modificar los valores de los atributos privados.
    */
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
    * Utilizamos la excepcion "IllegalArgumentException" como validación
    * para asegurarse de que el número de puertas esté entre 3 y 5.
    */
    public void setNumeroPuertas(int numeroPuertas) {
        if(numeroPuertas<3 || numeroPuertas>5){
            throw new IllegalArgumentException("El Numero de Puertas Valido es de 3 a 5 (Incluye Hatchback)");
        }
        this.numeroPuertas = numeroPuertas;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }
}
