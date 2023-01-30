package com.example.healthapp;

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

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor Name : Rusak Ilya", "Hospital Address : Minsk", "Exp : 5yrs", "Mobile No: 9898989898", "200"},
            {"Doctor Name : Test Peter", "Hospital Address : Grodno", "Exp : 4yrs", "Mobile No: 9797979797", "100"},
            {"Doctor Name : Poms Alex", "Hospital Address : Minsk", "Exp : 7yrs", "Mobile No: 9696969696", "250"},
            {"Doctor Name : Grib Alex", "Hospital Address : Brest", "Exp : 3yrs", "Mobile No: 9595959595", "150"},
            {"Doctor Name : Osmu Ivan", "Hospital Address : Minsk", "Exp : 2yrs", "Mobile No: 9494949494", "120"},
    };
    private String[][] doctor_details2 = {
            {"Doctor Name : Rusak Vasya", "Hospital Address : Minsk", "Exp : 5yrs", "Mobile No: 1212121212", "180"},
            {"Doctor Name : Test John", "Hospital Address : Grodno", "Exp : 4yrs", "Mobile No: 1313131313", "100"},
            {"Doctor Name : Poms Alex", "Hospital Address : Brest", "Exp : 5yrs", "Mobile No: 141414141414", "220"},
            {"Doctor Name : Grib Alex", "Hospital Address : Minsk", "Exp : 6yrs", "Mobile No: 151515151515", "150"},
            {"Doctor Name : Osmu Ivan", "Hospital Address : Minsk", "Exp : 2yrs", "Mobile No: 161616161616", "130"},
    };
    private String[][] doctor_details3 = {
            {"Doctor Name : Rusak Law", "Hospital Address : Minsk", "Exp : 3yrs", "Mobile No: 212121212121", "190"},
            {"Doctor Name : Test Ben", "Hospital Address : Grodno", "Exp : 4yrs", "Mobile No: 232323232323", "170"},
            {"Doctor Name : Poms Alex", "Hospital Address : Minsk", "Exp : 7yrs", "Mobile No: 24242424242424", "220"},
            {"Doctor Name : Grib Alex", "Hospital Address : Minsk", "Exp : 3yrs", "Mobile No: 25252525252525", "110"},
            {"Doctor Name : Osmu Ivan", "Hospital Address : Minsk", "Exp : 6yrs", "Mobile No: 26262626262626", "130"},
    };
    private String[][] doctor_details4 = {
            {"Doctor Name : Saint Ilya", "Hospital Address : Minsk", "Exp : 5yrs", "Mobile No: 3131313133131", "195"},
            {"Doctor Name : Nico Robin", "Hospital Address : Grodno", "Exp : 6yrs", "Mobile No: 3232323232332", "124"},
            {"Doctor Name : Poms Alex", "Hospital Address : Minsk", "Exp : 7yrs", "Mobile No: 9696969696", "146"},
            {"Doctor Name : Drakull Mihawk", "Hospital Address : Minsk", "Exp : 3yrs", "Mobile No: 9595959595", "580"},
            {"Doctor Name : Osmu Ivan", "Hospital Address : Minsk", "Exp : 8yrs", "Mobile No: 9494949494", "250"},
    };
    private String[][] doctor_details5 = {
            {"Doctor Name : Nico Olivia", "Hospital Address : Minsk", "Exp : 8yrs", "Mobile No: 9898989898", "540"},
            {"Doctor Name : Gol D. Ace", "Hospital Address : Grodno", "Exp : 4yrs", "Mobile No: 9797979797", "140"},
            {"Doctor Name : Roronoa Zoro", "Hospital Address : Minsk", "Exp : 5yrs", "Mobile No: 9696969696", "570"},
            {"Doctor Name : Grib Alex", "Hospital Address : Minsk", "Exp : 2yrs", "Mobile No: 9595959595", "220"},
            {"Doctor Name : Boa Hancock", "Hospital Address : Minsk", "Exp : 2yrs", "Mobile No: 9494949494", "120"},
    };


    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i< doctor_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}