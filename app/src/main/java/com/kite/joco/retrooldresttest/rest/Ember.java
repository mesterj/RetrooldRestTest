package com.kite.joco.retrooldresttest.rest;

import java.util.Date;

/**
 * Created by Mester József on 2015.11.24..
 */
public class Ember {

    String nev;
    Date szulido;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzulido() {
        return szulido;
    }

    public void setSzulido(Date szulido) {
        this.szulido = szulido;
    }

    @Override
    public String toString() {
        return "Ember{" +
                "nev='" + nev + '\'' +
                ", szuldate=" + szulido +
                '}';
    }
}
