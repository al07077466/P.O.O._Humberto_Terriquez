package edu.humberto.terriquez.actividades.actividad3.process;

import edu.humberto.terriquez.actividades.actividad3.models.Product;

public class PriceCalculator {
    public static double calculateRecommendedPrice(double price, double profitMargin, double taxRate) {
        if (price < 0 || profitMargin < 0 || taxRate < 0) {
            throw new IllegalArgumentException("El precio, el porcentaje de utilidad y la tasa de impuesto deben ser positivos.");
        }
        double priceWithProfit = price + (price * (profitMargin / 100));
        double tax = priceWithProfit * (taxRate / 100);
        double finalPrice = priceWithProfit + tax;

        return finalPrice;
    }

    public static double calculateTotalPrice(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        return product.getPrice() + product.getTax();
    }

    public static String compareProducts(Product product1, Product product2) {
        if (product1 == null || product2 == null) {
            throw new IllegalArgumentException("Ambos productos deben ser válidos.");
        }

        double totalPrice1 = calculateTotalPrice(product1);
        double totalPrice2 = calculateTotalPrice(product2);

        if (totalPrice1 > totalPrice2) {
            return "El primer producto es más caro.";
        } else if (totalPrice1 < totalPrice2) {
            return "El segundo producto es más caro.";
        } else {
            return "Ambos productos tienen el mismo precio.";
        }
    }
}