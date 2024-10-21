package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PhuongTrinhBacHai extends AppCompatActivity {

    private EditText editTextA, editTextB, editTextC;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phuong_trinh_bac_hai);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextC = findViewById(R.id.editTextC);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonContinue = findViewById(R.id.buttonContinue);
        Button buttonSolve = findViewById(R.id.buttonSolve);
        Button buttonExit = findViewById(R.id.buttonExit);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });

        buttonSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solveQuadraticEquation();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void clearInputs() {
        editTextA.setText("");
        editTextB.setText("");
        editTextC.setText("");
        textViewResult.setText("");
        editTextA.requestFocus();
    }

    private void solveQuadraticEquation() {
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());
        double c = Double.parseDouble(editTextC.getText().toString());

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            textViewResult.setText("Phương trình vô nghiệm");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            textViewResult.setText("Phương trình có nghiệm kép: x = " + x);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            textViewResult.setText("Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
        }
    }
}
