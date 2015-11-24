package com.kite.joco.retrooldresttest.rest;

import com.squareup.okhttp.OkHttpClient;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Mester József on 2015.11.24..
 */
public class ObjSendService {
    //private static String ROOT_WORK = "http://192.168.86.5:8080/NyomtServ1-1.0/webresources/com.mycompany.nyomtserv1.upload";
    private static String ROOT_WORK = "http://192.168.1.107:8080//NyomtServ-1.0/webresources/com.joco.nyomtserv.partner";
    //  private static FileAPI FILE_CLIENT;

    private static OkHttpClient httpClient = new OkHttpClient();
    //private static Jackson gson = new JacksonConverterFactory().GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(ROOT_WORK)
            .addConverterFactory(JacksonConverterFactory.create());

    public static <S> S createObjSendService(Class<S> ObjSendService){
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(ObjSendService);
    }
}
