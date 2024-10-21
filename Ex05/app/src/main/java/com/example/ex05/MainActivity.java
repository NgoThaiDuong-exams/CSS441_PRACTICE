package com.example.ex05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextYear;
    private TextView textViewLunarYear;

    private String[] canArray = {"Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ"};
    private String[] chiArray = {"Thân", "Dậu", "Tuất", "Hợi", "Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextYear = findViewById(R.id.editTextYear);
        textViewLunarYear = findViewById(R.id.textViewLunarYear);
        Button buttonConvert = findViewById(R.id.buttonConvert);
        Button buttonNext = findViewById(R.id.buttonNext);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,PhuongTrinhBacHai.class);
                startActivity(i);
            }
        });

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yearStr = editTextYear.getText().toString();
                if (!yearStr.isEmpty()) {
                    int year = Integer.parseInt(yearStr);
                    String can = canArray[year % 10];
                    String chi = chiArray[year % 12];
                    textViewLunarYear.setText(can + " " + chi);
                }
            }
        });
    }
}