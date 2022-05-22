package com.example.lab_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Sms extends AppCompatActivity {
    EditText myNumber,myMsg;
    ImageButton myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        myNumber=findViewById(R.id.phNo);
        myMsg=findViewById(R.id.msg);
        myButton=findViewById(R.id.send);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Sms.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
                {
                 sendMessage();
                }
                else
                {
                    ActivityCompat.requestPermissions(Sms.this,new String[] {Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }

    private void sendMessage() {
        String ePhno = myNumber.getText().toString().trim();
        String eMsg = myMsg.getText().toString().trim();
        if(ePhno.length()>0 && eMsg.length()>0)
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(ePhno,null,eMsg,null,null);
            Toast.makeText(this, "SMS sent Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Enter Phone number and Message", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            sendMessage();
        }
        else
        {
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }

    }
}