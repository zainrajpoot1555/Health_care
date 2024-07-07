package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle; import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LabTestSummaryActivity extends AppCompatActivity {
    private TextView textViewSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_summary);

        textViewSummary = findViewById(R.id.textViewSummary);

        // Retrieve data from the Intent
        String patientName = getIntent().getStringExtra("patientName");
        String patientAge = getIntent().getStringExtra("patientAge");
        String testName = getIntent().getStringExtra("testName");
        String date = getIntent().getStringExtra("date");
        String testType = getIntent().getStringExtra("testType");
        String labLocation = getIntent().getStringExtra("labLocation");

        // Display the summary
        String summary = "Patient Name: " + patientName + "\n" +
                "Patient Age: " + patientAge + "\n" +
                "Test Name: " + testName + "\n" +
                "Date: " + date + "\n" +
                "Test Type: " + testType + "\n" +
                "Lab Location: " + labLocation;

        textViewSummary.setText(summary);
    }
}

