package com.tempus.tempusoftware.serpapas;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.util.TodasOpciones;
import com.tempus.tempusoftware.serpapas.util.Util;


public class MasFragment extends Fragment implements View.OnClickListener {


    TextView add, baño, paseo, ropa, comida, casa, quetiene, quefalta, cuentatras, opciones, legal;
    TodasOpciones ta;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mas_fragment, null);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        baño = getView().findViewById(R.id.banioMas);
        baño.setOnClickListener(this);

        paseo =  getView().findViewById(R.id.paseoMas);
        paseo.setOnClickListener(this);

        ropa = getView().findViewById(R.id.ropaMas);
        ropa.setOnClickListener(this);

        comida =  getView().findViewById(R.id.comidaMas);
        comida.setOnClickListener(this);

        casa =  getView().findViewById(R.id.casaMas);
        casa.setOnClickListener(this);

        quetiene =  getView().findViewById(R.id.quetieneMas);
        quetiene.setOnClickListener(this);

        quefalta =  getView().findViewById(R.id.quefaltaMas);
        quefalta.setOnClickListener(this);

        //cuentatras =  getView().findViewById(R.id.cuentatras);
        //cuentatras.setOnClickListener(this);

        opciones =  getView().findViewById(R.id.opcionesMas);
        opciones.setOnClickListener(this);

        legal =  getView().findViewById(R.id.legalMas);
        legal.setOnClickListener(this);

        add = getView().findViewById(R.id.addMas);
        add.setOnClickListener(this);

     }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addMas: {
                ta = new TodasOpciones(Util.ADD_MENU, getContext());
                ta.goToOption();
            }
            break;
            case R.id.paseoMas: {
                  ta = new TodasOpciones(Util.PASEO_MENU, getContext());
                  ta.goToOption();
            }
            break;
            case R.id.banioMas: {
                ta = new TodasOpciones(Util.BAÑO_MENU, getContext());
                ta.goToOption();
            }
            break;
            case R.id.ropaMas: {
                ta = new TodasOpciones(Util.ROPA_MENU, getContext());
                ta.goToOption();
            }
            break;
            case R.id.comidaMas: {
                ta = new TodasOpciones(Util.COMIDA_MENU, getContext());
                ta.goToOption();
            }
            break;
            case R.id.casaMas: {
                ta = new TodasOpciones(Util.CASA_MENU, getContext());
                ta.goToOption();
            }
            break;
            case R.id.quetieneMas: {
                ta = new TodasOpciones(Util.TIENE_MENU, getContext());
                ta.goToOption();
            }
            break;
            case R.id.quefaltaMas: {
                ta = new TodasOpciones(Util.FALTA_MENU, getContext());
                ta.goToOption();
            }
            break;
            /*case R.id.cuentatras: {
                ta = new TodasOpciones(Util.CUENTATRAS_MENU, getContext());
                ta.goToOption();
            }
            break;*/
            case R.id.opcionesMas: {
                ta = new TodasOpciones(Util.OPCIONES, getContext());
                ta.goToOption();
            }
            break;
            case R.id.legalMas: {
                ta = new TodasOpciones(Util.LEGAL, getContext());
                ta.goToOption();
            }
            break;


        }
    }


}
