package edu.humberto.terriquez.actividades.actividad1.process;

import java.util.ArrayList;
import java.util.List;

import edu.humberto.terriquez.actividades.actividad1.models.Car;

public class StockManager {
    ArrayList<Car> stock;
    public StockManager(){
        this.stock = new ArrayList<>();
    }

    public void addCar(String modelo, String marca, String color, int numeroPuertas, String placa){
        Car newCar = new Car(modelo, marca, color, numeroPuertas, placa);
        stock.add(newCar);
    }

    public List<Car> getStock(){
        return this.stock;
    }
}
