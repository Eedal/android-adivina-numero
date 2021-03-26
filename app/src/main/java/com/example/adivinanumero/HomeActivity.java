package com.example.adivinanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    TextView number;
    Button tryAgain;
    Integer intentos;
    Integer intentosAux;
    Integer numberObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        number = findViewById(R.id.number);
        tryAgain = findViewById(R.id.tryAgain);
        tryAgain.setOnClickListener(this);
        numberObject = (int) ((Math.random() * (100 - 0)) + 0);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        intentosAux = Integer.parseInt(parent.getItemAtPosition(position).toString());
        intentos = intentosAux;
        //Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tryAgain:
                if(!number.getText().toString().isEmpty()) {
                    intentos--;
                    if(intentos != 0) {
                        Log.d("intento", intentos.toString());
                        if (Integer.parseInt(number.getText().toString()) > numberObject) {
                            Toast.makeText(getApplicationContext(), "menos", Toast.LENGTH_LONG).show();

                        } else if (Integer.parseInt(number.getText().toString()) < numberObject) {
                            Toast.makeText(getApplicationContext(), "mayor", Toast.LENGTH_LONG).show();


                        } else {
                            Toast.makeText(getApplicationContext(), "ganaste", Toast.LENGTH_LONG).show();


                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "el numero era " + numberObject, Toast.LENGTH_LONG).show();
                        numberObject = (int) ((Math.random() * (100 - 0)) + 0);
                        intentos = intentosAux;


                    }
                }else{
                    Toast.makeText(getApplicationContext(), "ingresa un numero", Toast.LENGTH_LONG).show();
                }






                number.setText("") ;

                break;
        }
    }
}