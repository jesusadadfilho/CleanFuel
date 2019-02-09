package com.example.jesus.cleanfuel.app.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Posto {
    private LatLng location;
    private String nome;
    private String marca;

    public Posto( String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
    }

    public void setLocation(double latitude, double longitude){
        this.location =  new LatLng(latitude, longitude);
    }

    public LatLng getLocation() {
        return location;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }
    //-5.0880067,-42.8105116
     public static ArrayList<Posto> generate(int quant){
        ArrayList<Posto> postos = new ArrayList<>();
         for (int i = 0; i < quant ; i++) {
             int codletra = ThreadLocalRandom.current().nextInt(65, 90 + 1);
             String letra = String.valueOf((char)codletra);
             Posto posto = new Posto("Posto "  + letra, letra);
             double latitude = ThreadLocalRandom.current().nextDouble(-5.0860215, -5.0860215 + 0.3);
             double longitude = ThreadLocalRandom.current().nextDouble(-42.8131678, -42.8131678 + 0.3);
             posto.setLocation(latitude, longitude);
             postos.add(posto);
         }
         return postos;
     }

}
