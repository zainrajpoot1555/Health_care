package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BuyMedicineActivity extends AppCompatActivity {

    private EditText editTextMedicineName;
    private EditText editTextQuantity;
    private EditText editTextDeliveryAddress;
    private Button buttonBuyMedicine;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_buy_medicine);

                editTextMedicineName = findViewById(R.id.editTextMedicineName);
                editTextQuantity = findViewById(R.id.editTextQuantity);
                editTextDeliveryAddress = findViewById(R.id.editTextDeliveryAddress);
                buttonBuyMedicine = findViewById(R.id.buttonBuyMedicine);

                buttonBuyMedicine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String medicineName = editTextMedicineName.getText().toString().trim();
                        String quantity = editTextQuantity.getText().toString().trim();
                        String deliveryAddress = editTextDeliveryAddress.getText().toString().trim();

                        if (medicineName.isEmpty() || quantity.isEmpty() || deliveryAddress.isEmpty()) {
                            Toast.makeText(BuyMedicineActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                        } else {
                            // Simulate buying medicine (in a real app, you would add the code to handle the purchase here)
                            Toast.makeText(BuyMedicineActivity.this, "Medicine purchased successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
