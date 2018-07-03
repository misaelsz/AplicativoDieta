package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ti.aplicativodietasaude.R;

public class PaginaLogado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_logado);

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


}
