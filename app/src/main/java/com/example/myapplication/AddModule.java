package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddModule extends AppCompatActivity {
    EditText edName;
    EditText edlevel;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);

        edName = findViewById(R.id.edName);
        edlevel = findViewById(R.id.edlevel);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello World");
                String name = edName.getText().toString();
                Integer level = Integer.parseInt(edlevel.getText().toString());



                if (name.length() <= 0 || level == null) {
                    Toast.makeText(AddModule.this, "Enter all data", Toast.LENGTH_LONG);
                }else {
                    System.out.print("NOOOO");
                    Module module = new Module(name, level);
                    System.out.println(module.getName());
                    DatabaseHelper databaseHelper = new DatabaseHelper(AddModule.this);
                    databaseHelper.addModule(module);
                    Toast.makeText(AddModule.this, "Add Module Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }
}