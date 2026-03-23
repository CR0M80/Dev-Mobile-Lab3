package com.example.formulaire;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Récupération des données envoyées par MainActivity
        String nom       = getIntent().getStringExtra("nom");
        String email     = getIntent().getStringExtra("email");
        String telephone = getIntent().getStringExtra("telephone");
        String adresse   = getIntent().getStringExtra("adresse");
        String ville     = getIntent().getStringExtra("ville");

        // Affichage dans les TextView
        ((TextView) findViewById(R.id.tv_nom))      .setText("Nom       : " + nom);
        ((TextView) findViewById(R.id.tv_email))    .setText("E-mail    : " + email);
        ((TextView) findViewById(R.id.tv_telephone)).setText("Tél       : " + telephone);
        ((TextView) findViewById(R.id.tv_adresse))  .setText("Adresse   : " + adresse);
        ((TextView) findViewById(R.id.tv_ville))    .setText("Ville     : " + ville);

        // Retour à l'écran précédent et fermeture de cet écran
        findViewById(R.id.btn_retour).setOnClickListener(v -> finish());
    }
}