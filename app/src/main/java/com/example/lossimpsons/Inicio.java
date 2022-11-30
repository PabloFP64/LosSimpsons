package com.example.lossimpsons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    EditText usuario, contrasena;
    Button iniciarSesion, registrarse;
    BaseDatos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        usuario = findViewById(R.id.txt_inputUsuario);
        contrasena = findViewById(R.id.txt_inputContrasena);
        iniciarSesion = findViewById(R.id.but_login);
        registrarse = findViewById(R.id.but_register);
        db = new BaseDatos();

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), Registro.class);
                //startActivity(intent);
            }
        });

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = usuario.getText().toString();
                String contr = contrasena.getText().toString();

                if (TextUtils.isEmpty(usr) || TextUtils.isEmpty(contr)) {
                    Toast.makeText(Inicio.this, "Faltan datos", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean comprobarContrasena = db.comprobarContrasena(usr, contr);
                    if (comprobarContrasena) {
                        Toast.makeText(Inicio.this, "Has iniciado sesion correctamente", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Inicio.this, "Error de usuario o contraseña", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}