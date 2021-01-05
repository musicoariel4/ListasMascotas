package com.musicoariel4.listasmascotas.restApi;

import com.musicoariel4.listasmascotas.pojo.UsuarioRespond;
import com.musicoariel4.listasmascotas.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IEndpointsApi {
    @GET(ConstantesRestApi.URL_USER_MEDIA)
    Call<ContactoResponse> getRecentMedia();

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioRespond>registrarToken(@Field("id_dispositivo")String id_dispositivo, @Field("id_usuario_instagram")String id_usuario_instagram);


    // @GET(ConstantsRestApi.URL_USER_MEDIA)
    // Call<PetResponse> getRecentMedia();

  /*  @GET(ConstantsRestApi.URL_USER_BIO)
    Call<BioResponse> getBioInfo();*/

}
