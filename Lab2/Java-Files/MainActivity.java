package com.example.lab_2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText myAge,myAddress,myUser, myPass;
    RadioGroup myRg;
    RadioButton myRbs;
    Spinner mySpin;
    DatePicker myDate;
    TextView myOutput;
    Button myButton;
    String[] states ={"AndraPradesh","Telangana","TamilNadu","Maharashtra"};
    String user, pass, address, age, gender, Details, state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myUser= findViewById(R.id.username);
        myPass= findViewById(R.id.password);
        myAddress= findViewById(R.id.address);
        myAge= findViewById(R.id.age);
        myRg= findViewById(R.id.radioGroup);
        myButton= findViewById(R.id.submit);
        myDate= findViewById(R.id.date);
        mySpin= findViewById(R.id.spin);
        myOutput= findViewById(R.id.output);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, states);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        mySpin.setAdapter(adapter);
        mySpin.setOnItemSelectedListener(this);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user =myUser.getText().toString();
                pass =myPass.getText().toString();
                address =myAddress.getText().toString();
                age =myAge.getText().toString();
                myRbs= findViewById(myRg.getCheckedRadioButtonId());
                gender =myRbs.getText().toString();
                int date=myDate.getDayOfMonth();
                int mon=myDate.getMonth();
                int yr=myDate.getYear();
                String d,m,y;
                d=Integer.toString(date);
                m=Integer.toString(mon);
                y=Integer.toString(yr);
                Details ="Username is : "+ user +"\n"+"Password is : "+ pass +"\n"+"Address is : "+ address +"\n"+"Age is : "+ age +"\n"+"Gender is: "+ gender +"\n"+"Date of Birth is : "+d+"-"+m+"-"+y+".\n"+"Sate is : "+ state +".";
                myOutput.setText(Details);
                myUser.setVisibility(View.INVISIBLE);
                myButton.setVisibility(View.INVISIBLE);
                myRbs.setVisibility(View.INVISIBLE);
                myRg.setVisibility(View.INVISIBLE);
                myPass.setVisibility(View.INVISIBLE);
                myAddress.setVisibility(View.INVISIBLE);
                myAge.setVisibility(View.INVISIBLE);
                myDate.setVisibility(View.INVISIBLE);
                mySpin.setVisibility(View.INVISIBLE);



            }
        });

    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        state =states[i];
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}