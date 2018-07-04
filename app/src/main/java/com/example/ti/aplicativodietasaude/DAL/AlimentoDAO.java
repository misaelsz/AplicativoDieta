package com.example.ti.aplicativodietasaude.DAL;

import android.content.Context;

import com.example.ti.aplicativodietasaude.Model.Alimento;

import java.util.ArrayList;

public class AlimentoDAO {

    public static long cadastrarAlimento(Alimento alimento, Context context){
//        objetosCidades.add(cidade);
        Banco b = new Banco(context);
        return b.cadastrarAlimento(alimento);
    }

    public static ArrayList<Alimento> retornarAlimentos(Context context){
        Banco b = new Banco(context);
        return b.retornaAlimentos();
    }

}
