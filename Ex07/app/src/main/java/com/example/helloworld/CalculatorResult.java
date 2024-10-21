package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex07.R;

import java.text.DecimalFormat;

public class CalculatorResult extends AppCompatActivity {

    public Button btn_back;
    public TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator_result);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_result = findViewById(R.id.txt_result);
        Intent myIntent2 = getIntent();
        Bundle resultbundle = myIntent2.getBundleExtra("gia_tri");

        int a = resultbundle.getInt("a");
        int b = resultbundle.getInt("b");

        String kq ="";
        if(a==0&&b==0){
            kq = "vo so nghiem";
        }
        else if(a==0 && b!=0){
            kq = "vo nghiem";
        }
        else
        {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = dcf.format(-b*1.0/a);
        }
        txt_result.setText(kq);

        btn_back = (Button) findViewById(R.id.btn_Back);
        btn_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
//                Intent myIntent = new Intent(CalculatorResult.this,MainActivity.class);
//                startActivity(myIntent);
            finish();
            }
        });
    }
}