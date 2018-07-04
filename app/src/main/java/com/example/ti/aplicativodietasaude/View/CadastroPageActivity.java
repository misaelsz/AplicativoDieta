package com.example.ti.aplicativodietasaude.View;

import android.Manifest;
import android.app.Activity;
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

import com.example.ti.aplicativodietasaude.DAL.UsuarioDAO;
import com.example.ti.aplicativodietasaude.R;

import com.example.ti.aplicativodietasaude.Model.Usuario;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CadastroPageActivity extends AppCompatActivity {

    List<Usuario> listaUsuarios = new ArrayList<>();

    String fotoEscolhida;

    private EditText editNome;
    private EditText editEmail;
    private EditText editSenha;
    private EditText editIdade;
    private EditText editPeso;
    private ImageView imgFoto;
    private Button  galeria;
    private Button btnCadastrar;
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

       galeria =  (Button)  findViewById(R.id.galeria);
        galeria.setOnClickListener(new  View.OnClickListener() {
            @Override public void onClick(View v) {
                                           Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                           startActivityForResult(intent, 1);
                                       }
                                   });
        btnCadastrar = (Button) findViewById(R.id.cadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar(view);
                Intent intent = new Intent(CadastroPageActivity.this, PaginaLogado.class);
                intent.putExtra("nomeUsuario", editNome.getText().toString());
                intent.putExtra("fotoUsuario", fotoEscolhida);
                startActivity(intent);
            }
        });


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
        usuario.setFoto(fotoEscolhida);
        usuario.setLogado(1);


        for(int i = 0; i < listaUsuarios.size(); i++){
            Log.v("for: ", Integer.toString(i));
            Log.v("lista de usuarios: ", listaUsuarios.get(i).getNome());
        }
try {
    listaUsuarios = UsuarioDAO.retornarUsuarios(this);

    for (Usuario u : listaUsuarios) {

        if (u.getEmail() == usuario.getEmail()) {

        } else {
            UsuarioDAO.cadastrarUsuario(usuario, this);
        }
    }
}catch (Exception e){
            UsuarioDAO.cadastrarUsuario(usuario, this);
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

