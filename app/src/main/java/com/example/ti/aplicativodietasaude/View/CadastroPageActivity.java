package com.example.ti.aplicativodietasaude.View;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.ti.aplicativodietasaude.R;

import com.example.ti.aplicativodietasaude.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CadastroPageActivity extends AppCompatActivity {

    List<Usuario> listaUsuarios = new ArrayList<>();

    private EditText editNome;
    private EditText editEmail;
    private EditText editSenha;
    private EditText editIdade;
    private EditText editPeso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_page);

        editNome = (EditText) findViewById(R.id.editNome);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editSenha = (EditText) findViewById(R.id.editSenha);
        editIdade = (EditText) findViewById(R.id.editIdade);
        editPeso = (EditText) findViewById(R.id.editPeso);
    }

    public void cadastrar(View view){
        Usuario usuario = new Usuario();

        usuario.setNome(editNome.getText().toString());
        usuario.setEmail(editEmail.getText().toString());
        usuario.setSenha(editSenha.getText().toString());
        usuario.setIdade(Integer.parseInt(editIdade.getText().toString()));
        usuario.setPeso(Double.parseDouble(editPeso.getText().toString()));

        listaUsuarios.add(usuario);

       for(int i = 0; i < listaUsuarios.size(); i++){
            Log.v("for: ", Integer.toString(i));
            Log.v("lista de usuarios: ", listaUsuarios.get(i).getNome());
        }
    }

    public void escolherFoto(View view){

      Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);

        startActivityForResult(intent, 123);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 123){
                Uri imagemSelecionada = data.getData();

            }
        }
    }



}
