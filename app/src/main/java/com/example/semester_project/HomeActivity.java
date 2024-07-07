package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button menuButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        menuButton = findViewById(R.id.menuButton);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        Toast.makeText(getApplicationContext(), "Well Come", Toast.LENGTH_SHORT).show();

        //
        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, findDotorActivity.class);
                startActivity(intent);
            }
        });

        CardView Buymedicin = findViewById(R.id.cardBuyMedicine);
        Buymedicin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BuyMedicineActivity.class);
                startActivity(intent);
            }
        });

        CardView Orderdetaile = findViewById(R.id.cardOrderDetails);
        Orderdetaile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, OrderDetailActivity.class);
                startActivity(intent);
            }
        });
        CardView TabTeast = findViewById(R.id.cardLabTest);
        TabTeast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LabTest.class);
                startActivity(intent);
            }
        });
        CardView HealthDis = findViewById(R.id.cardHealthArticle);
        HealthDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, Health_Article.class);
                startActivity(intent);
            }
        });
        menuButton = findViewById(R.id.menuButton);
    }

        public void showMenu(View view) {
            PopupMenu popup = new PopupMenu(HomeActivity.this, menuButton);
            popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());

            // Set a listener for menu item clicks
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_lab_test:
                            startActivity(new Intent(HomeActivity.this, LabTest.class));
                            return true;
                        case R.id.menu_buy_medicine:
                            startActivity(new Intent(HomeActivity.this, BuyMedicineActivity.class));
                            return true;
                        case R.id.menu_find_doctor:
                            startActivity(new Intent(HomeActivity.this, findDotorActivity.class));
                            return true;
                        case R.id.menu_health_article:
                            startActivity(new Intent(HomeActivity.this, Health_Article.class));
                            return true;
                        case R.id.menu_order_details:
                            startActivity(new Intent(HomeActivity.this, OrderDetailActivity.class));
                            return true;
                        case R.id.menu_logout:
                            finish(); // Close the app or logout
                            return true;
                        default:
                            return false;
                    }
                }
            });

            popup.show();
    }
}