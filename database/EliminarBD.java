package com.tempus.tempusoftware.serpapas.database;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tempus.tempusoftware.serpapas.BanioActivity;
import com.tempus.tempusoftware.serpapas.CasaActivity;
import com.tempus.tempusoftware.serpapas.ComerActivity;
import com.tempus.tempusoftware.serpapas.FaltaActivity;
import com.tempus.tempusoftware.serpapas.PaseoActivity;
import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.RopaActivity;
import com.tempus.tempusoftware.serpapas.TengoActivity;
import com.tempus.tempusoftware.serpapas.util.Util;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */

public class EliminarBD {

    private String  categoria;
    private Context context;
    private Cursor fila;
    private Integer position;
    private Boolean esBorrado = false;


    /**
     * Eliminar BD Constructor
     * @param categoria
     * @param position
     * @param context
     */
    public EliminarBD (String categoria, Integer position, Context context) {

        this.position = position;
        this.categoria = categoria;
        this.context = context;

    }

    public EliminarBD (Context context, String categoria, Boolean esBorrado) {
        this.context = context;
        this.categoria = categoria;
        this.esBorrado = esBorrado;
    }

    public void EliminarCampos () {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();


        if(categoria.equals(Util.QUERY_FALTA)) BorradoFalta(baseDeDatos);
        else if(categoria.equals(Util.QUERY_TENGO))  BorradoTengo(baseDeDatos);
        else if (!esBorrado) BorradoCategoria(baseDeDatos);
        else BorradoCompletoporCategoria();

        baseDeDatos.close();

    }

    private void BorradoCompletoporCategoria() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
        final SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        AlertDialog.Builder dialog = new AlertDialog.Builder(context, R.style.PopupMenu);
        dialog.setMessage("Estás segur@ de borrar todo en "+categoria+"?").setTitle("Borrar Todo");
        dialog.setIcon(R.drawable.ic_faltalista);
        dialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int c = baseDeDatos.delete(Util.TABLA_BD,"categoria="+categoria, null); //borramosç

               switch (categoria) {
                    case Util.CATEGORIA_BAÑO: BanioActivity.UpdateLista();
                        break;
                    case Util.CATEGORIA_ROPA: RopaActivity.UpdateLista();
                        break;
                    case Util.CATEGORIA_COMIDA: ComerActivity.UpdateLista();
                        break;
                    case Util.CATEGORIA_PASEO: PaseoActivity.UpdateLista();
                        break;
                    case Util.CATEGORIA_CASA: CasaActivity.UpdateLista();
                        break;
                }
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.create().show();

    }

    private void BorradoTengo (SQLiteDatabase baseDeDatos) {

        //si categoria es lo tengo
        fila = baseDeDatos.rawQuery(Util.QUERY_TENGO, null);
        fila.moveToPosition(position);
        long id = fila.getLong(fila.getColumnIndex("id"));
        baseDeDatos.delete(Util.TABLA_BD, "id="+id, null);
        TengoActivity.UpdateLista();
    }

    private void BorradoFalta (SQLiteDatabase baseDeDatos) {

        //si categoria es no lo tengo
        fila = baseDeDatos.rawQuery(Util.QUERY_FALTA, null);
        fila.moveToPosition(position);
        long id = fila.getLong(fila.getColumnIndex("id"));
        baseDeDatos.delete(Util.TABLA_BD, "id="+id, null);
        FaltaActivity.UpdateList();

    }

    private void BorradoCategoria (SQLiteDatabase baseDeDatos) {

        fila = baseDeDatos.rawQuery(Util.QUERY_CATEGORY+categoria ,null);
        fila.moveToPosition(position); // nos vamos a la posicion que queremos borrar
        long id = fila.getLong(fila.getColumnIndex("id"));  //obtenemos la ID desde la base de datos en la posicion
        int c = baseDeDatos.delete(Util.TABLA_BD,"id="+id, null); //borramos

        //segun la categoria llamamos a actualizar el listview llamando al getView
        switch (categoria) {
            case Util.CATEGORIA_BAÑO:
                BanioActivity.UpdateLista();
                break;
            case Util.CATEGORIA_CASA:
                CasaActivity.UpdateLista();
                break;
            case Util.CATEGORIA_COMIDA:
                ComerActivity.UpdateLista();
                break;
            case Util.CATEGORIA_PASEO:
                PaseoActivity.UpdateLista();
                break;
            case Util.CATEGORIA_ROPA:
                RopaActivity.UpdateLista();
                break;
        }

    }


}
