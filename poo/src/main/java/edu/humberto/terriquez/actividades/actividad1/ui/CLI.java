package edu.humberto.terriquez.actividades.actividad1.ui;

import java.util.Scanner;

import edu.humberto.terriquez.actividades.actividad1.process.StockManager;

public class CLI {
    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        StockManager stockManager = new StockManager();
        showMenu();
        int opcion = scanner.nextInt();scanner.nextLine();

        while (opcion!=3){
            switch (opcion){
                case 1:
                    System.out.println("Introduce el Modelo");
                    String modelo = scanner.nextLine();
                    System.out.println("Introduce la Marca");
                    String marca = scanner.nextLine();
                    System.out.println("Introduce el Color");
                    String color = scanner.nextLine();
                    System.out.println("Introduce el # de Puertas");
                    int numeroPuertas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce el # de Placa");
                    String placa = scanner.nextLine();

                    stockManager.addCar(modelo, marca, color, numeroPuertas, placa);
                    System.out.println("Carro agregado con exito");
                    break;
                case 2:
                    System.out.println("Stock Actual:");
                    stockManager.getStock().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            showMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Fin");
    }

    public static void showMenu() {
        System.out.println("Menu" + 
        "\n 1. Agregar Carro al Catalogo" + 
        "\n 2. Mostrar Catalogo" + 
        "\n 3. Salir");
    }
    
    /* 
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String[] estudiantes) {
        for (String estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
    */

}
