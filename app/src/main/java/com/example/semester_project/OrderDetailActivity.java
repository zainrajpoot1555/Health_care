package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
public class OrderDetailActivity extends AppCompatActivity {

            private EditText editTextMedicineName;
            private EditText editTextQuantity;
            private EditText editTextDeliveryAddress;
            private Button buttonPlaceOrder;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_order_detail);

                editTextMedicineName = findViewById(R.id.editTextMedicineName);
                editTextQuantity = findViewById(R.id.editTextQuantity);
                editTextDeliveryAddress = findViewById(R.id.editTextDeliveryAddress);
                buttonPlaceOrder = findViewById(R.id.buttonPlaceOrder);

                buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar calendar = Calendar.getInstance();
                        int hour = calendar.get(Calendar.HOUR_OF_DAY);

                        if (hour >= 8 && hour < 23) {
                            String medicineName = editTextMedicineName.getText().toString().trim();
                            String quantity = editTextQuantity.getText().toString().trim();
                            String deliveryAddress = editTextDeliveryAddress.getText().toString().trim();

                            if (medicineName.isEmpty() || quantity.isEmpty() || deliveryAddress.isEmpty()) {
                                Toast.makeText(OrderDetailActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                            } else {
                                // Simulate placing the order (in a real app, you would add the code to handle the order here)
                                Toast.makeText(OrderDetailActivity.this, "Order placed successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(OrderDetailActivity.this, "Orders can only be placed between 8 AM and 11 PM", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
