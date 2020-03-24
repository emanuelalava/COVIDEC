package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {

    String nombre;
    EditText lugar,fecha,peso,talla,telefono,telefonoContacto;
    TextView nombreTV;
    ToggleButton sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.sexo = (ToggleButton) findViewById(R.id.sexoid);
        this.lugar = (EditText)findViewById(R.id.lugarid);
        this.fecha = (EditText)findViewById(R.id.fechaid);
        this.peso = (EditText)findViewById(R.id.pesoid);
        this.talla = (EditText)findViewById(R.id.tallaid);
        this.telefono = (EditText)findViewById(R.id.telefonoid);
        this.telefonoContacto = (EditText)findViewById(R.id.telefonoContactoid);

        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("username");
        nombreTV = (TextView) findViewById(R.id.nombreTV);
        String nombreText="Bienvenido: "+nombre;
        nombreTV.setText(nombreText);

    }

    public void cambiarColor(View v){

        if(sexo.isChecked()) {
            sexo.setBackgroundColor(Color.parseColor("#ff4e4e"));
        }
        else{
            sexo.setBackgroundColor(Color.parseColor("#19608d"));
        }
    }

    public void nextActivity(View view) {

        Intent i = new Intent(this, MainHomeActivity.class );
        i.putExtra("username", nombre);
        startActivity(i);
    }
}
