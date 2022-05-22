package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Web extends AppCompatActivity {
    EditText myInput;
    ImageButton go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        myInput = findViewById(R.id.input);
        go = findViewById(R.id.Search);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Url = myInput.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(Url));
                startActivity(i);
            }
        });
    }
}