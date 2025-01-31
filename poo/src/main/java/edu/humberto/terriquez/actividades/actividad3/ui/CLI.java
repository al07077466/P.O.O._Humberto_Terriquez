package edu.humberto.terriquez.actividades.actividad3.ui;

import edu.humberto.terriquez.actividades.actividad3.models.Product;
import edu.humberto.terriquez.actividades.actividad3.process.PriceCalculator;
import edu.humberto.terriquez.actividades.actividad3.process.ProductStockManager;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private Scanner scanner;
    private ProductStockManager stockManager;

    public CLI() {
        scanner = new Scanner(System.in);
        stockManager = new ProductStockManager();
    }

    public void runApp() {
        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    displayProductList();
                    break;
                case "2":
                    addProduct();
                    break;
                case "3":
                    compareProducts();
                    break;
                case "4":
                    calculateRecommendedPrice();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Mostrar Stock");
        System.out.println("2. Agregar Producto");
        System.out.println("3. Comparar Productos");
        System.out.println("4. Calcular precio recomendado");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void displayProductList() {
        List<Product> stock = stockManager.getStock();
        if (stock.isEmpty()) {
            System.out.println("No hay productos en el stock.");
            return;
        }
        for (Product product : stock) {
            System.out.println("Nombre: " + product.getName() + ", Descripción: " + product.getDescription() +
                    ", Código: " + product.getCode() + ", Tipo: " + product.getType() + ", Precio: " + product.getPrice() +
                    ", Impuesto: " + product.getTax());
        }
    }

    private void addProduct() {
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

            stockManager.addProduct(name, description, code, type, price);
            System.out.println("Producto agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        }
    }

    private void compareProducts() {
        try {
            System.out.print("Ingresa el nombre del primer producto: ");
            String name1 = scanner.nextLine();
            System.out.print("Ingresa el nombre del segundo producto: ");
            String name2 = scanner.nextLine();

            Product product1 = stockManager.findProductByName(name1);
            Product product2 = stockManager.findProductByName(name2);

            if (product1 == null || product2 == null) {
                System.out.println("Uno o ambos productos no fueron encontrados.");
                return;
            }

            String comparisonResult = PriceCalculator.compareProducts(product1, product2);
            System.out.println(comparisonResult);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void calculateRecommendedPrice() {
        try {
            System.out.print("Ingresa el precio del producto: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Ingresa el porcentaje de utilidad deseado: ");
            double profitMargin = Double.parseDouble(scanner.nextLine());
    
            // Calculate the recommended price with a 16% tax rate
            double finalPrice = PriceCalculator.calculateRecommendedPrice(price, profitMargin, 16);
            System.out.println("El precio final recomendado es: " + finalPrice);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}