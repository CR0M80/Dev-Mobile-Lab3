package com.example.formulaire;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etNom       = findViewById(R.id.et_nom);
        EditText etEmail     = findViewById(R.id.et_email);
        EditText etTelephone = findViewById(R.id.et_telephone);
        EditText etAdresse   = findViewById(R.id.et_adresse);
        EditText etVille     = findViewById(R.id.et_ville);
        Button   btnEnvoyer  = findViewById(R.id.btn_envoyer);

        btnEnvoyer.setOnClickListener(v -> {

            String nom       = etNom.getText().toString().trim();
            String email     = etEmail.getText().toString().trim();
            String telephone = etTelephone.getText().toString().trim();
            String adresse   = etAdresse.getText().toString().trim();
            String ville     = etVille.getText().toString().trim();

            // Validation : aucun champ vide
            if (nom.isEmpty() || email.isEmpty() || telephone.isEmpty()
                    || adresse.isEmpty() || ville.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validation e-mail basique
            if (!email.contains("@")) {
                Toast.makeText(this, "E-mail invalide", Toast.LENGTH_SHORT).show();
                return;
            }

            // Intent explicite vers RecapActivity
            Intent intent = new Intent(this, Screen2Activity.class);
            intent.putExtra("nom",       nom);
            intent.putExtra("email",     email);
            intent.putExtra("telephone", telephone);
            intent.putExtra("adresse",   adresse);
            intent.putExtra("ville",     ville);
            startActivity(intent);
        });
    }
}