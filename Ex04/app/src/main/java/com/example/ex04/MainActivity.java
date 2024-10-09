package com.example.ex04;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFahrenheit;
    private EditText editTextCelsius;
    private Button buttonConvertToCelsius;
    private Button buttonConvertToFahrenheit;
    private Button buttonClear,buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextFahrenheit = findViewById(R.id.edtFahrenheit);
        editTextCelsius = findViewById(R.id.edtCelsius);
        buttonConvertToCelsius = findViewById(R.id.btnFC);
        buttonConvertToFahrenheit = findViewById(R.id.btnCF);
        buttonClear = findViewById(R.id.btnClear);
        buttonNext = findViewById(R.id.btnNext);
        buttonConvertToCelsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitString = editTextFahrenheit.getText().toString();
                if (!fahrenheitString.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitString);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    editTextCelsius.setText(String.valueOf(celsius));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a Fahrenheit value", Toast.LENGTH_SHORT).show();
                }
            }
    });
        buttonConvertToFahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusString = editTextCelsius.getText().toString();
                if (!celsiusString.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusString);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    editTextFahrenheit.setText(String.valueOf(fahrenheit));
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a Celsius value", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextFahrenheit.setText("");
                editTextCelsius.setText("");
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,BMI_Activity.class);
                startActivity(i);
            }
        });
    }
}

