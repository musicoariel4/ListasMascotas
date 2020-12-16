package com.musicoariel4.listasmascotas.restApi;

import com.musicoariel4.listasmascotas.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndpointsApi {
    @GET(ConstantesRestApi.URL_USER_MEDIA)
    Call<ContactoResponse> getRecentMedia();

    // @GET(ConstantsRestApi.URL_USER_MEDIA)
    // Call<PetResponse> getRecentMedia();

  /*  @GET(ConstantsRestApi.URL_USER_BIO)
    Call<BioResponse> getBioInfo();*/

}
