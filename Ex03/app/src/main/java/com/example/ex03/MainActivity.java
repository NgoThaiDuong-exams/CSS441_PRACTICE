package com.example.ex03;

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

public class MainActivity extends AppCompatActivity {

    public Button btn_plus,btn_minus,btn_multiple,btn_divide;
    public EditText edtA,edtB,edtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        requestPermissions();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_plus=(Button) findViewById(R.id.tong);
        btn_minus=(Button) findViewById(R.id.hieu);
        btn_multiple=(Button) findViewById(R.id.nhan);
        btn_divide=(Button) findViewById(R.id.chia);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText(a+b+"");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText(a-b+"");
            }
        });

        btn_multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText(a*b+"");
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                if(b!=0){
                    DecimalFormat dcf = new DecimalFormat("0.###");
                    edtKQ.setText(dcf.format(a*1.0/b));
            }else {
                edtKQ.setText("error");
            }}
        });
    }
}