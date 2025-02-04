package edu.humberto.terriquez.actividades.actividad1.process;

import java.util.ArrayList;
import java.util.List;

import edu.humberto.terriquez.actividades.actividad1.models.Car;

/**
* StockManager es la clase declarada para el manejo de inventario de carros,
* donde se encuentra el constructor "StockManager" el cual crea un
* array de objetos vacio tipo Car (Car.java) el cual es flexible.
*/
public class StockManager {
    ArrayList<Car> stock;
    public StockManager(){
        this.stock = new ArrayList<>();
    }

    /**
    * El metodo "addCar" permite agregar carros al inventario,
    * este recibe los parametros modelo, marca, color, numeroPuertas y placa
    */
    public void addCar(String modelo, String marca, String color, int numeroPuertas, String placa){
        Car newCar = new Car(modelo, marca, color, numeroPuertas, placa);
        stock.add(newCar);
    }

    /**
    * El metodo "getStock" devuelve el ArrayList<Car> el cual regresa
    * una lista de todos los carros almacenados en el inventario.
    */
    public List<Car> getStock(){
        return this.stock;
    }
}
