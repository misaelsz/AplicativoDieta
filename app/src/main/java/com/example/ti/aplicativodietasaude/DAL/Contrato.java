package com.example.ti.aplicativodietasaude.DAL;

import android.provider.BaseColumns;

public class Contrato {

    public static class TabelaUsuario implements BaseColumns{
        public static final String NOME_TABELA = "tbUsuarios";
        public static final String NOME = "nome";
        public static final String EMAIL = "email";
        public static final String SENHA = "senha";
        public static final String PESO = "peso";
        public static final String IDADE = "idade";
    }

    public static class TabelaAlimentos implements  BaseColumns{
        public static final String NOME_TABELA = "tbAlimentos";
        public static final String NOME = "nome";
        public static final String CALORIAS = "calorias";
    }

    public static class TabelaDieta implements BaseColumns{
        public static final String NOME_TABELA = "tbDieta";
        public static final String NOME= "nome";
        public static final String FOTO = "foto";
    }

    public static class TabelaExercicio implements  BaseColumns{
        
    }
}
