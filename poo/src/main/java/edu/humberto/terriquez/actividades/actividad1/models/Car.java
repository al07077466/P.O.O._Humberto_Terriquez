package edu.humberto.terriquez.actividades.actividad1.models;

public class Car {
    private String modelo;
    private String marca;
    private String color;
    private int numeroPuertas;
    private String placa;

    public String toString() {
        return "Car{ " +
                "modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", numeroPuertas=" + numeroPuertas + '\'' +
                ", Placa=" + placa + '\'' +
                '}';
    }

    public Car(String modelo, String marca, String color, int numeroPuertas, String placa) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.setNumeroPuertas(numeroPuertas);
        this.placa = placa;
    }

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
