package edu.humberto.terriquez.actividades.actividad3.ui;

import edu.humberto.terriquez.actividades.actividad3.models.Product;
import edu.humberto.terriquez.actividades.actividad3.process.ProductStockManager;
import edu.humberto.terriquez.actividades.actividad3.process.TaxCalculator;
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
                    consultRecommendedPrice();
                    break;
                case "2":
                    stockManager.addProduct();
                    break;
                case "3":
                    stockManager.displayProductList();
                    break;
                case "4":
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
        System.out.println("1. Consultar precio recomendado");
        System.out.println("2. Agregar producto");
        System.out.println("3. Mostrar stock");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void consultRecommendedPrice() {
        try {
            System.out.print("Ingresa el precio del producto: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Ingresa el porcentaje de utilidad deseado: ");
            double profitMargin = Double.parseDouble(scanner.nextLine());
            if (price < 0 || profitMargin < 0) {
                throw new IllegalArgumentException("El precio y el porcentaje de utilidad deben ser positivos.");
            }
            double finalPrice = price + (price * (profitMargin / 100));
            System.out.println("El precio final recomendado es: " + finalPrice);
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida o negativa.");
        }
    }
}