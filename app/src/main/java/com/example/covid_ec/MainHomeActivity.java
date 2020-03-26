package com.example.covid_ec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainHomeActivity extends AppCompatActivity {
    Usuario user;
    TextView nombreTV;
    private JsonObject j;
    Map<String, Object> retMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        user = (Usuario) getIntent().getSerializableExtra("user");
        nombreTV = (TextView) findViewById(R.id.usernameid);
        nombreTV.setText(user.getUsername());
    }

    public void cambiarInfoPersonal(View v) {
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("user", user);
        startActivity(i);
    }

    public void registrarSintomas(View v) {
        Intent i = new Intent(this, RegisterActivity.class);
        i.putExtra("user", user);
        startActivity(i);
    }

    public void estadisticas(View view) {
        Intent i = new Intent(this, activity_stadistics.class);
        startActivity(i);
    }


    public void obtenerMensajes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid19ec-2d508.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();

        InformacionPacienteApi infoApi = retrofit.create(InformacionPacienteApi.class);
        Call<JsonObject> call = infoApi.getPosts();

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                j = response.body();
                retMap = new Gson().fromJson(
                        j.get("-M3NeF-OMugt8b0U8UjU"), new TypeToken<HashMap<String, Object>>() {
                        }.getType()
                );
                // System.out.println(j.get("-M3NeF-OMugt8b0U8UjU"));
                System.out.println(j);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });


    }

    public void mostrarMensajes(View view) {
        obtenerMensajes();
        Intent i = new Intent(this, Mensajes.class);
        startActivity(i);


        public void verRecomendaciones (View v){
            Intent i = new Intent(this, RecomendacionesActivity.class);
            i.putExtra("user", user);
            startActivity(i);
        }
    }
}
