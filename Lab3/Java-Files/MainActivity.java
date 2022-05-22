package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //Creating button variables
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialising Button with R file using Id's.
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Fragment_1());
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Fragment_2());
                b1.setVisibility(View.INVISIBLE);
                b2.setVisibility(View.INVISIBLE);
            }
        });
    }
    // creating method : when user clicks on the button moves on to the fragment.
    private void changeFragment(Fragment fragment){
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.constraint,fragment);
        ft.commit();
    }
}