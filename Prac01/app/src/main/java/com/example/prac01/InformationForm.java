package com.example.prac01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InformationForm extends AppCompatActivity {

    public Button btn_submit;
    public EditText edt_name,edt_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_information_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_submit = (Button) findViewById(R.id.btn_MoveToResult);
        edt_name = findViewById(R.id.edt_name);
        edt_score = findViewById(R.id.edt_gpa);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                Bundle information = new Bundle();
                String name = edt_name.getText().toString();
                String gpa = edt_score.getText().toString();
                information.putString("name", name);
                information.putString("gpa",gpa);
                returnIntent.putExtra("information",information);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });

    }
}
