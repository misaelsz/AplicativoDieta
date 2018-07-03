package com.example.ti.aplicativodietasaude.DAL;

import android.content.Context;

import com.example.ti.aplicativodietasaude.Model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {


    public static long cadastrarUsuario(Usuario usuario, Context context){
//        objetosCidades.add(cidade);
        Banco b = new Banco(context);
        return b.cadastrarUsuario(usuario);
    }

    public static ArrayList<Usuario> retornarUsuarios(Context context){
        Banco b = new Banco(context);
        return b.retornaUsuarios();
    }
}
