package com.example.jesus.cleanfuel.app.model;

public class Carro {
    private String marca, modelo;
    private int ano, quilometreagem;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQuilometreagem() {
        return quilometreagem;
    }

    public void setQuilometreagem(int quilometreagem) {
        this.quilometreagem = quilometreagem;
    }
}
