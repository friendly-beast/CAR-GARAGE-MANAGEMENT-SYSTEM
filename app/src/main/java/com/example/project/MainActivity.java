package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etCustomerName, etPhoneNumber, etCarName, etCarNumber;
    private Button btnAddCustomer, btnDisplay, btnRemove;
    private TableLayout tableLayout;
    private Spinner spinnerServiced;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnAddCustomer = findViewById(R.id.btnAddCustomer);
        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomer();
            }
        });

        btnDisplay = findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCustomers();
            }
        });

        btnRemove = findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveCustomers();
            }
        });





    }

    private void addCustomer() {
        Intent intent = new Intent(MainActivity.this, AddActivity.class);
        startActivity(intent);

    }

    private void displayCustomers() {
        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
        startActivity(intent);
    }



    private void RemoveCustomers() {
        Intent intent = new Intent(MainActivity.this, RemoveActivity.class);
        startActivity(intent);
    }




}






