package com.example.prac04;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AddStudent extends AppCompatActivity {
    private EditText etStudentId, etFullName, etBirthDate, etAddress, etEmail, etMajor;
    private RadioGroup rgGender;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etStudentId = findViewById(R.id.etStudentId);
        etFullName = findViewById(R.id.etFullName);
        etBirthDate = findViewById(R.id.etBirthDate);
        etAddress = findViewById(R.id.etAddress);
        etEmail = findViewById(R.id.etEmail);
        etMajor = findViewById(R.id.etMajor);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etStudentId.getText().toString();
                String fullName = etFullName.getText().toString();
                String birthDate = etBirthDate.getText().toString();
                String address = etAddress.getText().toString();
                String email = etEmail.getText().toString();
                String major = etMajor.getText().toString();
                String gender = ((RadioButton) findViewById(rgGender.getCheckedRadioButtonId())).getText().toString();

                Student newStudent = new Student(id, fullName, birthDate, address, email, major, gender,0,2022);

                // Đọc dữ liệu JSON hiện tại
                String jsonData = loadJSONFromAsset();
                Gson gson = new Gson();
                Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
                List<Student> studentList = gson.fromJson(jsonData, studentListType);

                // Thêm sinh viên mới vào danh sách
                studentList.add(newStudent);

                // Ghi lại dữ liệu JSON
                String updatedJsonData = gson.toJson(studentList);
                saveJSONToAsset(updatedJsonData);
                finish();
            }
        });
    }

    @Nullable
    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("student.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void saveJSONToAsset(@NonNull String jsonString) {
        try {
            FileOutputStream fos = openFileOutput("student.json", Context.MODE_PRIVATE);
            fos.write(jsonString.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}