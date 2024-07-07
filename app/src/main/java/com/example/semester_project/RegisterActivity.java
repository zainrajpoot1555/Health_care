package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTexAppFullName);
        edEmail = findViewById(R.id.editTextAppAddress);
        edPassword = findViewById(R.id.editTextAppContactNumber);
        edConfirm = findViewById(R.id.editTextAppFee);
        btn = findViewById(R.id.buttonBookAppointment);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       String username = edUsername.getText().toString();
                                       String email = edEmail.getText().toString();
                                       String password = edPassword.getText().toString();
                                       String confirm = edConfirm.getText().toString();

                                       if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                                           Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
                                       } else if (!password.equals(confirm)) {
                                           Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                                       } else {
                                           Database db = new Database(getApplicationContext());
                                           db.register(username, email, password);
                                           Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                                           Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                           startActivity(intent);
                                       }
                                   }
        });
    }
}








//                                   public void onClick(View v) {
//                                       String username = edUsername.getText().toString();
//                                       String email = edEmail.getText().toString();
//                                       String password = edPassword.getText().toString();
//                                       String confirm = edConfirm.getText().toString();
//                                       Database db = new Database(getApplicationContext());
//                                       db.register(username, email, password);
//
//




//                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
//                    Toast.makeText(getApplicationContext(), "Please fill all the details", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (password.equals(confirm)) {
//                        if (isValid(password)) {
//                            db.register(username, email, password);
//                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters with letters, digits, and special symbols", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Password and confirm password do not match", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//    }

//    public static boolean isValid(String password) {
//        int f1 = 0, f2 = 0, f3 = 0;
//        if (password.length() < 8) {
//            return false;
//        } else {
//            for (int p = 0; p < password.length(); p++) {
//                if (Character.isLetter(password.charAt(p))) {
//                    f1 = 1;
//                }
//            }
//            for (int r = 0; r < password.length(); r++) {
//                if (Character.isDigit(password.charAt(r))) {
//                    f2 = 1;
//                }
//            }
//            for (int s = 0; s < password.length(); s++) {
//                char c = password.charAt(s);
//                if ((c >= 33 && c <= 46) || c == 64) {
//                    f3 = 1;
//                }
//            }
//            return f1 == 1 && f2 == 1 && f3 == 1;
//        }
//
//    }
