package com.example.covid_ec;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Hashtable;

public class RegisterActivity extends AppCompatActivity {
    Hashtable<Integer, String> estado = new Hashtable<Integer,String>();
    Hashtable<Integer, Integer> estadoToDB = new Hashtable<Integer, Integer>();

    Usuario user;
    SeekBar intensidad,dificultadrespirar,dolor;
    TextView tvintensidad,tvdificultad,tvdolor;
    String infos;
    TextView nombreTV;
    TextView tptemperatura,tpritmocardiaco;
    CheckBox cbtos,cbdificultadRespirar,cbdolorGarganta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = (Usuario) getIntent().getSerializableExtra("user");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(user.getUsername());


        intensidad = (SeekBar) findViewById(R.id.intensidadtosid);
        dificultadrespirar = (SeekBar) findViewById(R.id.dificultadid);
        dolor = (SeekBar) findViewById(R.id.dolorid);

        tvintensidad = (TextView) findViewById(R.id.TVtosid);
        tvdificultad = (TextView) findViewById(R.id.TVdificultadid);
        tvdolor = (TextView) findViewById(R.id.TVdolorid);

        estado.put(0,"Peor que ayer");
        estado.put(1,"Igual que ayer");
        estado.put(2,"Mejor que ayer");

        estadoToDB.put(0,-1);
        estadoToDB.put(1,0);
        estadoToDB.put(2,10);


        tptemperatura = (TextView) findViewById(R.id.temperaturaid);
        tpritmocardiaco = (TextView) findViewById(R.id.ritmoid);

        cbtos = (CheckBox) findViewById(R.id.toscheckid);
        cbdificultadRespirar = (CheckBox) findViewById(R.id.dificultadcheckid);
        cbdolorGarganta = (CheckBox) findViewById(R.id.dolorcheckid);

        tvintensidad.setText(estado.get(intensidad.getProgress()));
        tvdificultad.setText(estado.get(dificultadrespirar.getProgress()));
        tvdolor.setText(estado.get(dolor.getProgress()));




        intensidad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvintensidad.setText(estado.get(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        dificultadrespirar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvdificultad.setText(estado.get(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        dolor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvdolor.setText(estado.get(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



}

    public void enviar(View v){
        if (envioDataBase()){
            Intent i = new Intent(this, MainHomeActivity.class );
            i.putExtra("user", user);
            Toast toast2 = Toast.makeText(getApplicationContext(),"Conexión Exitosa",Toast.LENGTH_SHORT);
            toast2.show();
            startActivity(i);

        }
        else{
            Toast toast1 = Toast.makeText(getApplicationContext(),"Conexión Fallida",Toast.LENGTH_LONG);
            toast1.show();
        }


    }

    public boolean envioDataBase(){
        float temp = Float.parseFloat(tptemperatura.getText().toString());
        int ritmocardiaco = Integer.parseInt(tpritmocardiaco.getText().toString());
        boolean tos;
        int estadoTos;
        boolean dolorGarganta;
        int estadoDolorGarganta;
        boolean dificultadRespirar;
        int estadoDificultadRespirar;


        if (cbtos.isChecked()){
            tos=true;
            estadoTos = intensidad.getProgress()-1;
        }
        else{
            tos=false;
            estadoTos=0;
        }

        if (cbdolorGarganta.isChecked()){
            dolorGarganta=true;
            estadoDolorGarganta = dolor.getProgress()-1;
        }
        else{
            dolorGarganta=false;
            estadoDolorGarganta=0;
        }
        if (cbdificultadRespirar.isChecked()){
            dificultadRespirar=true;
            estadoDificultadRespirar = dificultadrespirar.getProgress()-1;
        }
        else{
            dificultadRespirar=false;
            estadoDificultadRespirar=0;
        }


        /*
        * Envio a la base de datos
        * El return devolvera si se realizo la conexion
        * */


        return true;
    }



}