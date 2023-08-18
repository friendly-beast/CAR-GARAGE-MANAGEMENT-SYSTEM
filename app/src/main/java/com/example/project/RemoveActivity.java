package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RemoveActivity extends AppCompatActivity {
    Button btnRemove;

    private TableLayout tableLayoutDisplay;

    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        tableLayoutDisplay = findViewById(R.id.tableLayoutDisplay);

        String[][] customerDetails = AddActivity.getCustomerDetails();

        for (int i = 0; i < customerDetails.length; i++) {
            TableRow newRow = new TableRow(this);

            TextView tvCustomerName = createTextView(customerDetails[i][0], Gravity.CENTER);
            TextView tvPhoneNumber = createTextView(customerDetails[i][1], Gravity.CENTER);
            TextView tvCarName = createTextView(customerDetails[i][2], Gravity.CENTER);
            TextView tvCarNumber = createTextView(customerDetails[i][3], Gravity.CENTER);
            TextView Serviced = createTextView(customerDetails[i][4], Gravity.CENTER);

            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
            tvCustomerName.setLayoutParams(layoutParams);
            tvPhoneNumber.setLayoutParams(layoutParams);
            tvCarName.setLayoutParams(layoutParams);
            tvCarNumber.setLayoutParams(layoutParams);
            Serviced.setLayoutParams(layoutParams);

            newRow.addView(tvCustomerName);
            newRow.addView(tvPhoneNumber);
            newRow.addView(tvCarName);
            newRow.addView(tvCarNumber);
            newRow.addView(Serviced);

            // Create remove button for each row
            Button btnRemove = createRemoveButton(i);
            newRow.addView(btnRemove);

            tableLayoutDisplay.addView(newRow);
        }

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Homepage();
            }
        });
    }

    private TextView createTextView(String text, int gravity) {
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(16, 16, 16, 16);
        textView.setGravity(gravity);
        return textView;
    }

    private Button createRemoveButton(final int position) {
        Button button = new Button(this);
        button.setText("Remove");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCustomer(position);
            }
        });
        return button;
    }

    public void removeCustomer(int position) {
        AddActivity.removeCustomer(position);
        refreshTableLayout();
    }

    private void refreshTableLayout() {
        tableLayoutDisplay.removeAllViews();

        String[][] customerDetails = AddActivity.getCustomerDetails();

        for (int i = 0; i < customerDetails.length; i++) {
            TableRow newRow = new TableRow(this);

            TextView tvCustomerName = createTextView(customerDetails[i][0], Gravity.CENTER);
            TextView tvPhoneNumber = createTextView(customerDetails[i][1], Gravity.CENTER);
            TextView tvCarName = createTextView(customerDetails[i][2], Gravity.CENTER);
            TextView tvCarNumber = createTextView(customerDetails[i][3], Gravity.CENTER);
            TextView Serviced = createTextView(customerDetails[i][4], Gravity.CENTER);

            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
            tvCustomerName.setLayoutParams(layoutParams);
            tvPhoneNumber.setLayoutParams(layoutParams);
            tvCarName.setLayoutParams(layoutParams);
            tvCarNumber.setLayoutParams(layoutParams);
            Serviced.setLayoutParams(layoutParams);

            newRow.addView(tvCustomerName);
            newRow.addView(tvPhoneNumber);
            newRow.addView(tvCarName);
            newRow.addView(tvCarNumber);
            newRow.addView(Serviced);

            Button btnRemove = createRemoveButton(i);
            newRow.addView(btnRemove);

            tableLayoutDisplay.addView(newRow);
        }
    }

    private void Homepage(){
        Intent intent = new Intent(RemoveActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
