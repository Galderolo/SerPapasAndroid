package com.tempus.tempusoftware.serpapas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Tempusoftware.rogue.listademibeb.R;


public class InicioFragment extends Fragment implements View.OnClickListener {

    private ImageView coverImage1, coverImage2, coverImage3;
    private BottomNavigationView nav;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.inicio_fragment, null);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        coverImage1 = getActivity().findViewById(R.id.cover_image); //Embarazo
        coverImage2 = getActivity().findViewById(R.id.cover_image2); //Nacimiento
        coverImage3 = getActivity().findViewById(R.id.cover_image3); //Cuidados
        nav = getActivity().findViewById(R.id.navigation);

        GoToOptions();


    }

    //este metodo abre las opciones de INICIO(Embarazo, nacimiento, cuidados)
    //y aplica las animaciones
    private void GoToOptions() {


        coverImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment embarazo = new EmbarazoFragment();

                //si estoy cargando un fragment que ya esta cargado no se hace nada
                String currentFragment = embarazo.getClass().getName();
                String lastFragmentLoaded = ((MainActivity)getActivity()).getLastFragmentLoaded();

                //si estoy cargando un fragment que ya esta cargado no se hace nada
                //si es diferente entonces lo cargamos
                if(currentFragment != lastFragmentLoaded) {
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
                    ft.replace(R.id.frMain, embarazo);
                    ft.commit();
                    nav.getMenu().getItem(1).setChecked(true);

                    ((MainActivity)getActivity()).setLastFragmentLoaded(currentFragment);
                }
                //lo que esta pasando es que si cargo desde aqui no tengo en cuenta las variables de
                // la MainActivity y peta

            }
        });

        coverImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment nacimiento = new NacimientoFragment();
                String currentFragment = nacimiento.getClass().getName();
                String lastFragmentLoaded = ((MainActivity)getActivity()).getLastFragmentLoaded();

                if(currentFragment != lastFragmentLoaded) {
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
                    ft.replace(R.id.frMain, nacimiento);
                    ft.commit();
                    nav.getMenu().getItem(2).setChecked(true);
                    ((MainActivity)getActivity()).setLastFragmentLoaded(currentFragment);
                }
            }
        });

        coverImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment cuidados = new CuidadosFragment();

                String currentFragment = cuidados.getClass().getName();
                String lastFragmentLoaded = ((MainActivity)getActivity()).getLastFragmentLoaded();

                if(lastFragmentLoaded != currentFragment) {
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = manager.beginTransaction();
                    ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
                    ft.replace(R.id.frMain, cuidados);
                    ft.commit();
                    nav.getMenu().getItem(3).setChecked(true);
                    ((MainActivity)getActivity()).setLastFragmentLoaded(currentFragment);
                }

            }

        });
    }

    @Override
    public void onClick(View v) {

    }
}
