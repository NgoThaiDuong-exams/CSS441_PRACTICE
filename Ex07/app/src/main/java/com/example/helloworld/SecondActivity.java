 package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private Button btn_click,btn_cal;
    private EditText input_a,input_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_click = (Button) findViewById(R.id.btn_BackToMain);
        btn_click.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"Open Second",Toast.LENGTH_SHORT);
                Intent myIntent1 = new Intent(SecondActivity.this,MainActivity.class);

                startActivity(myIntent1);
            }
    });
        input_a = findViewById(R.id.input_a);
        input_b = findViewById(R.id.input_b);

        btn_cal=(Button) findViewById(R.id.btn_cal);
        btn_cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this,"Open Second",Toast.LENGTH_SHORT);
                Intent myIntent = new Intent(SecondActivity.this,CalculatorResult.class);

                Bundle number = new Bundle();
                int a = Integer.parseInt(input_a.getText()+"");
                int b = Integer.parseInt(input_b.getText()+"");
                number.putInt("a",a);
                number.putInt("b",b);
                myIntent.putExtra("gia_tri",number);
                startActivity(myIntent);
            }
        });
}
}