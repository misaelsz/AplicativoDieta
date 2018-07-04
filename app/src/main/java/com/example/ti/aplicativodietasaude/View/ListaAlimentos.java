package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ti.aplicativodietasaude.DAL.AlimentoDAO;
import com.example.ti.aplicativodietasaude.Model.Alimento;
import com.example.ti.aplicativodietasaude.R;
import com.example.ti.aplicativodietasaude.Util.ArrayAdapterAlimentos;

import java.util.ArrayList;
import java.util.List;

public class ListaAlimentos extends AppCompatActivity {

    private ListView listaAvancadaAlimento;
    private List<Alimento> alimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alimentos);

        listaAvancadaAlimento = (ListView) findViewById(R.id.listaAlimentos);

        alimentos = new ArrayList<Alimento>();

        alimentos = AlimentoDAO.retornarAlimentos(this);

        if(alimentos == null){
            Intent intent = new Intent(this, CadastroAlimento.class);
            startActivity(intent);

        }
        else {
            ArrayAdapterAlimentos arrayAdapterAlimentos =
                    new ArrayAdapterAlimentos(this, AlimentoDAO.retornarAlimentos(this));

            listaAvancadaAlimento.setAdapter(arrayAdapterAlimentos);
        }
    }

    public void btnNovoAlimento(View view){

        Intent intent = new Intent(this, CadastroAlimento.class);
        startActivity(intent);
    }
}
