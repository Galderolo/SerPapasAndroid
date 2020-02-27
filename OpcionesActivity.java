package com.tempus.tempusoftware.serpapas;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.tempus.tempusoftware.serpapas.OpcionesFragment;
import com.Tempusoftware.rogue.listademibeb.R;


public class OpcionesActivity extends AppCompatActivity  {

    private static Context settingsContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        settingsContext = this;
        setBarraAccion();

        if(findViewById(R.id.fragment_opciones_container) != null)
        {
            if(savedInstanceState != null) return;

            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_opciones_container, new OpcionesFragment())
                    .commit();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void setBarraAccion () {
        getSupportActionBar().setTitle("Opciones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static Context getContextSettings() {
        return settingsContext;
    }



}
