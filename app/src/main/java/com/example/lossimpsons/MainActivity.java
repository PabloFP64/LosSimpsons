package com.example.lossimpsons;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void VentanaPersonajes(View view) {
        Intent intentPersonajes = new Intent(this, Personajes.class);
        startActivity(intentPersonajes);
    }

    public void VentanaRanking(View view) {
        Intent intentRanking = new Intent(this, Ranking.class);
        startActivity(intentRanking);
    }

    public void VentanaJugadores(View view) {
        Intent intentJugadores = new Intent(this, Jugadores.class);
        startActivity(intentJugadores);
    }

    public void VentanaEscenarios(View view) {
        Intent intentEscenarios = new Intent(this, Escenarios.class);
        startActivity(intentEscenarios);
    }

    public void VentanaAcercaDe(View view) {
        Intent intentAcercaDe = new Intent(this, AcercaDe.class);
        startActivity(intentAcercaDe);
    }
}