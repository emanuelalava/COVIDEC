package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainHomeActivity extends AppCompatActivity {

    String nombre;
    TextView nombreTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);


        Bundle bundle = getIntent().getExtras();
        nombre = bundle.getString("username");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(nombre.toString());

    }

    public void cambiarInfoPersonal(View v){
        Intent i = new Intent(this, HomeActivity.class );
        i.putExtra("username", nombre);
        startActivity(i);

    }

    public void registrarSintomas(View v){
        Intent i = new Intent(this, RegisterActivity.class );
        i.putExtra("username", nombre);
        startActivity(i);
    }
}
