package com.example.semester_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public  class DoctorDateilsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name: Habib","Hospital Address: Rwp","Experience: 5 years","Mobile No: 0346768368", "1000"},
                    {"Doctor Name: Zain","Hospital Address: Rwp","Experience: 10 years","Mobile No: 0346768360", "1500"},
                    {"Doctor Name: Saad","Hospital Address: Rwp","Experience: 15 years","Mobile No: 0346768388", "2000"},
                    {"Doctor Name: Abubakar","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346368368", "2500"},
                    {"Doctor Name: Hammad","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346728368", "3000"}
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name: Habib","Hospital Address: Rwp","Experience: 5 years","Mobile No: 0346768368", "1000"},
                    {"Doctor Name: Zain","Hospital Address: Rwp","Experience: 10 years","Mobile No: 0346768360", "1500"},
                    {"Doctor Name: Saad","Hospital Address: Rwp","Experience: 15 years","Mobile No: 0346768388", "2000"},
                    {"Doctor Name: Abubakar","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346368368", "2500"},
                    {"Doctor Name: Hammad","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346728368", "3000"}
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name: Habib","Hospital Address: Rwp","Experience: 5 years","Mobile No: 0346768368", "1000"},
                    {"Doctor Name: Zain","Hospital Address: Rwp","Experience: 10 years","Mobile No: 0346768360", "1500"},
                    {"Doctor Name: Saad","Hospital Address: Rwp","Experience: 15 years","Mobile No: 0346768388", "2000"},
                    {"Doctor Name: Abubakar","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346368368", "2500"},
                    {"Doctor Name: Hammad","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346728368", "3000"}
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name: Habib","Hospital Address: Rwp","Experience: 5 years","Mobile No: 0346768368", "1000"},
                    {"Doctor Name: Zain","Hospital Address: Rwp","Experience: 10 years","Mobile No: 0346768360", "1500"},
                    {"Doctor Name: Saad","Hospital Address: Rwp","Experience: 15 years","Mobile No: 0346768388", "2000"},
                    {"Doctor Name: Abubakar","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346368368", "2500"},
                    {"Doctor Name: Hammad","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346728368", "3000"}
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name: Habib","Hospital Address: Rwp","Experience: 5 years","Mobile No: 0346768368", "1000"},
                    {"Doctor Name: Zain","Hospital Address: Rwp","Experience: 10 years","Mobile No: 0346768360", "1500"},
                    {"Doctor Name: Saad","Hospital Address: Rwp","Experience: 15 years","Mobile No: 0346768388", "2000"},
                    {"Doctor Name: Abubakar","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346368368", "2500"},
                    {"Doctor Name: Hammad","Hospital Address: Rwp","Experience: 25 years","Mobile No: 0346728368", "3000"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dateils);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        switch (title) {
            case "FamilyPhysicians":
                doctor_details = doctor_details1;
                break;
            case "Dietician":
                doctor_details = doctor_details2;
                break;
            case "Dentist":
                doctor_details = doctor_details3;
                break;
            case "Surgeon":
                doctor_details = doctor_details4;
                break;
            case "Cardiologists":
                doctor_details = doctor_details5;
                break;
            default:
                doctor_details = new String[][]{};
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorDateilsActivity.this, findDotorActivity.class);
                startActivity(intent);
            }
        });

        list = new ArrayList<>();
        for (String[] details : doctor_details) {
            item = new HashMap<>();
            item.put("line1", details[0]);
            item.put("line2", details[1]);
            item.put("line3", details[2]);
            item.put("line4", details[3]);
            item.put("line5", "Cons Fees: " + details[4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(DoctorDateilsActivity.this,BookAppointmentActivity.class);

                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }}