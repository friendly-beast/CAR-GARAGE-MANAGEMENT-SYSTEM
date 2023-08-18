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

public class AddActivity extends AppCompatActivity {
    private EditText etCustomerName, etPhoneNumber, etCarName, etCarNumber;
    private Button btnAddCustomer, btnDisplay, btnRemove,btnHome;
    private TableLayout tableLayout;
    private Spinner spinnerServiced;

    private static List<Customer> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etCustomerName = findViewById(R.id.etCustomerName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etCarName = findViewById(R.id.etCarName);
        etCarNumber = findViewById(R.id.etCarNumber);
        spinnerServiced = findViewById(R.id.spinnerServiced);


        btnAddCustomer = findViewById(R.id.btnAddCustomer);
        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCustomer();
            }
        });

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Homepage();
            }
        });
        // Initialize the Spinner with options
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Serviced", "Not Serviced"});
        spinnerServiced.setAdapter(spinnerAdapter);


        customerList = new ArrayList<>();

    }

    private void addCustomer() {
        String customerName = etCustomerName.getText().toString();
        String phoneNumber = etPhoneNumber.getText().toString();
        String carName = etCarName.getText().toString();
        String carNumber = etCarNumber.getText().toString();
        String servicedOption = spinnerServiced.getSelectedItem().toString();


        if (customerName.isEmpty() || phoneNumber.isEmpty() || carName.isEmpty() || carNumber.isEmpty()) {
            return;
        }

        Customer customer = new Customer(customerName, phoneNumber, carName, carNumber, servicedOption);
        customerList.add(customer);

        // Clear the input fields
        etCustomerName.setText("");
        etPhoneNumber.setText("");
        etCarName.setText("");
        etCarNumber.setText("");

    }

    private void Homepage(){
        Intent intent = new Intent(AddActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public static String[][] getCustomerDetails() {
        String[][] customerDetails = new String[customerList.size()][5];

        for (int i = 0; i < customerList.size(); i++) {
            Customer customer = customerList.get(i);
            customerDetails[i][0] = customer.getCustomerName();
            customerDetails[i][1] = customer.getPhoneNumber();
            customerDetails[i][2] = customer.getCarName();
            customerDetails[i][3] = customer.getCarNumber();
            customerDetails[i][4] = customer.getServiced();
        }

        return customerDetails;
    }

    public static void removeCustomer(int position) {
        if (position >= 0 && position < customerList.size()) {
            customerList.remove(position);
        }
    }



    public class Customer {
        private String customerName;
        private String phoneNumber;
        private String carName;
        private String carNumber;

        private String serviced;


        public Customer(String customerName, String phoneNumber, String carName, String carNumber, String serviced) {
            this.customerName = customerName;
            this.phoneNumber = phoneNumber;
            this.carName = carName;
            this.carNumber = carNumber;
            this.serviced = serviced;
        }

        public String getCustomerName() {
            return customerName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getCarName() {
            return carName;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public String getServiced() {
            return serviced;
        }


    }
}