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

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder>{
    List<Module> modules;
    Context context;
    DatabaseHelper databaseHelper;

    public ModuleAdapter(List<Module> modules, Context context) {
        this.modules = modules;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ModuleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.module_row, parent, false);
        ModuleAdapter.ViewHolder viewHolder = new ModuleAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Module module = modules.get(position);
        holder.module_id.setText(Integer.toString(module.getId()));
        holder.module_name.setText(module.getName());
        holder.niveau.setText(module.getNiveau());
        holder.mainModuleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(module.getId()));
                intent.putExtra("name", module.getName());
                intent.putExtra("niveau", String.valueOf(module.getNiveau()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView module_id, module_name, niveau;
        ConstraintLayout mainModuleLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            module_id = itemView.findViewById(R.id.student_id);
            module_name = itemView.findViewById(R.id.student_name);
            niveau = itemView.findViewById(R.id.niveau);
            mainModuleLayout = itemView.findViewById(R.id.mainModuleLayout);
        }
    }
}
