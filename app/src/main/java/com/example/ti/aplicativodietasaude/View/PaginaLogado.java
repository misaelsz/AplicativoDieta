package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ti.aplicativodietasaude.R;

public class PaginaLogado extends AppCompatActivity {

    private Button btnCadAlimento, btnCadDieta, btnCadExercicio, btnCadTreino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_logado);

        btnCadAlimento = (Button) findViewById(R.id.btnCadAlimento);
        btnCadDieta = (Button) findViewById(R.id.btnCadDieta);
        btnCadExercicio = (Button) findViewById(R.id.btnCadExercicio);
        btnCadTreino = (Button) findViewById(R.id.btnCadTreino);



        Intent intent = getIntent();
        String nomeUsuario = (String) intent.getSerializableExtra("nomeUsuario");
        String fotoUsuario = (String) intent.getSerializableExtra("fotoUsuario");

        TextView txtNome = (TextView) findViewById(R.id.paramNome);
        ImageView imgUsuario = (ImageView) findViewById(R.id.paramFoto);

        txtNome.setText("Olá "+ nomeUsuario);
        Bitmap thumbnail = (BitmapFactory.decodeFile(fotoUsuario));
        Log.v("caminho", fotoUsuario);
        imgUsuario.setImageBitmap(thumbnail);
    }


    public void btnListaAlimentos(View view){

        Intent intent = new Intent(this, ListaAlimentos.class);
        startActivity(intent);
    }


     public void btnListaDietas(View view){
        Intent intent = new Intent(this, ListaDietas.class);
        startActivity(intent);
     }




}
