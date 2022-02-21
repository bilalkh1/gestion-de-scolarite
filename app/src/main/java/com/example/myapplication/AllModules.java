package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AllModules extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton btn_add;

    DatabaseHelper databaseHelper;
    ModuleAdapter moduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_modules);

        recyclerView = findViewById(R.id.recyclerView);
        btn_add = findViewById(R.id.btn_add);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllModules.this, AddModule.class);
                startActivity(intent);
            }
        });

        List<Module> modules = databaseHelper.getModulesList();

        if (modules.size() > 0) {
            System.out.println("HEEERE");
            moduleAdapter = new ModuleAdapter(modules, AllModules.this);
            recyclerView.setAdapter(moduleAdapter);
        }else {
            Toast.makeText(this, "There is no modules in database", Toast.LENGTH_SHORT);
        }

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Tous Les Modules");
    }
}