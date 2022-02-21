package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText edName;
    EditText edEmail;
    EditText edApoge;
    EditText edAge;
    Button edit_button;
    Button delete_button;
    String id;
    Etudiant etudiant;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edName = findViewById(R.id.edName2);
        edEmail = findViewById(R.id.edEmail2);
        edApoge = findViewById(R.id.edApoge2);
        edAge = findViewById(R.id.edAge2);
        edit_button = findViewById(R.id.edit_button);
        delete_button = findViewById(R.id.delete_button);

        databaseHelper = new DatabaseHelper(UpdateActivity.this);

        edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = databaseHelper.updateStudent(getIntent().getStringExtra("id"), edName.getText().toString(), edEmail.getText().toString(), edApoge.getText().toString(), edAge.getText().toString());
                if (result == -1) {
                    Toast.makeText(UpdateActivity.this, "ERROR", Toast.LENGTH_LONG);
                }else {
                    Toast.makeText(UpdateActivity.this, "Successfully Updated", Toast.LENGTH_LONG);
                    Intent intent = new Intent(UpdateActivity.this, AllStudent.class);
                    startActivity(intent);
                }
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Modifier les infos d'un etudiant");

        getIntentData();
    }

    void getIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("email") && getIntent().hasExtra("Appoge") && getIntent().hasExtra("Age")) {
//            etudiant = new Etudiant(Integer.parseInt(getIntent().getStringExtra("id")), getIntent().getStringExtra("name"), getIntent().getStringExtra("email"), getIntent().getStringExtra("Appoge"), Integer.parseInt(getIntent().getStringExtra("Age")));
            id = getIntent().getStringExtra("id");
            edName.setText(getIntent().getStringExtra("name"));
            edEmail.setText(getIntent().getStringExtra("email"));
            edApoge.setText(getIntent().getStringExtra("Appoge"));
            edAge.setText(getIntent().getStringExtra("Age"));

        }else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }


    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Supprimer l'etudiant");
        builder.setMessage("Vous voulez vraiment supprimer l'etudiant ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                long result = databaseHelper.deleteEtudiant(id);
                if (result == -1) {
                    Toast.makeText(UpdateActivity.this, "ERROR", Toast.LENGTH_LONG);
                }else {
                    Toast.makeText(UpdateActivity.this, "Successfully Deleted", Toast.LENGTH_LONG);
                    Intent intent = new Intent(UpdateActivity.this, AllStudent.class);
                    startActivity(intent);
                }
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }
}