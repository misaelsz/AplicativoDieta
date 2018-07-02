package com.example.ti.aplicativodietasaude.DAL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Banco extends SQLiteOpenHelper{

    private static  final String NOME_BANCO = "Saude.db";
    private static  final int VERSAO_BANCO = 1;

    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO = " INTEGER";
    public static final String VIRGULA = ", ";
    public static final String FK = "FOREIGN KEY REFERENCES";

    public static final String SQL_CRIAR_TABELA_USUARIO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaUsuario.NOME_TABELA +
                    "( " + Contrato.TabelaUsuario._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaUsuario.NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.EMAIL + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.SENHA + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.IDADE + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaUsuario.PESO + TIPO_TEXTO + ");";

    public static final String SQL_CRIAR_TABELA_ALIMENTO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaAlimentos.NOME_TABELA +
                    "( " + Contrato.TabelaAlimentos._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaAlimentos.NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaAlimentos.CALORIAS + TIPO_TEXTO + ");";

    public static final String SQL_CRIAR_TABELA_DIETA =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaDieta.NOME_TABELA +
                    "( " + Contrato.TabelaDieta._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaDieta.NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaDieta.FOTO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaDieta.FK_IDUSUARIO + TIPO_INTEIRO + FK + Contrato.TabelaUsuario.NOME_TABELA +"("+  Contrato.TabelaDieta.FK_IDUSUARIO + ")"+");";

    public static final String SQL_CRIAR_TABELA_ALIMENTO_DIETA =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaAlimentoDietaN_N.NOME_TABELA +
                    "( " + Contrato.TabelaDieta._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaAlimentoDietaN_N.FK_ID_ALIMENTO + FK + "(" + Contrato.TabelaAlimentoDietaN_N.FK_ID_ALIMENTO + ")" +
                    Contrato.TabelaAlimentoDietaN_N.FK_ID_DIETA + FK + "(" + Contrato.TabelaAlimentoDietaN_N.FK_ID_DIETA + ")" + ");";

    public static final String SQL_CRIAR_TABELA_EXERCICIO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaExercicio.NOME_TABELA +
                    "( " + Contrato.TabelaDieta._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaDieta.NOME + TIPO_TEXTO + VIRGULA + ");";


    public static final String SQL_CRIAR_TABELA_TREINO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaTreino.NOME_TABELA +
                    "( " + Contrato.TabelaDieta._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaDieta.NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaDieta.FOTO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaDieta.FK_IDUSUARIO + TIPO_INTEIRO + FK + Contrato.TabelaUsuario.NOME_TABELA +"("+  Contrato.TabelaDieta.FK_IDUSUARIO + ")"+");";

    public static final String SQL_CRIAR_TABELA_EXERCICIO_TREINO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaExercicioTreinoN_N.NOME_TABELA +
                    "( " + Contrato.TabelaExercicioTreinoN_N._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaExercicioTreinoN_N.FK_ID_EXERCICIO + FK + "(" + Contrato.TabelaExercicioTreinoN_N.FK_ID_EXERCICIO + ")" +
                    Contrato.TabelaExercicioTreinoN_N.FK_ID_TREINO + FK + "(" + Contrato.TabelaExercicioTreinoN_N.FK_ID_TREINO + ")" + ");";



    public static final String SQL_DELETAR_TABELA_USUARIO =
            "DROP TABLE IF EXISTS " + Contrato.TabelaUsuario.NOME_TABELA;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.v("Banco", Banco.SQL_CRIAR_TABELA_USUARIO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_ALIMENTO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_DIETA);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_ALIMENTO_DIETA);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_EXERCICIO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_TREINO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_EXERCICIO_TREINO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
