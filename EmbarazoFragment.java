package com.tempus.tempusoftware.serpapas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Tempusoftware.rogue.listademibeb.R;


public class EmbarazoFragment extends Fragment implements View.OnClickListener {

    private ImageView deportes, comidas, piel, cosas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.embarazo_fragment, null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        deportes = getActivity().findViewById(R.id.embarazo_deporte);
        deportes.setOnClickListener(this);

        comidas = getActivity().findViewById(R.id.embarazo_comidas);
        comidas.setOnClickListener(this);

        piel = getActivity().findViewById(R.id.embarazo_piel);
        piel.setOnClickListener(this);

        cosas = getActivity().findViewById(R.id.embarazo_cosas);
        cosas.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.embarazo_deporte: EmbarazoDeporte();
                break;
            case R.id.embarazo_comidas: EmbarazoComidas();
                break;
            case R.id.embarazo_piel: EmbarazoPiel();
                break;
            case R.id.embarazo_cosas: EmbarazoCosas();
                break;
        }
    }

    private void EmbarazoCosas() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "cosas");
        i.putExtras(param);
        startActivity(i);
    }

    private void EmbarazoPiel() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "piel");
        i.putExtras(param);
        startActivity(i);
    }

    private void EmbarazoComidas() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "comidas");
        i.putExtras(param);
        startActivity(i);
    }

    private void EmbarazoDeporte() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "deporte");
        i.putExtras(param);
        startActivity(i);
    }
}
