package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    EditText edName;
    EditText edEmail;
    EditText edApoge;
    EditText edAge;
    EditText edlevel;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edApoge = findViewById(R.id.edApoge);
        edAge = findViewById(R.id.edAge);
        edlevel = findViewById(R.id.edlevel);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello World");
                String name = edName.getText().toString();
                String email = edEmail.getText().toString();
                String appoge = edApoge.getText().toString();
                Integer age = Integer.parseInt(edAge.getText().toString());
//                Integer level = Integer.parseInt(edlevel.getText().toString());
                System.out.println(name);
                System.out.println(email);
                System.out.println(appoge);
                System.out.println(age);
                System.out.println(name.length() <= 0 || email.length() <= 0 || appoge.length() <= 0 || age != null);



                if (name.length() <= 0 || email.length() <= 0 || appoge.length() <= 0 || age == null) {
                    Toast.makeText(AddStudent.this, "Enter all data", Toast.LENGTH_LONG);
                }else {
                    System.out.print("NOOOO");
                    Etudiant etudiant = new Etudiant(name, email, appoge, age);
                    System.out.println(etudiant.getName());
                    DatabaseHelper databaseHelper = new DatabaseHelper(AddStudent.this);
                    databaseHelper.addEtudiant(etudiant);
                    Toast.makeText(AddStudent.this, "Add Student Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Ajouter un etudiant");

    }
}