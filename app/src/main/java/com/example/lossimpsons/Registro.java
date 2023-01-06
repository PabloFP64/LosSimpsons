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

public class Registro extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://thesimpsonsuax-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText email = findViewById(R.id.txt_inputUsuarioReg);
        final EditText contrasena = findViewById(R.id.txt_inputContrasenaReg);
        final EditText contrasena2 = findViewById(R.id.txt_inputContrasenaReg2);

        final Button registroBtn = findViewById(R.id.but_reg);

        registroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailTxt = email.getText().toString();
                final String contrasenaTxt = contrasena.getText().toString();
                final String contrasena2Txt = contrasena2.getText().toString();

                if (emailTxt.isEmpty() || contrasenaTxt.isEmpty() || contrasena2Txt.isEmpty()){
                    Toast.makeText(Registro.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
                else if(!contrasenaTxt.equals(contrasena2Txt)){
                    Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                }
                else{
                    databaseReference.child("usuarios").child(emailTxt).child("contrasena").setValue(contrasenaTxt);
                    Toast.makeText(Registro.this, "usuario registrado con exito", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        });


    }
}