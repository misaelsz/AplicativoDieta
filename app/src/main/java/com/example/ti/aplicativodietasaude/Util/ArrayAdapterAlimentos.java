package com.example.ti.aplicativodietasaude.Util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ti.aplicativodietasaude.Model.Alimento;
import com.example.ti.aplicativodietasaude.R;
import com.example.ti.aplicativodietasaude.View.AdicionarAlimentoDietaActivity;

import java.util.ArrayList;

public class ArrayAdapterAlimentos extends ArrayAdapter<Alimento> {

    private ImageView imgAlimento;
    private TextView txtNomeAlimento, txtCalorias;
    private ArrayList<Alimento> alimentos;
    private Context context;
    private int id;

    public ArrayAdapterAlimentos(Context context, ArrayList<Alimento> alimentos){
        super(context, 0, alimentos);
        this.alimentos = alimentos;
        this.context = context;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        final Alimento alimento = alimentos.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_lista_alimentos, null);
        }

        txtNomeAlimento = (TextView) convertView.findViewById(R.id.textoNomeAlimento);
        txtCalorias = (TextView) convertView.findViewById(R.id.textoCalorias);

        txtNomeAlimento.setText(alimento.getNome());
        txtCalorias.setText(alimento.getCalorias());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AdicionarAlimentoDietaActivity.class);
                //intent.putExtra("Dieta", dieta.getNome());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
