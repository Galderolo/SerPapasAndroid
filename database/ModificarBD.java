package com.tempus.tempusoftware.serpapas.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.tempus.tempusoftware.serpapas.BanioActivity;
import com.tempus.tempusoftware.serpapas.CasaActivity;
import com.tempus.tempusoftware.serpapas.ComerActivity;
import com.tempus.tempusoftware.serpapas.FaltaActivity;
import com.tempus.tempusoftware.serpapas.ModifyActivity;
import com.tempus.tempusoftware.serpapas.PaseoActivity;
import com.tempus.tempusoftware.serpapas.RopaActivity;

import com.tempus.tempusoftware.serpapas.TengoActivity;
import com.tempus.tempusoftware.serpapas.util.GetContextPasser;
import com.tempus.tempusoftware.serpapas.util.Util;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */
public class ModificarBD  {


    private Context context;
    private EditText producto, donde, notas, cantidad;
    private Switch sino;
    private String categoriaSpinner;
    private Integer position;
    private Cursor cursor;
    private String categoria, sw, catOriginal;
    private long id;


    public ModificarBD(Context context, EditText producto, EditText donde, EditText notas, EditText cantidad, String categoriaSpinner, Switch sino, Integer position, Long id, String catOriginal) {

        this.context = context;
        this.producto = producto;
        this.donde = donde;
        this.notas = notas;
        this.cantidad = cantidad;
        this.sino = sino;
        this.categoriaSpinner = categoriaSpinner;
        this.position = position;
        this.id = id;
        this.catOriginal = catOriginal;

    }

    public ModificarBD(Context context, Integer position, String categoria) {
        this.context = context;
        this.position = position;
        this.categoria = categoria;

    }


    public void ModificarCategoria() {

        String producto = null, donde = null, notas = null, cantidad = null, categoria_Original = null;


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        //obtenemos el contexto preguntando directamente
        Context c = GetContextPasser.getContextPasser();

        //Si el contexto es TengoActivity entonces el query cambia
        if (c.equals(TengoActivity.getContext())) {
            cursor = baseDeDatos.rawQuery(Util.QUERY_TENGO, null);
            cursor.moveToPosition(position);
            id = cursor.getLong(cursor.getColumnIndex("id"));

            //sino pues es el query normal de categoria
            //este else es el que estaba anteriormente
        }else if(c.equals(FaltaActivity.getContext())) {
            cursor = baseDeDatos.rawQuery(Util.QUERY_FALTA, null);
            cursor.moveToPosition(position);
            id = cursor.getLong(cursor.getColumnIndex("id"));

        }else {

            cursor = baseDeDatos.rawQuery(Util.QUERY_CATEGORY + categoria, null);
            cursor.moveToPosition(position);
            id = cursor.getLong(cursor.getColumnIndex("id"));
        }

        if(cursor.moveToPosition(position)) {

            producto = cursor.getString(1);
            donde = cursor.getString(2);
            notas = cursor.getString(3);
            cantidad = cursor.getString(4);
            categoria_Original = cursor.getString(5);
        }


        baseDeDatos.close();


        Intent i = new Intent(context, ModifyActivity.class); // aqui es donde creamos la actividad para modificar
        Bundle extras = new Bundle();
        extras.putBoolean("modificar", true);
        extras.putInt("position", position);
        extras.putLong("id", id);
        extras.putString("producto", producto);
        extras.putString("donde", donde);
        extras.putString("notas", notas);
        extras.putString("cantidad", cantidad);
        extras.putString("categoria_original", categoria_Original);
        i.putExtras(extras);
        context.startActivity(i);


    }

    public void Actualizar () {

         AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
         SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

         String productoString = null, dondeString = null, notasString = null, cantidadString = null;

        cursor = baseDeDatos.rawQuery(Util.QUERY_CATEGORY+"'"+categoriaSpinner+"'", null);
        cursor.moveToPosition(position);


         productoString = producto.getText().toString();
         dondeString = donde.getText().toString();
         notasString = notas.getText().toString();
         cantidadString = cantidad.getText().toString();

         if(sino.isChecked()) sw = Util.SI;
         else sw = Util.NO;

        ContentValues actualizar = new ContentValues();
        actualizar.put("producto", productoString);
        actualizar.put("donde", dondeString);
        actualizar.put("quien", notasString);
        actualizar.put("cantidad", cantidadString);
        actualizar.put("categoria", categoriaSpinner);
        actualizar.put("lotengo", sw);

        int num = baseDeDatos.update(Util.TABLA_BD, actualizar, "id= "+id, null);
        baseDeDatos.close();

        Context c = GetContextPasser.getContextPasser();
        if(c.equals(TengoActivity.getContext())) {
            TengoActivity.UpdateLista();
            CloseModify();
        }else if(c.equals(FaltaActivity.getContext())) {
            FaltaActivity.UpdateList();
            CloseModify();
        }else {

            switch (catOriginal) {
                case Util.BAÑO_MENU: {
                    BanioActivity.UpdateLista();
                    CloseModify();
                }
                break;
                case Util.ROPA_MENU: {
                    RopaActivity.UpdateLista();
                    CloseModify();
                }
                break;
                case Util.COMIDA_MENU: {
                    ComerActivity.UpdateLista();
                    CloseModify();
                }
                break;
                case Util.PASEO_MENU: {
                    PaseoActivity.UpdateLista();
                    CloseModify();
                }
                break;
                case Util.CASA_MENU: {
                    CasaActivity.UpdateLista();
                    CloseModify();
                }
                break;
            }
        }

    }

    private void CloseModify() {
        ((ModifyActivity)context).finish(); // habria que cerrar la actividad "modificarActivity"
        Toast.makeText(context, "Se ha modificado el registro", Toast.LENGTH_LONG).show();
    }


}
