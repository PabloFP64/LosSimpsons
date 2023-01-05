package com.example.lossimpsons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Inicio extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://lossimpsons-373812-default-rtdb.europe-west1.firebasedatabase.app/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        final EditText email = findViewById(R.id.txt_inputUsuario);
        final EditText contrasena = findViewById(R.id.txt_inputContrasena);
        final Button loginBtn = findViewById(R.id.but_login);
        final Button registerBtn = findViewById(R.id.but_register);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailTxt = email.getText().toString();
                final String contrasenaTxt = contrasena.getText().toString();

                if (emailTxt.isEmpty() || contrasenaTxt.isEmpty()){
                    Toast.makeText(Inicio.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(emailTxt)){
                                final String getContrasena = snapshot.child(emailTxt).child("contrasena").getValue(String.class);
                                if(getContrasena.equals(contrasenaTxt)){
                                    Toast.makeText(Inicio.this, "Inicio de sesión correcto", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Inicio.this, MainActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(Inicio.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Inicio.this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Inicio.this, Registro.class));
            }
        });

    }

}