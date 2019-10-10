package com.example.projectgljovans;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity2 extends AppCompatActivity {
    Spinner nameSpinner,nameSpinner2;
    EditText editTextQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        nameSpinner = findViewById(R.id.nameSpinner);
        nameSpinner2 = findViewById(R.id.nameSpinner2);
        editTextQuantity = findViewById(R.id.editTextQuantity);


        final String[] itemsSpinner1 = new String[]{"Sraf", "Ekser", "Navoj"};

        final Integer[] sraf = new Integer[]{33,40,46};
        final Integer[] ekser = new Integer[]{7,10,13};
        final Integer[] navoj = new Integer[]{700,800,900};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsSpinner1);
        nameSpinner.setAdapter(adapter);

        nameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelect = itemsSpinner1[position];
                if(position==0){
                    ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item,sraf);
                    nameSpinner2.setAdapter(adapter1);
                }
                if(position==1){
                    ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item,ekser);
                    nameSpinner2.setAdapter(adapter1);
                }
                if(position==2){
                    ArrayAdapter<Integer> adapter1 = new ArrayAdapter<>(Activity2.this, android.R.layout.simple_spinner_dropdown_item,navoj);
                    nameSpinner2.setAdapter(adapter1);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
