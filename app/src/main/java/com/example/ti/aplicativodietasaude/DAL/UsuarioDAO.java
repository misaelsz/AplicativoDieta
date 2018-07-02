package com.example.ti.aplicativodietasaude.DAL;

import android.content.Context;

import com.example.ti.aplicativodietasaude.Model.Usuario;

public class UsuarioDAO {
    public static long cadastrarUsuario(Usuario usuario, Context context){
//        objetosCidades.add(cidade);
        Banco b = new Banco(context);
        return b.cadastrarUsuario(usuario);
    }
}
