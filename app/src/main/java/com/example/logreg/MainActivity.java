package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button regisztracio, bejelentkezes;
    EditText felhasznalo, password;
    DBaseHelper adatbazis;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regActivity = new Intent(MainActivity.this, register.class);
                startActivity(regActivity);
                finish();
            }
        });
        bejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adat();
            }
        });
    }
    private void init() {
        bejelentkezes = findViewById(R.id.bejelentkezes);
        regisztracio = findViewById(R.id.regisztracio);
        felhasznalo = findViewById(R.id.felhasznalo);
        password = findViewById(R.id.password);
        adatbazis = new DBaseHelper(MainActivity.this);
        sharedPref = getSharedPreferences("adatok", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }
    private void adat() {

        String nev = felhasznalo.getText().toString().trim();
        String jelszo = password.getText().toString().trim();


        Cursor adatok = adatbazis.adat();

        if (nev.isEmpty() || jelszo.isEmpty()){
            Toast.makeText(this, "HIBA, üresen hagyott mezők!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            editor.putString("nev",nev);
            editor.putString("jelszo",jelszo);
            editor.commit();
            Intent logActivity = new Intent(MainActivity.this, LOGGED.class);
            startActivity(logActivity);
            finish();
        }
    }

}