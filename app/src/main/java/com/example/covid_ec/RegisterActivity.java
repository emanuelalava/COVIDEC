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
    Usuario user;
    SeekBar intensidad,dificultadrespirar,dolor;
    TextView tvintensidad,tvdificultad,tvdolor;
    String infos;
    TextView nombreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = (Usuario) getIntent().getSerializableExtra("user");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(user.getNombre());

        intensidad = (SeekBar) findViewById(R.id.intensidadtosid);
        dificultadrespirar = (SeekBar) findViewById(R.id.dificultadid);
        dolor = (SeekBar) findViewById(R.id.dolorid);

        tvintensidad = (TextView) findViewById(R.id.TVtosid);
        tvdificultad = (TextView) findViewById(R.id.TVdificultadid);
        tvdolor = (TextView) findViewById(R.id.TVdolorid);

        estado.put(0,"Peor que ayer");
        estado.put(1,"Igual que ayer");
        estado.put(2,"Mejor que ayer");


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
        i.putExtra("user", user);
        startActivity(i);
    }
}