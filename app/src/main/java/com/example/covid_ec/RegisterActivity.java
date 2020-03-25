package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_ec.interfaces.InformacionPacienteApi;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.Hashtable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    Hashtable<Integer, String> estado = new Hashtable<Integer,String>();
    EditText temperatura;
    Usuario user;
    SeekBar intensidad,dificultadrespirar,dolor;
    String intensidadTos,dificultadRes,nivelDolor;
    TextView tvintensidad,tvdificultad,tvdolor;
    String infos;
    TextView nombreTV;
    CheckBox diarrea,vomito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        temperatura=(EditText) findViewById(R.id.temperaturaid);
        user = (Usuario) getIntent().getSerializableExtra("user");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(user.getNombre());
        diarrea=(CheckBox) findViewById(R.id.diarrea);
        vomito=(CheckBox) findViewById(R.id.vomito);
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
                intensidadTos=estado.get(i);
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
                dificultadRes=estado.get(i);
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
                nivelDolor=estado.get(i);
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
        sendPost(this);
        Intent i = new Intent(this, MainHomeActivity.class );
        i.putExtra("user", user);
        startActivity(i);
    }

    public void sendPost(final Context ctx) {
        JsonObject json = new JsonObject();
        json.addProperty("temperatura", temperatura.getText().toString());
        json.addProperty("intensidadTos", intensidadTos);
        json.addProperty("tosidosMinuto",tvintensidad.getText().toString() );
        json.addProperty("DificultadRespirar", dificultadRes);
        json.addProperty("nivelDolor", nivelDolor);
        json.addProperty("hasDiarrea", String.valueOf( diarrea.isChecked()));
        json.addProperty("hasVomito",String.valueOf( vomito.isChecked()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.46:3000/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        InformacionPacienteApi  infoApi= retrofit.create(InformacionPacienteApi.class);

        Call<JsonObject> call = infoApi.createPost(json);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Toast.makeText(ctx,"La operacion se realizo con exito",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(ctx,"La operacion no pudo realizarse",Toast.LENGTH_SHORT).show();
            }
        });

    }
}