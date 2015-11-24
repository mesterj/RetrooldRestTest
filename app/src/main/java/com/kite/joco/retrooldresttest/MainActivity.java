package com.kite.joco.retrooldresttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.kite.joco.retrooldresttest.rest.ObjApi;
import com.kite.joco.retrooldresttest.rest.Partner;
import com.kite.joco.retrooldresttest.rest.ServiceGenerator;

import java.util.List;

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
       // Ember e = new Ember();
       // e.setNev(etNev.getText().toString());
       // Calendar c =  new GregorianCalendar(dtpSzuldate.getYear(),dtpSzuldate.getMonth(),dtpSzuldate.getDayOfMonth());
       // e.setSzulido(c.getTime());
       // Log.i("Emberkuld",e.toString());
        ObjApi api = ServiceGenerator.createService(ObjApi.class);
       /* Call<String> call = api.sendEmber(e);
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
        }*/


        Call<List<Partner>> partnercall = api.getAllPartner();
        /*try {
            List<Partner> partnerList = partnercall.execute().body();
            for (Partner p: partnerList){
                Log.i("Partner: ", " nev : "+ p.getPartnerNev());
            }
        }
        catch (Exception ex) {

        }*/
        try {
            partnercall.enqueue(new Callback<List<Partner>>() {
                @Override
                public void onResponse(Response<List<Partner>> response, Retrofit retrofit) {
                    for (int i=0;i<response.body().size();i++) {
                        Partner p = response.body().get(i);
                        Log.i("Partner", "nev: " + p.getPartnerNev());
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.i("Partner","Failure");
                }
            });
        }
        catch (Exception ex) {
            Log.i("Partner lekérés",ex.getLocalizedMessage());
        }



    }
}
