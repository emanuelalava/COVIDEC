package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Hashtable;

public class RegisterActivity extends AppCompatActivity {
    Hashtable<Integer, String> estado = new Hashtable<Integer,String>();

    SeekBar intensidad,dificultadrespirar,dolor;
    TextView tvintensidad,tvdificultad,tvdolor;
    String infos;
    String nombre;
    TextView nombreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("username");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(nombre.toString());

        intensidad = (SeekBar) findViewById(R.id.intensidadtosid);
        dificultadrespirar = (SeekBar) findViewById(R.id.dificultadid);
        dolor = (SeekBar) findViewById(R.id.dolorid);

        tvintensidad = (TextView) findViewById(R.id.TVtosid);
        tvdificultad = (TextView) findViewById(R.id.TVdificultadid);
        tvdolor = (TextView) findViewById(R.id.TVdolorid);

        estado.put(0,"Despreciable");
        estado.put(1,"Bajo");
        estado.put(2,"Medio");
        estado.put(3,"Alto");

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

        Intent i = new Intent(this, MainHomeActivity.class );
        i.putExtra("username", nombre);
        startActivity(i);
    }
}