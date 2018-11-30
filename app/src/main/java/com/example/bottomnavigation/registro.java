package com.example.bottomnavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class registro extends AppCompatActivity {

    TextView link_to_login;
    Button btnRegister;
    EditText uss;

    String User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().hide();

        link_to_login = (TextView) findViewById(R.id.link_to_login);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        uss = (EditText) findViewById(R.id.uss);

        link_to_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }});

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


            }});



    }
}
