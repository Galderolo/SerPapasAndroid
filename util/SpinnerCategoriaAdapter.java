package com.tempus.tempusoftware.serpapas.util;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Tempusoftware.rogue.listademibeb.R;
/**
 * Creado por Galder on 2019
 * TempusSoftwares
 * sexoductor@gmail.com
 * Todos los derechos reservados
 */

import java.util.ArrayList;

public class SpinnerCategoriaAdapter extends ArrayAdapter<CategoriaSpinner> {

    public SpinnerCategoriaAdapter (Context context, ArrayList<CategoriaSpinner> categoriaSpinner) {
        super(context, 0, categoriaSpinner);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView (int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_layout, parent, false);
        }

        ImageView imageViewIcons = convertView.findViewById(R.id.icon_spinner);
        TextView textoSpinner = convertView.findViewById(R.id.text_spinner);

        CategoriaSpinner cs = getItem(position);

        if(cs != null) {
            imageViewIcons.setImageResource(cs.getIconos());
            textoSpinner.setText(cs.getCategorias());
        }

        return convertView;
    }
}
