package com.tempus.tempusoftware.serpapas.util;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.tempus.tempusoftware.serpapas.AddActivity;
import com.tempus.tempusoftware.serpapas.BanioActivity;
import com.tempus.tempusoftware.serpapas.CasaActivity;
import com.tempus.tempusoftware.serpapas.ComerActivity;
import com.tempus.tempusoftware.serpapas.FaltaActivity;
import com.tempus.tempusoftware.serpapas.LegalActivity;
import com.tempus.tempusoftware.serpapas.OpcionesActivity;
import com.tempus.tempusoftware.serpapas.PaseoActivity;
import com.tempus.tempusoftware.serpapas.RopaActivity;
import com.tempus.tempusoftware.serpapas.TengoActivity;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */


/**
 * Esta clase lo único que hace es facilitarnos el traspaso de datos desde cualquier otra activity
 * para llamar a los metodos principales.
 * 
 */

public class TodasOpciones  {

    String t;
    Context c;

    public TodasOpciones(String t, Context c) {
        this.t = t;
        this.c = c;
    }

    public void goToOption() {

        switch (t) {
            case Util.ADD_MENU: AddMenu();
                break;
            case Util.BAÑO_MENU: ParaBaño();
                break;
            case Util.PASEO_MENU: ParaPaseo();
                break;
            case Util.ROPA_MENU: Ropa();
                break;
            case Util.COMIDA_MENU: ParaComer();
                break;
            case Util.CASA_MENU: ParaCasa();
                break;
            case Util.TIENE_MENU: QueTiene();
                break;
            case Util.FALTA_MENU: QueFalta();
                break;
            case Util.CUENTATRAS_MENU: CuentAtras();
                break;
            case Util.OPCIONES: Opciones();
                break;
            case Util.LEGAL: Legal();
                break;
        }
    }

    private void AddMenu() {
        Intent i = new Intent(c, AddActivity.class);
        c.startActivity(i);

    }

    private void Legal() {
        Intent i = new Intent(c, LegalActivity.class);
        c.startActivity(i);
    }

    private void Opciones() {
        Intent i = new Intent(c, OpcionesActivity.class);
        c.startActivity(i);
    }

    private void CuentAtras() {
        Toasting();
    }

    private void QueFalta() {
        Intent i = new Intent(c, FaltaActivity.class);
        c.startActivity(i);

    }

    private void QueTiene() {
        Intent i = new Intent (c, TengoActivity.class);
        c.startActivity(i);

    }

    private void ParaCasa() {
        Intent i = new Intent(c, CasaActivity.class);
        c.startActivity(i);

    }

    private void ParaComer() {
        Intent i = new Intent(c, ComerActivity.class);
        c.startActivity(i);

    }

    private void Ropa() {
        Intent i = new Intent(c, RopaActivity.class);
        c.startActivity(i);

    }

    private void ParaPaseo() {
        Intent i = new Intent(c, PaseoActivity.class);
        c.startActivity(i);

    }

    private void ParaBaño() {
        Intent i = new Intent(c, BanioActivity.class);
        c.startActivity(i);


    }

    public void Toasting () {
        Toast.makeText(c, "Seleccion: "+t, Toast.LENGTH_SHORT).show();
    }
}
