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

public class CuidadosFragment extends Fragment implements View.OnClickListener {

    private ImageView bebe, madre, calle, yahora;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cuidados_fragment, null);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bebe = getActivity().findViewById(R.id.cuidados_bebe);
        bebe.setOnClickListener(this);

        madre = getActivity().findViewById(R.id.cuidados_madre);
        madre.setOnClickListener(this);

        calle = getActivity().findViewById(R.id.cuidados_calle);
        calle.setOnClickListener(this);

        yahora = getActivity().findViewById(R.id.cuidados_yahora);
        yahora.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cuidados_bebe: CuidadosdelBebe();
                break;
            case R.id.cuidados_madre: CuidadosMadre();
                break;
            case R.id.cuidados_calle: CuidadosCalle();
                break;
            case R.id.cuidados_yahora: CuidadosYahora();
                break;
        }

    }

    private void CuidadosYahora() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "yahora");
        i.putExtras(param);
        startActivity(i);
    }

    private void CuidadosCalle() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "calle");
        i.putExtras(param);
        startActivity(i);
    }

    private void CuidadosMadre() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "madre");
        i.putExtras(param);
        startActivity(i);
    }

    private void CuidadosdelBebe() {
        Intent i = new Intent(getActivity(), TabbedActivity.class);
        Bundle param = new Bundle();
        param.putString("option", "cuidadosdelbebe");
        i.putExtras(param);
        startActivity(i);
    }
}
