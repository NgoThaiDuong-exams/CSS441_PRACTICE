package com.example.prac04;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentDetail extends AppCompatActivity {
    private TextView tvStudentId, tvFullName, tvBirthDate, tvAddress, tvEmail, tvMajor, tvGpa;
    private Button btnEdit, btnDelete;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        tvStudentId = findViewById(R.id.tvStudentId);
        tvFullName = findViewById(R.id.tvFullName);
        tvBirthDate = findViewById(R.id.tvBirthDate);
        tvAddress = findViewById(R.id.tvAddress);
        tvEmail = findViewById(R.id.tvEmail);
        tvMajor = findViewById(R.id.tvMajor);
        tvGpa = findViewById(R.id.tvGpa);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);

        // Nhận dữ liệu sinh viên từ Intent
        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra("student");

        // Hiển thị thông tin sinh viên
        tvStudentId.setText("Mã SV: " + student.getId());
        tvFullName.setText("Họ và Tên: " + student.getFullName());
        tvBirthDate.setText("Ngày sinh: " + student.getBirthDate());
        tvAddress.setText("Địa chỉ: " + student.getAddress());
        tvEmail.setText("Email: " + student.getEmail());
        tvMajor.setText("Chuyên ngành: " + student.getMajor());
        tvGpa.setText("Điểm TB tích lũy: " + student.getGpa());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến màn hình chỉnh sửa thông tin sinh viên
                Intent editIntent = new Intent(StudentDetail.this, MainActivity.class);
                editIntent.putExtra("student", (CharSequence) student);
                startActivity(editIntent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa sinh viên khỏi danh sách
                deleteStudent(student);
            }
        });
    }

    private void deleteStudent(Student student) {
        // Đọc dữ liệu JSON hiện tại
        String jsonData = loadJSONFromInternalStorage();
        Gson gson = new Gson();
        Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
        List<Student> studentList = gson.fromJson(jsonData, studentListType);

        // Xóa sinh viên khỏi danh sách
        studentList.remove(student);

        // Ghi lại dữ liệu JSON
        String updatedJsonData = gson.toJson(studentList);
        saveJSONToInternalStorage(updatedJsonData);

        // Quay lại màn hình chính
        finish();
    }

    private String loadJSONFromInternalStorage() {
        String json = null;
        try {
            FileInputStream fis = openFileInput("student.json");
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void saveJSONToInternalStorage(String jsonString) {
        try {
            FileOutputStream fos = openFileOutput("student.json", Context.MODE_PRIVATE);
            fos.write(jsonString.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
