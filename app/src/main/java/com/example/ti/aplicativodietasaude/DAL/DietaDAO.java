package com.example.ti.aplicativodietasaude.DAL;

import android.content.Context;

import com.example.ti.aplicativodietasaude.Model.Alimento;
import com.example.ti.aplicativodietasaude.Model.Dieta;

import java.util.ArrayList;

public class DietaDAO {

    public static long cadastrarDieta(Dieta dieta, Context context){
//        objetosCidades.add(cidade);
        Banco b = new Banco(context);
        return b.cadastrarDieta(dieta);
    }

    public static ArrayList<Dieta> retornarDietas(Context context){
        Banco b = new Banco(context);
        return b.retornaDietas();
    }
}
