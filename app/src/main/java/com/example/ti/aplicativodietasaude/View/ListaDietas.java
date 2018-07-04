package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ti.aplicativodietasaude.DAL.AlimentoDAO;
import com.example.ti.aplicativodietasaude.DAL.DietaDAO;
import com.example.ti.aplicativodietasaude.Model.Alimento;
import com.example.ti.aplicativodietasaude.Model.Dieta;
import com.example.ti.aplicativodietasaude.R;
import com.example.ti.aplicativodietasaude.Util.ArrayAdapterAlimentos;
import com.example.ti.aplicativodietasaude.Util.ArrayAdapterDietas;

import java.util.ArrayList;
import java.util.List;

public class ListaDietas extends AppCompatActivity {

    private ListView listaAvancadaDieta;
    private List<Dieta> dietas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dietas);

        listaAvancadaDieta = (ListView) findViewById(R.id.listaDietas);

        dietas = new ArrayList<Dieta>();

        dietas = DietaDAO.retornarDietas(this);

        if(dietas == null){
            Intent intent = new Intent(this, CadastraDietaAcvity.class);
            startActivity(intent);

        }
        else {
            ArrayAdapterDietas arrayAdapterDietas =
                    new ArrayAdapterDietas(this, DietaDAO.retornarDietas(this));

            listaAvancadaDieta.setAdapter(arrayAdapterDietas);
        }

    }

}
