package com.example.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Firstexp_b extends AppCompatActivity {
    Button myButton;
    EditText myInput;
    TextView myOutput;
    ConstraintLayout myLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = findViewById(R.id.print);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myInput = findViewById(R.id.input);
                myOutput= findViewById(R.id.output);
                myLayout= findViewById(R.id.C_layout);
                myLayout.setBackgroundResource(R.color.pink_lavender);
                myOutput.setText("Hello " + myInput.getText().toString()+"!");
                myInput.setVisibility(View.INVISIBLE);
                myButton.setVisibility(View.INVISIBLE);
            }
        });

    }
}