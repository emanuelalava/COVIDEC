package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainHomeActivity extends AppCompatActivity {
    Usuario user;
    TextView nombreTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        user = (Usuario) getIntent().getSerializableExtra("user");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(user.getUsername());
    }

    public void cambiarInfoPersonal(View v){
        Intent i = new Intent(this, HomeActivity.class );
        i.putExtra("user",user);
        startActivity(i);
    }

    public void registrarSintomas(View v){
        Intent i = new Intent(this, RegisterActivity.class );
        i.putExtra("user", user);
        startActivity(i);
    }
    public void estadisticas(View view){
        Intent i = new Intent(this, activity_stadistics.class );
        startActivity(i);
    }

    public void verRecomendaciones(View v){
        Intent i = new Intent(this, RecomendacionesActivity.class);
        i.putExtra("user", user);
        startActivity(i);
    }
}
