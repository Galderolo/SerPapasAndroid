package com.tempus.tempusoftware.serpapas.util;

/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */
public class CategoriaSpinner  {

    private String categorias;
    private int iconos;

    public CategoriaSpinner(String categorias, int iconos) {
        this.categorias = categorias;
        this.iconos = iconos;
    }

    public String getCategorias() {
        return categorias;
    }

    public int getIconos() {
        return iconos;
    }


}
