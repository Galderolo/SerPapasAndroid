package com.tempus.tempusoftware.serpapas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.database.GuardarBD;
import com.tempus.tempusoftware.serpapas.util.CategoriaSpinner;
import com.tempus.tempusoftware.serpapas.util.SpinnerCategoriaAdapter;
import com.tempus.tempusoftware.serpapas.util.Util;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private EditText producto, donde, quien, cantidad;
    private Switch switch_sino;
    private TextView add;
    private ArrayList<CategoriaSpinner> categoriaArray;
    private SpinnerCategoriaAdapter adapter;
    private String spiString, contextoOriginal = null;
    private Bundle categoria = null;
    private FloatingActionButton fab_ver;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Añadir algo a mi Bebé");


        initList();
        //rellenamos spinner
        spinner = findViewById(R.id.spinner_tabla);
        adapter = new SpinnerCategoriaAdapter(this, categoriaArray);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CategoriaSpinner ca = (CategoriaSpinner) parent.getItemAtPosition(position);
                spiString = ca.getCategorias();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        setCategoriaSpinner();

        //asociamos al layout
        producto = (EditText) findViewById(R.id.txtProductoMod);
        donde = (EditText) findViewById(R.id.txtDondeMod);
        quien = (EditText) findViewById(R.id.txtQuienMod);
        cantidad = (EditText) findViewById(R.id.txtCantidadMod);
        switch_sino = (Switch) findViewById(R.id.switchSINOMod);
        add = (TextView) findViewById(R.id.btnAdd);
        fab_ver = findViewById(R.id.fab_ver);
        add.setOnClickListener(this);

            fab_ver.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), TengoActivity.class);
                    startActivity(i);
                }
            });
    }

    //Este metodo viene del menu de introducir, lo que hace es recibir de qué activity viene y en funciona a eso configura el spinner
    private void setCategoriaSpinner() {

        categoria = this.getIntent().getExtras();
        if(categoria != null) {
            switch (getIntent().getExtras().getString("Categoria")) {
                case Util.BAÑO_MENU: spinner.setSelection(0);
                    break;
                case Util.PASEO_MENU: spinner.setSelection(1);
                    break;
                case Util.ROPA_MENU: spinner.setSelection(2);
                    break;
                case Util.COMIDA_MENU: spinner.setSelection(3);
                    break;
                case Util.CASA_MENU: spinner.setSelection(4);
                    break;
            }
        }
    }

    private void initList() {
        categoriaArray = new ArrayList<>();
        categoriaArray.add(new CategoriaSpinner(Util.BAÑO_MENU, R.drawable.ic_baniolista));
        categoriaArray.add(new CategoriaSpinner(Util.PASEO_MENU, R.drawable.ic_paseolista));
        categoriaArray.add(new CategoriaSpinner(Util.ROPA_MENU, R.drawable.ic_ropalista));
        categoriaArray.add(new CategoriaSpinner(Util.COMIDA_MENU, R.drawable.ic_comerlista));
        categoriaArray.add(new CategoriaSpinner(Util.CASA_MENU, R.drawable.ic_casalista));
    }


    @Override
    public void onClick(View v) {

            GuardarBD gdb = new GuardarBD(v, getApplicationContext(), producto, donde, quien, cantidad, spiString, switch_sino, categoria);
            gdb.GuardarDatos();





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


}
