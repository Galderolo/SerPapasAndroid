package com.tempus.tempusoftware.serpapas;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tempus.tempusoftware.serpapas.CuidadosFragment;
import com.tempus.tempusoftware.serpapas.EmbarazoFragment;
import com.tempus.tempusoftware.serpapas.InicioFragment;
import com.tempus.tempusoftware.serpapas.MasFragment;
import com.tempus.tempusoftware.serpapas.NacimientoFragment;
import com.Tempusoftware.rogue.listademibeb.R;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static final int PERMISSIONS_CODE = 0;
    public String lastFragmentLoaded = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solicitarPermisos();
        cargaFragmento(new InicioFragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        getSupportActionBar().hide();



    }



    public boolean cargaFragmento(Fragment fr) {



        if(fr != null) {
            String currentFragment = fr.getClass().getName();

            if(lastFragmentLoaded == currentFragment) {
                //si los fragmentos son iguales no se cargan de nuevo
            }else {
                //animaciones y carga de los fragments
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out);
                ft.replace(R.id.frMain, fr);
                ft.commit();
                lastFragmentLoaded = currentFragment;
            }return true;
        }else return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem mi) {

        Fragment fr = null;
        int id = mi.getItemId();

        switch (id) {

            case R.id.navi_inicio:

                fr = new InicioFragment();
                break;
            case R.id.navi_embarazo:
                fr = new EmbarazoFragment();

                break;
            case R.id.navi_nacimiento:
                fr = new NacimientoFragment();

                break;
            case R.id.navi_cuidados:
                fr = new CuidadosFragment();

                break;
            case R.id.navi_mas:
                fr = new MasFragment();

                break;
        }

        return cargaFragmento(fr);
    }

    private void solicitarPermisos() {
        String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};

        if(ContextCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, permissions[1]) == PackageManager.PERMISSION_GRANTED)
        {




        }else{
            ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSIONS_CODE);

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //solicitarPermisos();

        switch(requestCode) {
            case PERMISSIONS_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                }else{

                }return;

        }


    }

    public String getLastFragmentLoaded () {
        return lastFragmentLoaded;
    }

    public void setLastFragmentLoaded (String f) {
        lastFragmentLoaded = f;
    }
}
