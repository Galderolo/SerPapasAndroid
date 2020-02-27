package com.tempus.tempusoftware.serpapas.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.database.EliminarBD;
import com.tempus.tempusoftware.serpapas.database.ModificarBD;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */


public class PopUpMenu extends PopupMenu implements PopupMenu.OnMenuItemClickListener {

    private Context context;
    private Integer position;
    private String categoria, producto;





    public PopUpMenu(Context context, View anchor, Integer position, String categoria, String producto) {
        super(context, anchor);
        this.context = context;
        this.position = position;
        this.categoria = categoria;
        this.producto = producto;

    }



    public void showPopUp () {

        setOnMenuItemClickListener(this);
        inflate(R.menu.popup);
        this.show();

    }

    public void showMenuadd () {
        setOnMenuItemClickListener(this);
        inflate(R.menu.addmenu);
        this.show();
    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popupBorrar: Borrar();
                return true;
            case R.id.popupModificar: Modificar();
                return true;

        }
        return false;
    }

    private void Modificar() {
        ModificarBD mod = new ModificarBD(context, position, categoria);
        mod.ModificarCategoria();
    }

    public void Borrar () {

        AlertDialog.Builder ad = new AlertDialog.Builder(GetContextPasser.getContextPasser(), R.style.PopupMenu);
        ad.setMessage("¿Estás segur@ de borrar "+producto+"?").setTitle("Borrar");
        ad.setIcon(R.drawable.ic_faltalista);


        ad.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "Borrado", Toast.LENGTH_LONG).show();
                //action here
                EliminarBD delete = new EliminarBD(categoria, position, context);
                delete.EliminarCampos();
            }
        });

        ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "No Borrado", Toast.LENGTH_LONG).show();
            }
        });

        ad.create().show();

    }


}
