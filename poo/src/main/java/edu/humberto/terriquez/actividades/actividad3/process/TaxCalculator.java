package edu.humberto.terriquez.actividades.actividad3.process;

public class TaxCalculator {
    public static double getTaxPrice(double price, double tax) {
        return price + (price * (tax / 100));
    }
}
