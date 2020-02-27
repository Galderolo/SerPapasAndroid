package com.tempus.tempusoftware.serpapas.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tempus.tempusoftware.serpapas.AddActivity;
import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.util.Util;

/**
 * Creado por Galder on 2019
 * Impulse
 * dcerveralp@gmail.com
 * Todos los derechos reservados
 */
public class FragmentTodoBebe2 extends Fragment implements View.OnClickListener{

    private final static String TAG = "Paseo";
    private FloatingActionButton fab_paseo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_embarazo_todobebe_tab2, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fab_paseo = getActivity().findViewById(R.id.fab_paseo);

        fab_paseo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //hay que enviar el contexto para que actualice la lista
                //o enviar un extra y decir que no actualice

                Intent i = new Intent(getActivity(), AddActivity.class);
                i.putExtra("Categoria", Util.PASEO_MENU);
                startActivity(i);
            }
        });
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

    }
}
