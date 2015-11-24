package com.kite.joco.retrooldresttest.rest;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Mester József on 2015.11.24..
 */
public interface ObjApi {

    /*@POST("jsonreq")
    Call<String> sendEmber(@Body Ember e);*/

    @GET("/")
    Call<List<Partner>> getAllPartner();
}
