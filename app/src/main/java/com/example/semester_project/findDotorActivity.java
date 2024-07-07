package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class findDotorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_dotor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findDotorActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        CardView fami = findViewById(R.id.cardFDFamilyPhysician);
        fami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findDotorActivity.this, DoctorDateilsActivity.class);
                intent.putExtra("title", "FamilyPhysicians");
                startActivity(intent);
            }
        });

        CardView dietician = findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findDotorActivity.this, DoctorDateilsActivity.class);
                intent.putExtra("title", "Dietician");
                startActivity(intent);
            }
        });

        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findDotorActivity.this, DoctorDateilsActivity.class);
                intent.putExtra("title", "Dentist");
                startActivity(intent);
            }
        });

        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findDotorActivity.this, DoctorDateilsActivity.class);
                intent.putExtra("title", "Surgeon");
                startActivity(intent);
            }
        });

        CardView cardiologists = findViewById(R.id.cardFDCarddiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(findDotorActivity.this, DoctorDateilsActivity.class);
                intent.putExtra("title", "Cardiologists");
                startActivity(intent);
            }
        });
    }}