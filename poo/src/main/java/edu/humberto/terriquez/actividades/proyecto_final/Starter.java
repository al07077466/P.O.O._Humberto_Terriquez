package edu.humberto.terriquez.actividades.proyecto_final;

import edu.humberto.terriquez.actividades.proyecto_final.ui.CLI;

/**
 * Clase encargada de inicializar la aplicacion, utilizando CLI para ejecutarlo.
 */
public class Starter {
    /**
     * Metodo main encargado de inicializar la aplicacion.
     */
    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.runApp();
    }
}