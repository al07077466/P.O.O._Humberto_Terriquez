package edu.humberto.terriquez.actividades.actividad1.ui;

import java.util.Scanner;

public class CLI {
    public static void runApp(){
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int opcion = scanner.nextInt();

        while (opcion!=3){
            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            showMenu();
            opcion = scanner.nextInt();
        }
    }

    /* */
    public static void showMenu() {
        System.out.println("Menu" + 
        "\n 1. Agregar Carro al Catalogo" + 
        "\n 2. Mostrar Catalogo" + 
        "\n 3. Salir");
    }

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

}
