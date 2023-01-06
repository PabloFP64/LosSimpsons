package com.example.lossimpsons;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://thesimpsonsuax-default-rtdb.firebaseio.com/");

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