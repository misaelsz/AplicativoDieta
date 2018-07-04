package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ti.aplicativodietasaude.DAL.AlimentoDAO;
import com.example.ti.aplicativodietasaude.Model.Alimento;
import com.example.ti.aplicativodietasaude.R;

public class CadastroAlimento extends AppCompatActivity {

    private EditText nomeAlimento, calorias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alimento);

        nomeAlimento = (EditText) findViewById(R.id.nomeAlimento);
        calorias = (EditText) findViewById(R.id.calorias);

    }

   public void btnAdicionarAlimento(View view){
       Alimento alimento = new Alimento();

       alimento.setNome(nomeAlimento.getText().toString());
       alimento.setCalorias(calorias.getText().toString());

       AlimentoDAO.cadastrarAlimento(alimento,  this);

       Intent intent = new Intent(this, ListaAlimentos.class);
       startActivity(intent);
    }
}
