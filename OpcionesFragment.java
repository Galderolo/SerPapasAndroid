package com.tempus.tempusoftware.serpapas;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v14.preference.PreferenceFragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.preference.Preference;
import android.widget.Toast;

import com.Tempusoftware.rogue.listademibeb.R;
import com.tempus.tempusoftware.serpapas.util.Util;
import com.tempus.tempusoftware.serpapas.OpcionesActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;


public class OpcionesFragment extends PreferenceFragment {

    private final static int CODE = 0;


    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        addPreferencesFromResource(R.xml.preferences);



    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {



        switch (preference.getKey())
        {
            case "pref_borrado":
                BorradoBD();
                break;

            case "pref_copia_seguridad":
                CopiaSD();
                break;

            case "pref_importar_sd":
                ImportarSD();
                break;
        }





        return super.onPreferenceTreeClick(preference);
    }

    private void ImportarSD() {

        final Context c = OpcionesActivity.getContextSettings();

        AlertDialog.Builder dialog = new AlertDialog.Builder(c);
        dialog.setTitle("Importar desde la tarjeta SD");
        dialog.setMessage("Al importar una base de datos desde la SD perderás todos los datos que hayas introducido, ¿estás segur@?");
        dialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
                File sd = new File(dir);
                File data = Environment.getDataDirectory();

                String backupDBPath = "/data/com.tempus.tempusoftware.serpapas/databases/listabebe";
                String currentDBPath = "listabebe";

                File currentDB = new File(sd, currentDBPath+"/listabebe");
                File backupDB = new File(data, backupDBPath);
                try {

                    File antBD =  new File("/data/data/com.tempus.tempusoftware.serpapas/databases/", "listabebe");
                    if(antBD.exists()) {
                        antBD.delete();
                    }

                    obtenerPermisos();
                    FileChannel source = new FileInputStream(currentDB).getChannel();
                    FileChannel destination = new FileOutputStream(backupDB).getChannel();
                    destination.transferFrom(source, 0, source.size());
                    source.close();
                    destination.close();
                    Toast.makeText(c, "Se han importado correctamente los datos", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();


    }

    private void CopiaSD() {

        final Context c = OpcionesActivity.getContextSettings();

        if(isSDMounted()) {


            //Creamos un dialogo para saber si quiere copiar y sobreescribir
            AlertDialog.Builder dialog = new AlertDialog.Builder(c);
            dialog.setTitle("Copia de seguridad");
            dialog.setMessage("La Copia de seguridad sobreescribirá otra que ya tenga guardada, ¿estás segur@?");
            dialog.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        File sd = Environment.getExternalStorageDirectory();
                        File data = Environment.getDataDirectory();

                        if (sd.canWrite() && sd.canRead()) {
                            String pathDataBase = "//data//com.tempus.tempusoftware.serpapas//databases//listabebe";
                            String databaseName = Util.BD;

                            File currentDatabase = new File(data, pathDataBase);
                            File backupDatabase = new File(sd, databaseName);

                            //requerimos permisos en tiempo de ejecucion
                            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {

                                //no entra porque no tenemos permisos de lectura y escritura!
                                if (currentDatabase.exists() && obtenerPermisos()) {

                                    if (backupDatabase.mkdirs()) {
                                        backupDatabase.delete();
                                        backupDatabase.mkdirs();
                                    }

                                    FileChannel src = new FileInputStream(currentDatabase).getChannel();
                                    FileChannel dst = new FileOutputStream(backupDatabase + "/listabebe").getChannel();
                                    dst.transferFrom(src, 0, src.size());
                                    src.close();
                                    dst.close();
                                    Toast.makeText(c, "La base de datos se ha guardado con éxito en la SD", Toast.LENGTH_LONG).show();
                                }
                            }
                        }


                    } catch (Exception e) {
                    }
                }
            });
            dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();

       } //llave del if de montada
       // else {
       //     Toast.makeText(c, "LA SD NO ESTA PRESENTE", Toast.LENGTH_LONG).show();
       //     obtenerPermisos();
       // }
    }
    private boolean obtenerPermisos() {
        String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};


       int permissionsCheckRead = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
       int permissionsCheckWrite = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

       if(permissionsCheckRead == PackageManager.PERMISSION_GRANTED && permissionsCheckWrite == PackageManager.PERMISSION_GRANTED) {
           ActivityCompat.requestPermissions(getActivity(), permissions, MainActivity.PERMISSIONS_CODE);
           return true;
       }else{
           return false;
       }


    }



    private void BorradoBD() {

        final Context c = OpcionesActivity.getContextSettings();

            AlertDialog.Builder dialog = new AlertDialog.Builder(c);
            dialog.setTitle(Util.MSG_BORRAR_BASEDEDATOS);
            dialog.setMessage(Util.MSG_ADVERTENCIA_BORRADO);


            dialog.setPositiveButton(Util.MSG_SI, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    c.deleteDatabase(Util.BD);
                    Toast.makeText(c, Util.MSG_BASEDEDATOS_BORRADA, Toast.LENGTH_LONG).show();
                }
            });

            dialog.setNegativeButton(Util.MSG_NO, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //quit
                }
            });
            dialog.show();

    }
    //algunos dispositivos samsung escriben en la propia sdcard(dentro de la memoria del telefono)
    private boolean isSDMounted () {
        File sd = new File ("/sdcard");
        if(sd.exists()) {
            return true;
        }
        else return false;
    }
}
