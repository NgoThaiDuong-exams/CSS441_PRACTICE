package com.example.prac02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Staff> staffList = new ArrayList<>();
    private LinearLayout staffListView;
    private TextView noResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText staffId = findViewById(R.id.staffId);
        EditText fullName = findViewById(R.id.fullName);
        EditText birthDate = findViewById(R.id.birthDate);
        EditText salary = findViewById(R.id.salary);
        Button addStaffButton = findViewById(R.id.addStaffButton);

        staffListView = findViewById(R.id.staffList);
        noResultText = findViewById(R.id.noResultText);

        addStaffButton.setOnClickListener(view -> {
            String id = staffId.getText().toString();
            String name = fullName.getText().toString();
            String date = birthDate.getText().toString();
            String salaryStr = salary.getText().toString();

            if (id.isEmpty() || name.isEmpty() || date.isEmpty() || salaryStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Staff newStaff = new Staff(id, name, date, salaryStr);
                staffList.add(newStaff);
                displayStaff();
            }
        });
    }

    private void displayStaff() {
        staffListView.removeAllViews();
        for (Staff staff : staffList) {
            TextView staffDetails = new TextView(this);
            staffDetails.setText(staff.getId() + "-" + staff.getFullName() + "-" + staff.getBirthDate() + "-" + staff.getSalary());
            staffListView.addView(staffDetails);
        }

        if (staffList.isEmpty()) {
            noResultText.setVisibility(View.VISIBLE);
        } else {
            noResultText.setVisibility(View.GONE);
        }
    }
}