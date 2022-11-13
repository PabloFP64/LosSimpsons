package com.example.lossimpsons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Personajes extends AppCompatActivity {

    private String nombre;
    private int vida;

    public Personajes(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personajes);
    }
}