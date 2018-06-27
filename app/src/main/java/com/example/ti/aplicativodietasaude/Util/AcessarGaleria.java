package com.example.ti.aplicativodietasaude.Util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ti.aplicativodietasaude.R;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class AcessarGaleria extends AppCompatActivity {

    public  void escolherFoto(){


        Intent intent  =  new      Intent(Intent.ACTION_PICK,  android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

}
