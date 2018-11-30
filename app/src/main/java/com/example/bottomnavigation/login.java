package com.example.bottomnavigation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fw = getSupportFragmentManager();
        fw.beginTransaction().replace(R.id.escenario, new  SesionFragment()).commit();


    }

}
