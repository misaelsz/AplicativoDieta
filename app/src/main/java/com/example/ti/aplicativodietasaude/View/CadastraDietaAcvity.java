package com.example.ti.aplicativodietasaude.View;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ti.aplicativodietasaude.DAL.DietaDAO;
import com.example.ti.aplicativodietasaude.Model.Dieta;
import com.example.ti.aplicativodietasaude.Model.Usuario;
import com.example.ti.aplicativodietasaude.R;

import java.util.ArrayList;
import java.util.List;

public class CadastraDietaAcvity extends AppCompatActivity {


    List<Dieta> listaDieta = new ArrayList<Dieta>();

    String fotoEscolhida;

    private EditText editNome;
    private ImageView imgFoto;
    private Button galeria;
    private Button btnCadastrar;
    private int PERMISSAO_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_dieta_acvity);


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSAO_REQUEST);
            }
        }

        galeria = (Button) findViewById(R.id.galeria);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        btnCadastrar = (Button) findViewById(R.id.cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar(view);
                Intent intent = new Intent(CadastraDietaAcvity.this, ListaDietas.class);
                startActivity(intent);
            }
        });


        editNome = (EditText) findViewById(R.id.editNome);
        imgFoto = (ImageView) findViewById(R.id.foto);
    }


    public void cadastrar(View view) {
        Dieta dieta = new Dieta();

        dieta.setNome(editNome.getText().toString());
        dieta.setImagem(fotoEscolhida);

        DietaDAO.cadastrarDieta(dieta, this);
    }

    @Override public void onRequestPermissionsResult(int requestCode,String  permissions[],  int[]  grantResults) {
        if (requestCode == PERMISSAO_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //  A  permissão  foi  concedida.  Pode  continuar

            }
            else{
                //  A  permissão  foi  negada.  Precisa  ver  o  que  deve  ser  desabilitado

            }
        }

    }

    @Override protected  void  onActivityResult(int requestCode,  int resultCode,  Intent  data)  {
        super.onActivityResult(requestCode,  resultCode,  data);
        if  (resultCode==  RESULT_OK  &&  requestCode==  1)  {
            Uri selectedImage = data.getData();String[]  filePath = {MediaStore.Images.Media.DATA};

            Cursor c  =  getContentResolver().query(selectedImage,filePath,  null,  null,  null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePath[0]);
            String  picturePath = c.getString(columnIndex);
            c.close();
            Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
            Log.v("foto escolhida: ", picturePath);
            fotoEscolhida = picturePath;
            imgFoto.setImageBitmap(thumbnail);
        }
    }

}