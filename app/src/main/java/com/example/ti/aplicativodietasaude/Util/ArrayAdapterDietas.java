package com.example.ti.aplicativodietasaude.Util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ti.aplicativodietasaude.Model.Dieta;
import com.example.ti.aplicativodietasaude.R;
import com.example.ti.aplicativodietasaude.View.AdicionarAlimentoDietaActivity;

import java.util.ArrayList;

public class ArrayAdapterDietas extends ArrayAdapter<Dieta>{

    private ImageView imagemDieta;
    private TextView txtNomeDieta;

    private ArrayList<Dieta> dietas;

    private Context context;


    public ArrayAdapterDietas(Context context, ArrayList<Dieta> dietas){
        super(context, 0, dietas);
        this.dietas = dietas;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final  Dieta dieta = dietas.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item_lista_dieta, null);
        }

        imagemDieta = (ImageView) convertView.findViewById(R.id.imagemDieta);
        txtNomeDieta = (TextView) convertView.findViewById(R.id.textoNomeDieta);

        Bitmap thumbnail = (BitmapFactory.decodeFile(dieta.getImagem()));

        txtNomeDieta.setText(dieta.getNome());
        imagemDieta.setImageBitmap(thumbnail);

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
