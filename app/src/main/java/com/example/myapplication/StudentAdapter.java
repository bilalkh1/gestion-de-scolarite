package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    List<Etudiant> etudiants;
    Context context;
    DatabaseHelper databaseHelper;

    public StudentAdapter(List<Etudiant> etudiants, Context context) {
        this.etudiants = etudiants;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position) {
        final Etudiant etudiant = etudiants.get(position);
        holder.student_id.setText(Integer.toString(etudiant.getId()));
        holder.student_name.setText(etudiant.getName());
        holder.email.setText(etudiant.getEmail());
        holder.level.setText(Integer.toString(etudiant.getAge()));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(etudiant.getId()));
                intent.putExtra("name", etudiant.getName());
                intent.putExtra("email", etudiant.getEmail());
                intent.putExtra("Appoge", String.valueOf(etudiant.getAppoge()));
                intent.putExtra("Age", String.valueOf(etudiant.getAge()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return etudiants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView student_id, student_name, email, level;
        ConstraintLayout mainLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            student_id = itemView.findViewById(R.id.student_id);
            student_name = itemView.findViewById(R.id.student_name);
            email = itemView.findViewById(R.id.email);
            level = itemView.findViewById(R.id.level);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
