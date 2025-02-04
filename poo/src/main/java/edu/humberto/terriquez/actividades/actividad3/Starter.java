package edu.humberto.terriquez.actividades.actividad3;

import edu.humberto.terriquez.actividades.actividad3.ui.CLI;

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