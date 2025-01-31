package edu.humberto.terriquez.actividades.actividad3.process;

import edu.humberto.terriquez.actividades.actividad3.models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductStockManager {
    private List<Product> stock;

    public ProductStockManager() {
        this.stock = new ArrayList<>();
    }

    public void addProduct(String name, String description, String code, String type, double price) {
        double tax = price * 0.16;
        Product product = new Product(name, description, code, type, price, tax);
        stock.add(product);
    }

    public List<Product> getStock() {
        return stock;
    }

    public Product findProductByName(String name) {
        for (Product product : stock) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
}