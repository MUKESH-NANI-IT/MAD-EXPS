package com.example.lab_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Phone extends AppCompatActivity {

    private static final int REQUEST_CALL=1;
    private EditText myNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        myNumber=findViewById(R.id.number);
        ImageButton myCaller = findViewById(R.id.ring);
        myCaller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall();
            }
        });
    }
    private void makePhoneCall()
    {
        String number = myNumber.getText().toString().trim();
        if(number.length()>0)
        {
            if(ContextCompat.checkSelfPermission(Phone.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Phone.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }
            else
            {
                String dail = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dail)));
            }
        }
        else
        {
            Toast.makeText(Phone.this, "Enter Phone NUmber ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==REQUEST_CALL)
        {
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                makePhoneCall();
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}