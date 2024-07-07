package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LabTest extends AppCompatActivity {


    private EditText editTextPatientName;
        private EditText editTextPatientAge;
        private EditText editTextTestName;
        private EditText editTextDate;
        private Spinner spinnerTestType;
        private Spinner spinnerLabLocation;
        private Button buttonSubmit;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lab_test);

            editTextPatientName = findViewById(R.id.editTextPatientName);
            editTextPatientAge = findViewById(R.id.editTextPatientAge);
            editTextTestName = findViewById(R.id.editTextTestName);
            editTextDate = findViewById(R.id.editTextDate);
            spinnerTestType = findViewById(R.id.spinnerTestType);
            spinnerLabLocation = findViewById(R.id.spinnerLabLocation);
            buttonSubmit = findViewById(R.id.buttonSubmit);

            buttonSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    submitLabTestDetails();
                }
            });
        }

        private void submitLabTestDetails() {
            String patientName = editTextPatientName.getText().toString();
            String patientAge = editTextPatientAge.getText().toString();
            String testName = editTextTestName.getText().toString();
            String date = editTextDate.getText().toString();
            String testType = spinnerTestType.getSelectedItem().toString();
            String labLocation = spinnerLabLocation.getSelectedItem().toString();

            if (patientName.isEmpty() || patientAge.isEmpty() || testName.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(LabTest.this, LabTestSummaryActivity.class);
                intent.putExtra("patientName", patientName);
                intent.putExtra("patientAge", patientAge);
                intent.putExtra("testName", testName);
                intent.putExtra("date", date);
                intent.putExtra("testType", testType);
                intent.putExtra("labLocation", labLocation);
                startActivity(intent);
            }
        }
    }