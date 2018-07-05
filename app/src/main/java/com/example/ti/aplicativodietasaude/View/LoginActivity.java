package com.example.ti.aplicativodietasaude.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.ti.aplicativodietasaude.DAL.UsuarioDAO;
import com.example.ti.aplicativodietasaude.Model.Usuario;
import com.example.ti.aplicativodietasaude.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);


        editSenha = (EditText) findViewById(R.id.etSenha);
        editEmail = (EditText) findViewById(R.id.edtEmail);
    }

    public void  logar(View view){
        List<Usuario> listaUsuariosTemp = new ArrayList<Usuario>();
       listaUsuariosTemp =  UsuarioDAO.retornarUsuarios(this);

        for (Usuario u : listaUsuariosTemp
             ) {
            Log.v("nome usuario: ", u.getNome());
            Log.v("senha usuario: ", u.getSenha());
            if (editEmail.getText().toString().equals(u.getEmail()) && editSenha.getText().toString().equals(u.getSenha())){
                Log.v("entrou no if", editEmail.toString());
                Intent intent = new Intent(LoginActivity.this, PaginaLogado.class);
                intent.putExtra("nomeUsuario", u.getNome());
                intent.putExtra("fotoUsuario", u.getFoto());
                intent.putExtra("idUser", u.getId());
                startActivity(intent);
            }
        }


    }
}
