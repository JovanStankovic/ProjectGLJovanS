package com.example.projectgljovans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userNameTextView,passwordTextView;
    Button loginButton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameTextView = findViewById(R.id.userNameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);
        loginButton = findViewById(R.id.loginButton);
        db = new DatabaseHelper(this);

        db.insertData();
        db.insertData1();
        db.insertData2();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameTextView.getText().toString().toLowerCase();
                String password = passwordTextView.getText().toString().toLowerCase();
                Boolean checkUserNamePass = db.checkUserNamePass(userName, password);
                if (checkUserNamePass) {
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                    openActivity2();
                } else
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}
