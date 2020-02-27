package com.tempus.tempusoftware.serpapas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.util.Adaptador;
import com.tempus.tempusoftware.serpapas.util.GetContextPasser;
import com.tempus.tempusoftware.serpapas.util.Util;

public class TengoActivity extends AppCompatActivity implements View.OnClickListener {

    static ListView lista;
    static Context context;
    private GetContextPasser cp;
    public int contador = 0;
    public static TextView vacioText, vacioIco, vacioBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tengo);

        setBarraAccion();
        context = this;
        lista = (ListView)findViewById(R.id.listaTengo);
        vacioBtn = findViewById(R.id.btnVacioTengo);
        vacioIco = findViewById(R.id.icoVacioTengo);
        vacioText = findViewById(R.id.textVacioTengo);
        UpdateLista();
        cp = new GetContextPasser(this);

        if(getCont() <= 0) setVisibleText();
        else setInvisibleText();




    }

    private int getCont() {
        Adaptador adCont = new Adaptador(context, Util.QUERY_TENGO);
        int cont = adCont.getCount();
        return cont;
    }

    public static void setVisibleText () {
        vacioText.setVisibility(View.VISIBLE);
        vacioIco.setVisibility(View.VISIBLE);
        vacioBtn.setVisibility(View.VISIBLE);
    }

    public static void setInvisibleText() {
        vacioText.setVisibility(View.INVISIBLE);
        vacioIco.setVisibility(View.INVISIBLE);
        vacioBtn.setVisibility(View.INVISIBLE);
    }


    /**
     * Este metodo finaliza la actividad cuando pulsamos la flecha "back"
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        this.finish();
        return true;
    }

    public void setBarraAccion() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ya lo tengo");
        getSupportActionBar().setSubtitle("Todo lo que tiene mi Bebé");
    }
    public static void UpdateLista() {
        Adaptador ad = new Adaptador(context, Util.QUERY_TENGO);
        lista.setAdapter(ad);
    }

    public static Context getContext () {
        return context;
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Intent i = new Intent (this, AddActivity.class);
        startActivity(i);
    }
}
