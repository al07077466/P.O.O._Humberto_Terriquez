package edu.humberto.terriquez.actividades.actividad3.process;

import edu.humberto.terriquez.actividades.actividad3.models.Product;

/**
 * PriceCalculator es la clase encargada de manejar el area logica sobre los calculos relacionados con el precio de los productos.
 * Esta clase contiene metodos que calculan los precios recomendados y comparan los mismos.
 */
public class PriceCalculator {
    /**
     * Metodo encargado de calcular el precio recomendado para un producto, incluyendo taxes y profit margin.
     * Recibe:
     * @param price
     * @param profitMargin
     * @param taxRate
     * Returna:
     * @return finalPrice
     */
    public static double calculateRecommendedPrice(double price, double profitMargin, double taxRate) {
        if (price < 0 || profitMargin < 0 || taxRate < 0) {
            throw new IllegalArgumentException("El precio, el porcentaje de utilidad y la tasa de impuesto deben ser positivos.");
        }
        double priceWithProfit = price + (price * (profitMargin / 100));
        double tax = priceWithProfit * (taxRate / 100);
        double finalPrice = priceWithProfit + tax;

        return finalPrice;
    }

    /**
     * Metodo encargado de calcular el precio inculyendo el tax, con su excepcion en caso de estar vacio.
     * Recibe:
     * @param product
     * Returna:
     * @return El precio total con tax.
     */
    public static double calculateTotalPrice(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        return product.getPrice() + product.getTax();
    }

    /**
     * Metodo encargado de comparar el precio de 2 productos seleccionados.
     * Recibe:
     * @param product1
     * @param product2
     * Returna:
     * @return El producto que tenga un precio mas elevado.
     */
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