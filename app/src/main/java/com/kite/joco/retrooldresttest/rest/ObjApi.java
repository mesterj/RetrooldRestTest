package com.kite.joco.retrooldresttest.rest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Mester József on 2015.11.24..
 */
public interface ObjApi {

    @POST("jsonreq")
    Call<String> sendEmber(@Body Ember e);
}
