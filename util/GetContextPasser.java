package com.tempus.tempusoftware.serpapas.util;
import android.content.Context;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */

/**
 * Esta clase recibe y manda el contexto de una actividad
 */
public class GetContextPasser  {


    public static Context context;

    public GetContextPasser(Context context) {
        this.context = context;
    }

    public static Context getContextPasser () {

        return context;
    }
}
