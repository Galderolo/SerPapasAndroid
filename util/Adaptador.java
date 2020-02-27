package com.tempus.tempusoftware.serpapas.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.database.BuscarBD;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context context;
    String categoria;



    public Adaptador(Context context, String categoria) {

        this.categoria = categoria;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.item_category, null); //asignamos la lista a un View

        TextView pro =  vista.findViewById(R.id.resProducto);
        TextView don =  vista.findViewById(R.id.resDonde);
        TextView qui =  vista.findViewById(R.id.resQuien);
        TextView can =  vista.findViewById(R.id.resCantidad);
        TextView lot =  vista.findViewById(R.id.resLotengo);
        ImageView threedots = vista.findViewById(R.id.btnPopup);
        ImageView icon = vista.findViewById(R.id.listaIcon);

        //metemos en una string el producto para pasarselo al POpUPmenu y enseñar lo que vamos a borra o editar
        final String producto = pro.getText().toString();


        //Para buscar en la base de datos le hacen falta los componentes y la categoria de lo que vamos a buscar
        final BuscarBD search = new BuscarBD(context, pro, don, qui, can, lot, position, categoria, icon);
        search.BuscarDatos();



        //tenemos que hacer un Onlistener en el popupmenu de los 3 puntitos
        threedots.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  //Toast.makeText(context, "Seleccionado el item "+getItemId(position), Toast.LENGTH_LONG).show();
                  PopUpMenu pu = new PopUpMenu(context, v, position, categoria, search.getProducto());
                  pu.showPopUp();
              }
        });

        return  vista;
    }

    @Override
    public int getCount() {

        int count;
        //si se crea un objeto nuevo no puede usarse el contexto de un objeto anterior ya creado, por lo que hay que mandar el contexto
        BuscarBD search = new BuscarBD(context);
        count = search.getCount(categoria); //le mandamos categoria al contador de registros para que sepa cuantos hay de esa categoria


        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }





}
