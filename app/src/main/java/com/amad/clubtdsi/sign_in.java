package com.amad.clubtdsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.amad.clubtdsi.Metiers.clubmetier;
import com.amad.clubtdsi.Models.personne;

public class sign_in extends AppCompatActivity {

    private EditText nom_complet, email, tel;
    private Button inscription;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        nom_complet = (EditText)findViewById(R.id.inscription_name);
        email = (EditText)findViewById(R.id.inscription_email);
        tel = (EditText)findViewById(R.id.inscription_tel);

        inscription = (Button)findViewById(R.id.inscription);

        spinner = (Spinner)findViewById(R.id.spinner);



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.list_atelier, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString() , Toast.LENGTH_SHORT).show();
                if (ajouter()){

                    Intent in = new Intent(getApplicationContext(), accueil.class);
                    startActivity(in);
                    finish();
                    Toast.makeText(getApplicationContext(), "Ajout bien effectué", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private boolean isEmailValid() {
        //TODO: Replace this with your own logic
        if (this.email.getText().toString().trim().contains("@")){
            return true;
        }
        email.setError("Email Incorrect !!!");
        return false;
    }

    public Boolean isChampValide(){
        if (nom_complet.getText().toString().trim().isEmpty() || tel.getText().toString().trim().isEmpty()){
            nom_complet.setError("Champ Obligatoire !!");
            tel.setError("Champ Obligatoire !!");
            return false;
        }

        return true;
    }


    public boolean ajouter(){

        if (!isEmailValid() || !isChampValide()){

            return false;
        }

        String id = clubmetier.myRefp.push().getKey();
        personne person = new personne(id, nom_complet.getText().toString(), email.getText().toString(), tel.getText().toString(), spinner.getSelectedItem().toString());
        clubmetier.myRefp.child(id).setValue(person);
        return true;
    }
}
