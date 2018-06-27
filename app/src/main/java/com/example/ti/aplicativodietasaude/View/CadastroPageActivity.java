package com.example.ti.aplicativodietasaude.View;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.ti.aplicativodietasaude.R;

import com.example.ti.aplicativodietasaude.Model.Usuario;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CadastroPageActivity extends AppCompatActivity {

    List<Usuario> listaUsuarios = new ArrayList<>();

    private EditText editNome;
    private EditText editEmail;
    private EditText editSenha;
    private EditText editIdade;
    private EditText editPeso;
    private ImageView imgFoto;

    private  int PERMISSAO_REQUEST = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_page);


        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)!=  PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE))  {

            }  else{
                ActivityCompat.requestPermissions(this,new  String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSAO_REQUEST);
            }
        }


                editNome = (EditText) findViewById(R.id.editNome);
                editEmail = (EditText) findViewById(R.id.editEmail);
                editSenha = (EditText) findViewById(R.id.editSenha);
                editIdade = (EditText) findViewById(R.id.editIdade);
                editPeso = (EditText) findViewById(R.id.editPeso);
                imgFoto = (ImageView) findViewById(R.id.foto);
            }







    public void cadastrar(View view){
        Usuario usuario = new Usuario();

        usuario.setNome(editNome.getText().toString());
        usuario.setEmail(editEmail.getText().toString());
        usuario.setSenha(editSenha.getText().toString());
        usuario.setIdade(Integer.parseInt(editIdade.getText().toString()));
        usuario.setPeso(Double.parseDouble(editPeso.getText().toString()));
        usuario.setFoto(imgFoto.getDrawable().toString());

        listaUsuarios.add(usuario);

        for(int i = 0; i < listaUsuarios.size(); i++){
            Log.v("for: ", Integer.toString(i));
            Log.v("lista de usuarios: ", listaUsuarios.get(i).getNome());
        }
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
        }

