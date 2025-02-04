package edu.humberto.terriquez.actividades.actividad3.process;

import edu.humberto.terriquez.actividades.actividad3.models.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de manejar el stock de productos dentro de la tienda.
 * Contiene metodos para agregar productos, retrieve el stock y encontrar productos por nombre (Utilizado en PriceCalculator.java).
 */
public class ProductStockManager {
    private List<Product> stock;

    /**
     * Constructor encargado de inicializar el array del stock.
     */
    public ProductStockManager() {
        this.stock = new ArrayList<>();
    }

    /**
     * Metodo addProduct, encargado de anadir un producto al stock.
     * Recibe:
     * @param name
     * @param description
     * @param code
     * @param type
     * @param price
     */
    public void addProduct(String name, String description, String code, String type, double price) {
        double tax = price * 0.16;
        Product product = new Product(name, description, code, type, price, tax);
        stock.add(product);
    }

    /**
     * getStock regresa la lista de productos en stock.
     */
    public List<Product> getStock() {
        return stock;
    }

    /**
     * Metodo que encuentra un producto en la tienda por su nombre.
     * Recibe:
     * @param name
     * Regresa:
     * @return El producto si es encontrado, si no, null.
     */
    public Product findProductByName(String name) {
        for (Product product : stock) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}