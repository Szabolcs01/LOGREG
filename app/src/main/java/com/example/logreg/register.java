package com.example.logreg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    Button regisztracioelkuldese, isszabejelentkezeshez;
    EditText re_email, re_felhasznaloNev, re_jelszo, re_teljesNev;
    DBaseHelper adatbazis;

    private void init() {
        isszabejelentkezeshez = findViewById(R.id.isszabejelentkezeshez);
        regisztracioelkuldese = findViewById(R.id.regisztracioelkuldese);
        re_email = findViewById(R.id.re_email);
        re_felhasznaloNev = findViewById(R.id.re_felhasznaloNev);
        re_jelszo = findViewById(R.id.re_password);
        re_teljesNev = findViewById(R.id.re_teljesNev);
        adatbazis = new DBaseHelper(register.this);
    }
    private void regisztració() {

        String email = re_email.getText().toString().trim();
        String nev = re_felhasznaloNev.getText().toString().trim();
        String jelszo = re_jelszo.getText().toString().trim();
        String teljesNev = re_teljesNev.getText().toString().trim();



        if (nev.isEmpty() || jelszo.isEmpty() || email.isEmpty() || teljesNev.isEmpty()){
            Toast.makeText(this, "Nem irtbe semmit!", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (adatbazis.emailEllenorzes(email)){
            Toast.makeText(this, "Van már ilyen felhasználó", Toast.LENGTH_SHORT).show();
            return;
        }
        else{

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        init();
        regisztració();
        isszabejelentkezeshez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(register.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

}
