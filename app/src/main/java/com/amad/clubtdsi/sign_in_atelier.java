package com.amad.clubtdsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amad.clubtdsi.Metiers.clubmetier;
import com.amad.clubtdsi.Models.Atelier;

public class sign_in_atelier extends AppCompatActivity {

    private EditText sujet, presentateur, heure, lieu;
    private Button valider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_atelier);

        sujet = (EditText)findViewById(R.id.atelier_name);
        presentateur = (EditText)findViewById(R.id.atelier_presentateur);
        lieu = (EditText)findViewById(R.id.atelier_lieu);

        heure = (EditText)findViewById(R.id.atelier_heure);

        valider = (Button)findViewById(R.id.inscription_atelier);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ajouter()){
                    Intent in = new Intent(getApplicationContext(), accueil.class);
                    startActivity(in);
                    finish();

                    Toast.makeText(getApplicationContext(), "Ajout bien effectué", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public Boolean isChampValide(){
        if (sujet.getText().toString().trim().isEmpty() || presentateur.getText().toString().trim().isEmpty()){
            sujet.setError("Champ Obligatoire !!");
            presentateur.setError("Champ Obligatoire !!");
            return false;
        }

        return true;
    }


    public boolean ajouter(){

        if (!isChampValide()){

            return false;
        }

        String id = clubmetier.myRefa.push().getKey();
        Atelier atelier = new Atelier(id, sujet.getText().toString(), presentateur.getText().toString(), lieu.getText().toString(),  heure.getText().toString());
        clubmetier.myRefa.child(id).setValue(atelier);
        return true;
    }
}
