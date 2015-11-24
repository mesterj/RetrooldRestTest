package com.kite.joco.retrooldresttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.kite.joco.retrooldresttest.rest.Ember;
import com.kite.joco.retrooldresttest.rest.ObjApi;
import com.kite.joco.retrooldresttest.rest.ObjSendService;
import com.kite.joco.retrooldresttest.rest.ServiceGenerator;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText etNev;
    DatePicker dtpSzuldate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNev = (EditText) findViewById(R.id.etNev);
        dtpSzuldate = (DatePicker) findViewById(R.id.datePicker);
    }

    public void sendEmber(View v) {
        Ember e = new Ember();
        e.setNev(etNev.getText().toString());
        Calendar c =  new GregorianCalendar(dtpSzuldate.getYear(),dtpSzuldate.getMonth(),dtpSzuldate.getDayOfMonth());
        e.setSzulido(c.getTime());
        Log.i("Emberkuld",e.toString());
        ObjApi api = ServiceGenerator.createService(ObjApi.class);
        Call<String> call = api.sendEmber(e);
        try {
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Response<String> response, Retrofit retrofit) {
                    Log.i("SEND","SUCCESS");
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.i("SEND","failure" + t.getMessage());
                }
            });
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}
