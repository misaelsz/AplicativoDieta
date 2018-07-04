package com.example.ti.aplicativodietasaude.Model;

import java.io.Serializable;

public class Alimento implements Serializable{

    private String nome;
    private String calorias;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }
}
