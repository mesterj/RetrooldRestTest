package com.kite.joco.retrooldresttest.rest;

import com.squareup.okhttp.OkHttpClient;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Mester József on 2015.11.24..
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://192.168.86.5:8080/NyomtServ1-1.0/webresources/com.mycompany.nyomtserv1.upload/";

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(API_BASE_URL).addConverterFactory(JacksonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
