package com.tempus.tempusoftware.serpapas;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.content.FragmentAntesDelParto;
import com.tempus.tempusoftware.serpapas.content.FragmentComidas1;
import com.tempus.tempusoftware.serpapas.content.FragmentComidas2;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosComida;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosDescanso;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosEnLaCalle;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosHigiene;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosMadreCesarea;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosMadrePartoNatural;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosPrimerosDias;
import com.tempus.tempusoftware.serpapas.content.FragmentCuidadosYaEresMadre;
import com.tempus.tempusoftware.serpapas.content.FragmentDeporte1;
import com.tempus.tempusoftware.serpapas.content.FragmentDeporte2;
import com.tempus.tempusoftware.serpapas.content.FragmentDeporte3;
import com.tempus.tempusoftware.serpapas.content.FragmentDocumentacion;
import com.tempus.tempusoftware.serpapas.content.FragmentNacimientoCosasParaTi1;
import com.tempus.tempusoftware.serpapas.content.FragmentNacimientoCosasParaTi2;
import com.tempus.tempusoftware.serpapas.content.FragmentNacimientoRecomendaciones;
import com.tempus.tempusoftware.serpapas.content.FragmentPiel1;
import com.tempus.tempusoftware.serpapas.content.FragmentPiel2;
import com.tempus.tempusoftware.serpapas.content.FragmentTodoBebe1;
import com.tempus.tempusoftware.serpapas.content.FragmentTodoBebe2;
import com.tempus.tempusoftware.serpapas.content.FragmentTodoBebe3;
import com.tempus.tempusoftware.serpapas.content.FragmentTodoBebe4;
import com.tempus.tempusoftware.serpapas.content.FragmentTodoBebe5;
import com.tempus.tempusoftware.serpapas.content.FragmentTrasElParto;
import com.tempus.tempusoftware.serpapas.util.SectionsPageAdapter;


public class TabbedActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        setToolbar();

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);




    }

    private void setToolbar() {

        Toolbar tabbedToolbar = findViewById(R.id.tabbed_toolbar);
        setSupportActionBar(tabbedToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void setupViewPager (ViewPager viewPager) {


        //Segun desde que actividad o que hayamos pulsado el tabbed activity rellena un fragment concreto
        Bundle param = this.getIntent().getExtras();
        if(param != null) {
            String option = param.getString("option");
            //switch (string) hacemos que carge un fragment u otro y le ponemos un name a la  ventana

            switch(option) {
                case "deporte": setDeporte(viewPager);
                    break;
                case "comidas": setComidas(viewPager);
                    break;
                case "piel": setPiel(viewPager);
                    break;
                case "cosas": setCosas(viewPager);
                    break;
                case "cosasparatiytubebe": setCosasParaTiyTuBebe(viewPager);
                    break;
                case "hospital": setHospital(viewPager);
                    break;
                case "documentacion": setDocumentacion(viewPager);
                    break;
                case "recomendaciones": setRecomendaciones(viewPager);
                    break;
                case "yahora": setYahora(viewPager);
                    break;
                case "calle": setCalle(viewPager);
                    break;
                case "madre": setMadre(viewPager);
                    break;
                case "cuidadosdelbebe": setCuidadosDelBebe(viewPager);
                    break;

            }

        }


    }

    /**
     * CUIDADOS *****************************************************************************
     */
    private void setYahora(ViewPager viewPager) {
        getSupportActionBar().setTitle("¿Y ahora qué?");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentCuidadosYaEresMadre(), "Ya eres madre y ahora qué");
        viewPager.setAdapter(adapter);
    }

    private void setCalle(ViewPager viewPager) {
        getSupportActionBar().setTitle("Cuidados en la calle");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentCuidadosEnLaCalle(), "En la calle con tu bebé");
        viewPager.setAdapter(adapter);
    }

    private void setMadre(ViewPager viewPager) {
        getSupportActionBar().setTitle("Cuidados de la Madre");

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentCuidadosMadrePartoNatural(), "Parto Natural"); //hay que crear los fragments correspondientes y sus layouts
        adapter.addFragment(new FragmentCuidadosMadreCesarea(), "Cesarea");
        //adapter.addFragment(new FragmentCuidadosMadreOtros(), "Otros");


        viewPager.setAdapter(adapter);

    }

    //Cuidados del bebe
    private void setCuidadosDelBebe(ViewPager viewPager) {
        getSupportActionBar().setTitle("Cuidados del Bebé");

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentCuidadosPrimerosDias(), "Primeros días"); //hay que crear los fragments correspondientes y sus layouts
        adapter.addFragment(new FragmentCuidadosHigiene(), "Higiene");
        adapter.addFragment(new FragmentCuidadosComida(), "Comida");
        adapter.addFragment(new FragmentCuidadosDescanso(), "Descanso");

        viewPager.setAdapter(adapter);
    }



    /**
     * NACIMIENTO **********************************************************************************
     */

    //Nacimiento/Recomendaciones
    private void setRecomendaciones(ViewPager viewPager) {
        getSupportActionBar().setTitle("Recomendaciones");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentNacimientoRecomendaciones(), "Recomendaciones para los padres" );

        viewPager.setAdapter(adapter);
    }

    //Nacimiento/Documentacion
    private void setDocumentacion(ViewPager viewPager) {
         getSupportActionBar().setTitle("Documentacion necesaria");

         SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
         adapter.addFragment(new FragmentDocumentacion(), "Documentación que te hará falta");
        viewPager.setAdapter(adapter);
    }

    //Nacimiento/Hospital
    private void setHospital(ViewPager viewPager) {
        getSupportActionBar().setTitle("En el Hospital");

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentAntesDelParto(), "Antes del parto"); //hay que crear los fragments correspondientes y sus layouts
        adapter.addFragment(new FragmentTrasElParto(), "Tras el parto");

        viewPager.setAdapter(adapter);

    }

    //Nacimiento/cosas para ti y tu bebe
    private void setCosasParaTiyTuBebe(ViewPager viewPager) {
        getSupportActionBar().setTitle("Cosas para tí y tu bebé");

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentNacimientoCosasParaTi1(), "Para tí"); //hay que crear los fragments correspondientes y sus layouts
        adapter.addFragment(new FragmentNacimientoCosasParaTi2(), "Para tu Bebé");

        viewPager.setAdapter(adapter);

    }

    /**
     * EMBARAZO *************************************************************************************
     */
    //Embarazo/cosas para tu bebe
    private void setCosas(ViewPager viewPager) {
        getSupportActionBar().setTitle("Todo para tu bebé");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentTodoBebe1(), "Baño");
        adapter.addFragment(new FragmentTodoBebe2(), "Paseo");
        adapter.addFragment(new FragmentTodoBebe3(), "Ropa");
        adapter.addFragment(new FragmentTodoBebe4(), "Comida");
        adapter.addFragment(new FragmentTodoBebe5(), "Casa");

        viewPager.setAdapter(adapter);
    }

    //Embarazo/PIEL
    private void setPiel(ViewPager viewPager) {
        getSupportActionBar().setTitle("Cuidado de tu piel");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentPiel1(), "Cremas recomendadas");
        adapter.addFragment(new FragmentPiel2(), "Otras recomendaciones");


        viewPager.setAdapter(adapter);
    }

    //Embarazo/Comidas
    private void setComidas(ViewPager viewPager) {
        getSupportActionBar().setTitle("Comidas");
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentComidas1(), "Comidas recomendadas");
        adapter.addFragment(new FragmentComidas2(), "Comidas no recomendadas");

        viewPager.setAdapter(adapter);
    }

    //Embarazo/Deporte
    private void setDeporte(ViewPager viewPager) {
        //titulo del view
        getSupportActionBar().setTitle("Deporte");

        //adaptador de las tabs
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        //al adaptador hay que pasarle los fragments como pestañas haya
        adapter.addFragment(new FragmentDeporte1(), "0-3 meses");
        adapter.addFragment(new FragmentDeporte2(), "3-6 meses");
        adapter.addFragment(new FragmentDeporte3(), "6-9 meses");

        viewPager.setAdapter(adapter);
    }

}