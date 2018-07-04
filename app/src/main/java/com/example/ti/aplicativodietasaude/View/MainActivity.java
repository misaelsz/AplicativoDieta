package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ti.aplicativodietasaude.DAL.Banco;
import com.example.ti.aplicativodietasaude.DAL.UsuarioDAO;
import com.example.ti.aplicativodietasaude.R;
import com.example.ti.aplicativodietasaude.View.CadastroPageActivity;
import com.example.ti.aplicativodietasaude.View.LoginActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UsuarioDAO.UsersDeslogar(this);
    }

    public void cadastrarse(View view){
        Intent intent = new Intent(this, CadastroPageActivity.class);
        startActivity(intent);
    }

    public void logarse(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void deletarBanco(View view){
        Banco db = new Banco(this);
        this.deleteDatabase("Saude.db");
    }

}
