package com.example.logreg;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LOGGED extends AppCompatActivity{
    Button btn_Vissza;
    TextView tv_userKiir;
    DBaseHelper adatbazis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logged);

        init();
        StringBuilder builder = new StringBuilder();
        Cursor adatok = adatbazis.adatLekerdezes();
        builder.append(adatok.getString(5));
        tv_userKiir.setText(builder.toString());

        btn_Vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(LOGGED.this, MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });
    }

    private void init()
    {
        adatbazis = new DBaseHelper(LOGGED.this);
        btn_Vissza = findViewById(R.id.btnVissza);
        tv_userKiir = findViewById(R.id.tv_userName);
    }
}
