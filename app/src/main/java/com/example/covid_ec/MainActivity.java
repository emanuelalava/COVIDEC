package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.username = (EditText)findViewById(R.id.usernameid);
        this.password = (EditText)findViewById(R.id.passwordid);

    }

    public void iniciarSesion(View view) {
        Intent i = new Intent(this, HomeActivity.class );
        i.putExtra("username", username.getText().toString());
        startActivity(i);
    }


    public void openGoogle(View v){
        Uri uri = Uri.parse("https://www.who.int/es/emergencies/diseases/novel-coronavirus-2019");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openTwitter(View v){
        Uri uri = Uri.parse("https://twitter.com/Salud_Ec");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void openFacebook(View v){
        Uri uri = Uri.parse("https://m.facebook.com/SaludEcuador/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
