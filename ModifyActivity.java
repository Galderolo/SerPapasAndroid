package com.tempus.tempusoftware.serpapas;

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
import com.tempus.tempusoftware.serpapas.database.ModificarBD;
import com.tempus.tempusoftware.serpapas.util.CategoriaSpinner;
import com.tempus.tempusoftware.serpapas.util.SpinnerCategoriaAdapter;
import com.tempus.tempusoftware.serpapas.util.Util;

import java.util.ArrayList;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private EditText producto, donde, quien, cantidad;
    private Switch switch_sino;
    private ArrayList<CategoriaSpinner> categoriaArray;
    private SpinnerCategoriaAdapter adapter;
    private String spiString, catOriginal;
    private Bundle categoria, productoBundle = null;
    private Integer position;
    private Long id;
    private TextView modificar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Modificar");


        initList();
        producto = findViewById(R.id.txtProductoMod);
        donde = findViewById(R.id.txtDondeMod);
        quien = findViewById(R.id.txtQuienMod);
        cantidad = findViewById(R.id.txtCantidadMod);
        spinner = findViewById(R.id.spinner_tablaMod);
        switch_sino = findViewById(R.id.switchSINOMod);
        modificar = findViewById(R.id.btnModificar);
        modificar.setOnClickListener(this);


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

         //comprobamos si productoBundle viene de una modificacion y en ese caso cargamos los datos
        productoBundle = this.getIntent().getExtras();

       if(productoBundle != null) {
            if (productoBundle.getBoolean("modificar")) {
                setModificarProducto();
            }
        }

    }



    private void setModificarProducto() {

        //add.setText("Guardar");
        producto.setText(productoBundle.getString("producto"));
        donde.setText(productoBundle.getString("donde"));
        quien.setText(productoBundle.getString("notas"));
        cantidad.setText(productoBundle.getString("cantidad"));
        position = productoBundle.getInt("position");
        id = productoBundle.getLong("id");
        catOriginal = productoBundle.getString("categoria_original");
    }

    //de momento no lo vamos a usar
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

        if (productoBundle.getBoolean("modificar")) {
            ModificarBD mdb = new ModificarBD(this, producto, donde, quien, cantidad, spiString, switch_sino, position, id, catOriginal);
            mdb.Actualizar();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }


}
