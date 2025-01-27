package edu.humberto.terriquez.actividades.actividad1.ui;

import java.util.Scanner;

import edu.humberto.terriquez.actividades.actividad1.process.StockManager;

/**
* CLI (Command Line Interface) es la interfaz creada para gestionar el menu
* encargado de la gestion del stock de carros, este nos permite agregar carros y visualizar el stock.
*/
public class CLI {
    /**
    * "runApp" es el metodo corazon del programa, el cual se encarga de ejecutar y gestionar
    * las 3 opciones disponibles en el menu y leer la opcion que el usario elija.
    */
    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        StockManager stockManager = new StockManager();
        showMenu();
        int opcion = scanner.nextInt();scanner.nextLine();

        while (opcion!=3){
            switch (opcion){
                //Where case 1 agrega un carro al inventario.
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
                //Where case 2 hace un display del stock actual.
                case 2:
                    System.out.println("Stock Actual:");
                    stockManager.getStock().forEach(System.out::println);
                    break;
                //Where default muestra un mensaje de error cuando una opcion no valida es elegida.
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            showMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
        //Y finaliza con la 3er opcion que muestra un mensaje de salida.
        System.out.println("Fin");
    }

    /**
    * "showMenu" es el metodo encargado de mostrar las opciones disponibles en la consola.
    */
    public static void showMenu() {
        System.out.println("Menu" + 
        "\n 1. Agregar Carro al Catalogo" + 
        "\n 2. Mostrar Catalogo" + 
        "\n 3. Salir");
    }
}
