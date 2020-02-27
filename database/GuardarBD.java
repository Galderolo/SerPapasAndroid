package com.tempus.tempusoftware.serpapas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.tempus.tempusoftware.serpapas.BanioActivity;
import com.tempus.tempusoftware.serpapas.CasaActivity;
import com.tempus.tempusoftware.serpapas.ComerActivity;
import com.tempus.tempusoftware.serpapas.PaseoActivity;
import com.tempus.tempusoftware.serpapas.RopaActivity;
import com.tempus.tempusoftware.serpapas.util.Util;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */
public class GuardarBD {

    private View v;
    private Context context;
    private EditText producto, donde, quien, cantidad;
    private Switch sino;
    private String spi;
    private Bundle categoria;

    public GuardarBD(View v, Context context, EditText producto, EditText donde, EditText quien, EditText cantidad, String spi, Switch sino, Bundle categoria) {

        this.v = v;
        this.context = context;
        this.producto = producto;
        this.donde = donde;
        this.quien = quien;
        this.cantidad = cantidad;
        this.spi = spi;
        this.sino = sino;
        this.categoria = categoria;

    }

    public void GuardarDatos() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String productoString = producto.getText().toString();
        String dondeString = donde.getText().toString();
        String quienString  = quien.getText().toString();
        String cantidadString = cantidad.getText().toString();


        String sw = null;
        //nos aseguramos si el switch ha sido pulsado
        if(sino.isChecked())  sw = Util.SI;
        else sw = Util.NO;



        if(!productoString.isEmpty() && !cantidadString.isEmpty()) {

            if(quienString.isEmpty()) quienString = Util.NOTA_SIN_NOTAS;
            if(dondeString.isEmpty()) dondeString = Util.NOTA_DONDE_COMPRE;

            ContentValues registrar = new ContentValues();
            registrar.put(Util.PRODUCTO, productoString);
            registrar.put(Util.DONDE, dondeString);
            registrar.put(Util.QUIEN, quienString);
            registrar.put(Util.CANTIDAD, cantidadString);
            registrar.put(Util.CATEGORIA, spi);//registrar.put(Util.CATEGORIA, spinnerString);
            registrar.put(Util.LOTENGO, sw);


            bd.insert(Util.TABLA_BD, null, registrar);
            bd.close();
            Clean();

            //if (contextoOriginal != null) spi = contextoOriginal;


            //en funcion de la categoria seleccionada actualizamos la lista
            //Aqui va a petar porque si recibe el spinner donde se guarda, pero se cambia y se actualiza la actividad desde la que no viene,
            //no coinciden los contexts y petan


                if(categoria != null) {
                    String cat = categoria.get("Categoria").toString();

                    switch (cat) {
                        case Util.BAÑO_MENU:
                            BanioActivity.UpdateLista();
                            break;

                        case Util.CASA_MENU:
                            CasaActivity.UpdateLista();
                            break;

                        case Util.ROPA_MENU:
                            RopaActivity.UpdateLista();
                            break;

                        case Util.PASEO_MENU:
                            PaseoActivity.UpdateLista();
                            break;

                        case Util.COMIDA_MENU:
                            ComerActivity.UpdateLista();
                            break;
                        default:
                    }
                }

            Toast.makeText(context, Util.MSG_REGISTRO_OK, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, Util.MSG_CAMPOS_KO, Toast.LENGTH_SHORT).show();
        }

    }

    private void Clean() {

        producto.setText("");
        donde.setText("");
        quien.setText("");
        cantidad.setText("");
        //sino.setChecked(false);
    }



}
