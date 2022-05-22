package com.example.lab_4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch(item.getItemId())
       {
           case R.id.call:
               startActivity(new Intent(this, Phone.class));
               return true;



           case R.id.sms:
               startActivity(new Intent(this, Sms.class));
               return true;

           case R.id.web:
               startActivity(new Intent(this, Web.class));
               return true;
           default:
               return super.onOptionsItemSelected(item);
       }



    }
}