package com.musicoariel4.listasmascotas.restApi;

public  final class ConstantesRestApi {

    public static final String VERSION = "/v9.0/";
    public static final String ROOT_URL = "https://graph.facebook.com" + VERSION;
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    public static final String USER_ID = "17841402381545326";
    public static final String KEY_USER_MEDIA = "/media?fields=id,caption,media_type,media_url,owner,username,like_count";
    public static final String ACCESS_TOKEN ="EAAafC3tiYRUBAHz8wvd2irT9Y3pKRU7tFM5fiPcFZALH1mwGWTqgiEItKdyHZAduh3ccbyIcAYkz7k7QpTObZBZBhtZCJr7taJMeouH4GLVWj0mAU6OAsyVzVwZCEnzCddjcWnr24MQMV817qbmzDHvZBs9IUeNHK8ZD";
    public static final String URL_USER_MEDIA = USER_ID + KEY_USER_MEDIA + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String ROOT_URL_SERVE = "https://damp-wildwood-55211.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN ="registrar-usuario";

}
