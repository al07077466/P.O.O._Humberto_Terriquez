package edu.humberto.terriquez.actividades.actividad3.process;

import edu.humberto.terriquez.actividades.actividad3.models.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductStockManager {
    private List<Product> stock;
    private Scanner scanner;

    public ProductStockManager() {
        this.stock = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct() {
        try {
            System.out.print("Nombre del producto: ");
            String name = scanner.nextLine();
            System.out.print("Descripción: ");
            String description = scanner.nextLine();
            System.out.print("Código (10 dígitos): ");
            String code = scanner.nextLine();
            System.out.print("Tipo de producto: ");
            String type = scanner.nextLine();
            System.out.print("Precio: ");
            double price = Double.parseDouble(scanner.nextLine());
            
            double tax = price * 0.16;
            Product product = new Product(name, description, code, type, price, tax);
            stock.add(product);
            System.out.println("Producto agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

    public void displayProductList() {
        if (stock.isEmpty()) {
            System.out.println("No hay productos en el stock.");
            return;
        }
        for (Product product : stock) {
            System.out.println("Nombre: " + product.getName() + ", Descripción: " + product.getDescription() +
                    ", Código: " + product.getCode() + ", Tipo: " + product.getType() + ", Precio: " + product.getPrice());
            //return this.stock;
        }
    }
}