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
        public static final String FOTO = "foto";
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
        public static final String FK_IDUSUARIO = "idUsuario";
    }

    public static class TabelaExercicio implements  BaseColumns{
        public static final String NOME_TABELA = "tbDieta";
        public static final String NOME = "nome";
    }

    public static class TabelaTreino implements  BaseColumns{
        public static final String NOME_TABELA = "tbTreino";
        public static final String NOME= "nome";
        public static final String FOTO = "foto";
        public static final String FK_IDUSUARIO = "idUsuario";

    }

    public static class TabelaExercicioTreinoN_N implements  BaseColumns{
        public static final String NOME_TABELA = "tbExercicioTreino";
        public static final String FK_ID_EXERCICIO = "idExercicio";
        public static final String FK_ID_TREINO = "idTreino";
    }

    public static class TabelaAlimentoDietaN_N implements  BaseColumns{
        public static final String NOME_TABELA = "tbAlimentoDieta";
        public static final String FK_ID_ALIMENTO = "idAlimento";
        public static final String FK_ID_DIETA = "idDieta";
    }
}
