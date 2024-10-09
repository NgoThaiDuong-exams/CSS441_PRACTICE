package com.example.ex04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class BMI_Activity extends AppCompatActivity {

    Button btnChandoan;
    EditText editTen, editChieucao, editCannang, editBMI, editChandoan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        btnChandoan = findViewById(R.id.btnCalculate);
        editTen = findViewById(R.id.edtName);
        editChieucao = findViewById(R.id.edtHeight);
        editCannang = findViewById(R.id.edtWeight);
        editBMI = findViewById(R.id.edtBMI);
        editChandoan = findViewById(R.id.edtDiagnose);

        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.0");
                try {
                    double chieucao = Double.parseDouble(editChieucao.getText().toString());
                    double cannang = Double.parseDouble(editCannang.getText().toString());
                    double bmi = cannang / Math.pow(chieucao / 100, 2);
                    String chandoan = "";
                    if (bmi < 18)
                        chandoan = "Bạn gầy";
                    else if (bmi <= 24.9)
                        chandoan = "Bạn bình thường";
                    else if (bmi <= 29.9)
                        chandoan = "Bạn béo phì độ I";
                    else if (bmi <= 34.9)
                        chandoan = "Bạn béo phì độ II";
                    else
                        chandoan = "Bạn béo phì độ III";
                    editBMI.setText(dcf.format(bmi));
                    editChandoan.setText(chandoan);
                } catch (Exception e) {
                    finish();
                }
            }
        });


    }
}