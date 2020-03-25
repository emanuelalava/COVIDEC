package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {
    Usuario user;
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

        //Bundle bundle = getIntent().getExtras();
        user = (Usuario) getIntent().getSerializableExtra("user");
        nombreTV = (TextView) findViewById(R.id.nombreTV);
        //
        //
        //NOTAAA CAMBIAR getUsername por getNombre()
        //
        //
        String nombreText="Bienvenido: "+user.getUsername();
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
        if (envioDeRegistro()){
            Intent i = new Intent(this, MainHomeActivity.class );
            i.putExtra("user",user);
            startActivity(i);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),"Fallo de conexión",Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public boolean envioDeRegistro(){
        if (!sexo.isChecked()){
            user.setSexo(sexo.getTextOff().toString());
        }
        else{
            user.setSexo(sexo.getTextOn().toString());
        }
        user.setLugar(lugar.getText().toString());
        user.setFecha(fecha.getText().toString());
        user.setPeso(peso.getText().toString());
        user.setTalla(talla.getText().toString());
        user.setTelefono(telefono.getText().toString());
        user.setTelefonoContacto(telefonoContacto.getText().toString());
        /*
        *  Envio de datos a la nube
        *  Si es exitoso retorna true,
        *  Caso contrario false
        */
        return true;
    }


}
