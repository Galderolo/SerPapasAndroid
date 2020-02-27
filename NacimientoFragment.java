package com.tempus.tempusoftware.serpapas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Tempusoftware.rogue.listademibeb.R;

public class NacimientoFragment extends Fragment implements View.OnClickListener {

    private ImageView paratiytubebe, documentacion, hospital, recomendaciones;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nacimiento_fragment, null);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        paratiytubebe = getActivity().findViewById(R.id.nacimiento_cosas);
        paratiytubebe.setOnClickListener(this);

        documentacion = getActivity().findViewById(R.id.nacimiento_documentacion);
        documentacion.setOnClickListener(this);

        hospital = getActivity().findViewById(R.id.nacimiento_hospital);
        hospital.setOnClickListener(this);

        recomendaciones = getActivity().findViewById(R.id.nacimiento_recomendaciones);
        recomendaciones.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.nacimiento_cosas: NacimientoCosas();
                break;
            case R.id.nacimiento_documentacion: NacimientoDocumentacion();
                break;
            case R.id.nacimiento_hospital: NacimientoHospital();
                break;
            case R.id.nacimiento_recomendaciones: NacimientoRecomendaciones();
                break;

        }

    }

    //Todas las strings estaría bien incluirlas en UTIL
    private void NacimientoRecomendaciones() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "recomendaciones");
        i.putExtras(param);
        startActivity(i);

    }

    private void NacimientoHospital() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "hospital");
        i.putExtras(param);
        startActivity(i);
    }

    private void NacimientoDocumentacion() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "documentacion");
        i.putExtras(param);
        startActivity(i);
    }

    private void NacimientoCosas() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "cosasparatiytubebe");
        i.putExtras(param);
        startActivity(i);
    }
}
