package com.example.lab_3;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment_1 extends Fragment {
    View view;
    Button myButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflating is the process of adding a view (.xml) to activity on runtime

        view= inflater.inflate(R.layout.fragment_1, container, false);
        myButton = (Button) view.findViewById(R.id.Home);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Explicit Intent: intent to start a component in your own app, because you know the class name of the activity or service you want to start.
                Intent in = new Intent(getActivity(),MainActivity.class);
                startActivity(in);
            }
        });
        return  view;
    }
}