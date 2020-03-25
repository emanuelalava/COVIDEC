package com.example.covid_ec.interfaces;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InformacionPacienteApi {
    @GET("prueba")
    Call<JsonObject> getPosts();

    @POST("prueba")
    Call<JsonObject> createPost(@Body JsonObject post);

}
