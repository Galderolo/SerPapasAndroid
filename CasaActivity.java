package com.tempus.tempusoftware.serpapas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.database.EliminarBD;
import com.tempus.tempusoftware.serpapas.AddActivity;
import com.tempus.tempusoftware.serpapas.util.Adaptador;
import com.tempus.tempusoftware.serpapas.util.GetContextPasser;
import com.tempus.tempusoftware.serpapas.util.Util;

public class CasaActivity extends AppCompatActivity implements View.OnClickListener {

    static ListView lista;
    static Context context;
    private GetContextPasser cp;
    private static TextView vacioText, vacioIco, vacioBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa);

        setBarraAccion();

        context = this;
        lista = (ListView) findViewById(R.id.listaCasa);
        vacioText = findViewById(R.id.textVacioCasa);
        vacioIco = findViewById(R.id.icoVacioCasa);
        vacioBtn = findViewById(R.id.btnVacioCasa);
        setInvisibleText();
        UpdateLista();

        cp = new GetContextPasser(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.addmenu, menu);
        return true;
    }



    /**
     * Este metodo finaliza la actividad cuando pulsamos la flecha "back"
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.addMenu: {
                Intent i = new Intent(this, AddActivity.class);
                i.putExtra("Categoria", Util.CASA_MENU);
                startActivity(i);
            }
                break;
            case R.id.addMenu_eliminar: {
                EliminarBD delete = new EliminarBD(this, Util.CATEGORIA_CASA, true);
                delete.EliminarCampos();
            }

            break;
            default: finish();
        }
        return true;
    }

    /**
     * Este metodo actualiza el Listview
     */
    public static void UpdateLista() {
        if(context != null) {
            Adaptador ad = new Adaptador(context, Util.CATEGORIA_CASA);
            lista.setAdapter(ad);
        }

    }

    public void setBarraAccion () {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Para la Casa");
        getSupportActionBar().setSubtitle("Todo lo que ya tengo");
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


    @Override
    public void onClick(View v) {
        Intent i = new Intent (this, AddActivity.class);
        i.putExtra("Categoria", Util.CASA_MENU);
        startActivity(i);
    }
}
