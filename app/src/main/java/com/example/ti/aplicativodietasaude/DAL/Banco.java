package com.example.ti.aplicativodietasaude.DAL;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ti.aplicativodietasaude.Model.Usuario;

import java.util.ArrayList;

public class Banco extends SQLiteOpenHelper{

    private static  final String NOME_BANCO = "Saude.db";
    private static  final int VERSAO_BANCO = 1;

    public static final String TIPO_TEXTO = " TEXT";
    public static final String TIPO_INTEIRO = " INTEGER";
    public static final String VIRGULA = ", ";
    public static final String FK = " FOREIGN KEY REFERENCES ";

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
                    Contrato.TabelaDieta.FK_IDUSUARIO + TIPO_INTEIRO + ");";

    public static final String SQL_CRIAR_TABELA_ALIMENTO_DIETA =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaAlimentoDietaN_N.NOME_TABELA +
                    "( " + Contrato.TabelaDieta._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaAlimentoDietaN_N.FK_ID_ALIMENTO + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaAlimentoDietaN_N.FK_ID_DIETA + TIPO_INTEIRO + ");";

    public static final String SQL_CRIAR_TABELA_EXERCICIO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaExercicio.NOME_TABELA +
                    "( " + Contrato.TabelaExercicio._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaExercicio.NOME + TIPO_TEXTO + ");";


    public static final String SQL_CRIAR_TABELA_TREINO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaTreino.NOME_TABELA +
                    "( " + Contrato.TabelaDieta._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaDieta.NOME + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaDieta.FOTO + TIPO_TEXTO + VIRGULA +
                    Contrato.TabelaDieta.FK_IDUSUARIO + TIPO_INTEIRO + ");";

    public static final String SQL_CRIAR_TABELA_EXERCICIO_TREINO =
            "CREATE TABLE IF NOT EXISTS " + Contrato.TabelaExercicioTreinoN_N.NOME_TABELA +
                    "( " + Contrato.TabelaExercicioTreinoN_N._ID + TIPO_INTEIRO +
                    " PRIMARY KEY AUTOINCREMENT" + VIRGULA +
                    Contrato.TabelaExercicioTreinoN_N.FK_ID_EXERCICIO + TIPO_INTEIRO + VIRGULA +
                    Contrato.TabelaExercicioTreinoN_N.FK_ID_TREINO + TIPO_INTEIRO + ");";



    public static final String SQL_DELETAR_TABELA_USUARIO =
            "DROP TABLE IF EXISTS " + Contrato.TabelaUsuario.NOME_TABELA;

    public Banco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.v("Banco", Banco.SQL_CRIAR_TABELA_USUARIO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_ALIMENTO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_DIETA);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_ALIMENTO_DIETA);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_EXERCICIO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_TREINO);
        Log.v("Banco", Banco.SQL_CRIAR_TABELA_EXERCICIO_TREINO);

        db.execSQL(SQL_CRIAR_TABELA_USUARIO);
        db.execSQL(SQL_CRIAR_TABELA_ALIMENTO);
        db.execSQL(SQL_CRIAR_TABELA_EXERCICIO);
        db.execSQL(SQL_CRIAR_TABELA_TREINO);
        db.execSQL(SQL_CRIAR_TABELA_DIETA);
        db.execSQL(SQL_CRIAR_TABELA_EXERCICIO_TREINO);
        db.execSQL(SQL_CRIAR_TABELA_ALIMENTO_DIETA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  long cadastrarUsuario(Usuario usuario){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put(Contrato.TabelaUsuario.NOME, usuario.getNome());
        dados.put(Contrato.TabelaUsuario.EMAIL, usuario.getEmail());
        dados.put(Contrato.TabelaUsuario.PESO, usuario.getPeso());
        dados.put(Contrato.TabelaUsuario.IDADE, usuario.getIdade());
        dados.put(Contrato.TabelaUsuario.SENHA, usuario.getSenha());

        return db.insert(Contrato.TabelaUsuario.NOME_TABELA, null, dados);
    }

    public ArrayList<Usuario> retornaUsuario(){
        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Usuario> usuarios  = new ArrayList<Usuario>();
        Usuario s = new Usuario();


    }

}

