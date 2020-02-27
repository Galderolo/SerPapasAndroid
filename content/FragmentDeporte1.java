package com.tempus.tempusoftware.serpapas.content;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Tempusoftware.rogue.listademibeb.R;

/**
 * Creado por Galder on 2019
 * Impulse
 * dcerveralp@gmail.com
 * Todos los derechos reservados
 */
public class FragmentDeporte1 extends Fragment {

    private static final String TAG = "Deporte1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //inflamos el fragment con el view del layout
        View v = inflater.inflate(R.layout.fragment_embarazo_deporte_tab1, container, false);

        //all action here





        return v;
    }
}
