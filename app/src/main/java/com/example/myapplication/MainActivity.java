package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnEtudiants, btnFilieres, btnModules, btnBulletins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEtudiants = findViewById(R.id.btnEtudiants);
        btnFilieres = findViewById(R.id.btnFilieres);
        btnModules = findViewById(R.id.btnModules);
        btnBulletins = findViewById(R.id.btnBulletins);

        btnEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllStudent.class);
                startActivity(intent);
            }
        });

        btnFilieres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnModules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnBulletins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Gestion de Scolarite");
    }
}