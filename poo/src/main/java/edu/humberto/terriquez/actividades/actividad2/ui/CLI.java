package edu.humberto.terriquez.actividades.actividad2.ui;

import java.util.Scanner;
import edu.humberto.terriquez.actividades.actividad2.process.NameValidator;
import edu.humberto.terriquez.actividades.actividad2.models.Number;

public class CLI {
    public static void runApp() {
        Scanner scanner = new Scanner(System.in);
        int[] numerosPares = Number.generarNumerosPares();
        showMenu();
        int opcion = scanner.nextInt();scanner.nextLine(); 
        
        while (opcion !=3) {
            switch (opcion) {
                case 1:
                    System.out.println("Ingresa tu nombre");
                    String name = scanner.nextLine();
                    if (NameValidator.validateName(name)) {
                        System.out.println("Nombre ya registrado.");
                    } else {  
                        System.out.println("Nombre no registrado.");
                    }
                    break;
                case 2:
                    System.out.println("En los primeros 100 numeros, los siguientes son pares:");
                    numerosPares = Number.generarNumerosPares();
                    mostrarNumeros(numerosPares);
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
            showMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Hasta luego!");


    }

    public static void mostrarNumeros(int[] numeros) {
        for (int i=0; i< numeros.length; i++){ 
            System.out.printf("%6d",numeros[i]);
            if((i+1)%10==0){
                System.out.println();
            }
        }
    }
    
    public static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Validar Nombres");
        System.out.println("2. Generador de números par");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

    }
}