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

public class Registro extends AppCompatActivity {

    EditText usuario, contrasena, contrasena2;
    Button registrarse;
    BaseDatos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario = findViewById(R.id.txt_inputUsuarioReg);
        contrasena = findViewById(R.id.txt_inputContrasenaReg);
        contrasena2 = findViewById(R.id.txt_inputContrasenaReg2);
        registrarse = findViewById(R.id.but_reg);
        db = new BaseDatos();

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = usuario.getText().toString();
                String contr = contrasena.getText().toString();
                String contr2 = contrasena2.getText().toString();

                if (TextUtils.isEmpty(usr) || TextUtils.isEmpty(contr) || TextUtils.isEmpty(contr2)) {
                    Toast.makeText(Registro.this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean comprobarUsuario = db.comprobarUsuario(usr);
                    if (comprobarUsuario == false) {
                        Boolean insertar = db.anadirUsuario(new Usuario( usr, contr, contr2));
                        if (insertar) {
                            Toast.makeText(Registro.this, "Registro completado con exito", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Registro.this, "Hubo un fallo en el registro", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Registro.this, "Este usuario ya existe", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}