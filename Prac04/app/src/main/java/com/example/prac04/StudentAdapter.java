package com.example.prac04;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// StudentAdapter.java
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private List<Student> studentList;

    private  Context context;

    public StudentAdapter(Context context,List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_stat, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.bind(student);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentDetail.class);
//                intent.putExtra("student", student.getId());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTextView, majorTextView, gpaTextView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            majorTextView = itemView.findViewById(R.id.majorTextView);
            gpaTextView = itemView.findViewById(R.id.gpaTextView);
        }

        public void bind(Student student) {
            nameTextView.setText(student.getFullName());
            majorTextView.setText(student.getMajor());
            gpaTextView.setText(String.valueOf(student.getGpa()));
        }

        @Override
        public void onClick(View v) {
            OnNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener {
        static void onNoteClick(int position) {
            
        }
    }

}



