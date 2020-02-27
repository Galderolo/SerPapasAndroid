package com.tempus.tempusoftware.serpapas.database;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tempus.tempusoftware.serpapas.BanioActivity;
import com.tempus.tempusoftware.serpapas.CasaActivity;
import com.tempus.tempusoftware.serpapas.ComerActivity;
import com.tempus.tempusoftware.serpapas.PaseoActivity;
import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.RopaActivity;
import com.tempus.tempusoftware.serpapas.util.Util;

/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */

public class BuscarBD {

    private Context context;
    private TextView producto, donde, quien, cantidad, lotengo;
    private Integer i;
    private ImageView icon;
    String categoria;
    Cursor fila;
    private String producto_final;
    private static String lotengo_final = null;



    public BuscarBD(Context context, TextView producto, TextView donde, TextView quien, TextView cantidad, TextView lotengo, Integer i, String categoria, ImageView icon) {
        this.context = context;
        this.producto = producto;
        this.donde = donde;
        this.quien = quien;
        this.cantidad = cantidad;
        this.lotengo = lotengo;
        this.i = i;
        this.categoria = categoria;
        this.icon = icon;

    }

    //Sobrecargamos el constructor
    public BuscarBD(Context context) {
        this.context = context;
    }

    public String getProducto () {
        return producto_final;

    }

    /**
     * Vamos a comparar si lo que recibe es de X categoria (baño, paseo...) y busca en funcion a la categoria.
     */
    public void BuscarDatos() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
        SQLiteDatabase base = admin.getReadableDatabase();

        switch (categoria) {
            case Util.CATEGORIA_BAÑO: {
                EjecutarConsulta(Util.CATEGORIA_BAÑO, base);
                icon.setImageResource(R.drawable.ic_baniolista);
                }
                break;
            case Util.CATEGORIA_CASA: {
                EjecutarConsulta(Util.CATEGORIA_CASA, base);
                icon.setImageResource(R.drawable.ic_casalista);
                }
                break;
            case Util.CATEGORIA_COMIDA: {
                EjecutarConsulta(Util.CATEGORIA_COMIDA, base);
                icon.setImageResource(R.drawable.ic_comerlista);
                }
                break;
            case Util.CATEGORIA_PASEO: {
                EjecutarConsulta(Util.CATEGORIA_PASEO, base);
                icon.setImageResource(R.drawable.ic_paseolista);
                }
                break;
            case Util.CATEGORIA_ROPA: {
                EjecutarConsulta(Util.CATEGORIA_ROPA, base);
                icon.setImageResource(R.drawable.ic_ropalista);
                }
                break;
            case Util.QUERY_FALTA:
                EjecutarConsultaFalta(Util.QUERY_FALTA, base);
                break;
            case Util.QUERY_TENGO:
                EjecutarConsultaTengo(Util.QUERY_TENGO, base);
                break;
        }

    }
    //Esta consulta busca lo que tiene
    private void EjecutarConsultaTengo(String queryTengo, SQLiteDatabase base) {
        fila = base.rawQuery(Util.QUERY_TENGO, null);

        if (fila.moveToPosition(i)) {

            producto_final = fila.getString(1);
            producto.setText(producto_final);

            donde.setText(fila.getString(2));
            quien.setText(fila.getString(3));
            cantidad.setText(fila.getString(4));

            lotengo_final = fila.getString(6);
            lotengo.setText(lotengo_final);

            String cat = fila.getString(5);

            //getLotengo();


            switch (cat) {
                case "Casa": icon.setImageResource(R.drawable.ic_casalista);
                    break;
                case "Baño": icon.setImageResource(R.drawable.ic_baniolista);
                    break;
                case "Ropa": icon.setImageResource(R.drawable.ic_ropalista);
                    break;
                case "Comida": icon.setImageResource(R.drawable.ic_comerlista);
                    break;
                case "Paseo": icon.setImageResource(R.drawable.ic_paseolista);
                    break;
            }

            base.close();

        } else {
            Toast.makeText(context, "No se encuentra el producto", Toast.LENGTH_LONG).show();
            base.close(); //si se queda abierta arriba la BD hay que cerrarla tb
        }

    }

    //Esta consulta busca solo lo que falta
    private void EjecutarConsultaFalta(String queryFalta, SQLiteDatabase base) {
        fila = base.rawQuery(Util.QUERY_FALTA, null);
        if (fila.moveToPosition(i)) {

            producto_final = fila.getString(1);
            producto.setText(producto_final);

            donde.setText(fila.getString(2));
            quien.setText(fila.getString(3));
            cantidad.setText(fila.getString(4));
            lotengo.setText(fila.getString(6));
            String cat = fila.getString(5);

            switch (cat) {
                case "Casa": icon.setImageResource(R.drawable.ic_casalista);
                    break;
                case "Baño": icon.setImageResource(R.drawable.ic_baniolista);
                    break;
                case "Ropa": icon.setImageResource(R.drawable.ic_ropalista);
                    break;
                case "Comida": icon.setImageResource(R.drawable.ic_comerlista);
                    break;
                case "Paseo": icon.setImageResource(R.drawable.ic_paseolista);
                    break;
            }

            base.close();

        } else {
            Toast.makeText(context, "No se encuentra el producto", Toast.LENGTH_LONG).show();
            base.close(); //si se queda abierta arriba la BD hay que cerrarla tb
        }


    }

    //Esta consulta busca en funcion de la categoria
    private void EjecutarConsulta(String categoria, SQLiteDatabase base) {


        fila = base.rawQuery(Util.QUERY_ON_DEPENDS + categoria, null);
        if (fila.moveToPosition(i)) {

            producto_final = fila.getString(1);
            producto.setText(producto_final);
            donde.setText(fila.getString(2));
            quien.setText(fila.getString(3));
            cantidad.setText(fila.getString(4));
            lotengo.setText(fila.getString(6));


            base.close();

        } else {
            Toast.makeText(context, "No se encuentra el producto", Toast.LENGTH_LONG).show();
            base.close(); //si se queda abierta arriba la BD hay que cerrarla tb
        }

    }


    //metodo que devuelve la cantidad de registros de la BD
    public int getCount(String categoria) {

        if (!categoria.equals(Util.QUERY_FALTA) && !categoria.equals(Util.QUERY_TENGO)) {

            int c;
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
            SQLiteDatabase bd = admin.getReadableDatabase();
            String countQuery = Util.QUERY_ON_DEPENDS + categoria;

            Cursor cursor = bd.rawQuery(countQuery, null);
            c = cursor.getCount();
            bd.close();

            //Mientras en el contador o la categoria no tenga nada y segun la categoria

                switch (categoria) {
                    case Util.CATEGORIA_BAÑO: {
                        if (c <= 0) BanioActivity.setVisibleText();
                        else BanioActivity.setInvisibleText();
                    }
                        break;

                    case Util.CATEGORIA_CASA: {
                        if (c <= 0) CasaActivity.setVisibleText();
                        else CasaActivity.setInvisibleText();
                    }
                        break;

                    case Util.CATEGORIA_COMIDA: {
                        if (c <= 0) ComerActivity.setVisibleText();
                        else ComerActivity.setInvisibleText();
                    }
                        break;

                    case Util.CATEGORIA_PASEO: {
                        if (c <= 0) PaseoActivity.setVisibleText();
                        else PaseoActivity.setInvisibleText();
                    }
                        break;

                    case Util.CATEGORIA_ROPA: {
                        if (c <= 0) RopaActivity.setVisibleText();
                        else RopaActivity.setInvisibleText();
                    }
                        break;
                }


            return c;


        }
        else if (categoria.equals(Util.QUERY_FALTA)) {
            int c;
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
            SQLiteDatabase bd = admin.getReadableDatabase();
            String countQuery = Util.QUERY_FALTA;

            Cursor cursor = bd.rawQuery(countQuery, null);
            c = cursor.getCount();
            bd.close();

            return c;

        }
        else if(categoria.equals(Util.QUERY_TENGO)) {

            int c;
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, Util.BD, null, 1);
            SQLiteDatabase bd = admin.getReadableDatabase();
            String countQuery = Util.QUERY_TENGO;

            Cursor cursor = bd.rawQuery(countQuery, null);
            c = cursor.getCount();
            bd.close();



            return c;
        }
        else return 0;

    }

    /*
    public String getLotengo () {
        return lotengo_final;
    }
    */

}
