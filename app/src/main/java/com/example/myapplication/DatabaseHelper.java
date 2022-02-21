package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gestion_scolarite";
    private static final String TABLE_NAME_ETUDIANTS = "ETUDIANT";
    private static final String TABLE_NAME_FILIERES = "FILIERE";
    private static final String TABLE_NAME_MODULES = "MODULES";

    private SQLiteDatabase sqLiteDatabase;

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String MODULE_NAME = "name";
    public static final String TITLE = "title";
    public static final String EMAIL = "email";
    public static final String APPOGE = "appoge";
    public static final String AGE = "age";
    public static final String NIVEAU = "niveau";
    public static final String FILIERE = "filiere_id";
    public static final String LEVEL = "niveau";

    // creating etudiant table
    private static final String CREATE_TABLE_Etudiants = "create table " + TABLE_NAME_ETUDIANTS + "(" + ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL, " + APPOGE + " TEXT NOT NULL, " + AGE + " INTEGER NOT NULL" + ")";

    // creating filiere table
    private static final String CREATE_TABLE_Filieres = "create table " + TABLE_NAME_FILIERES + "(" + ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " TEXT NOT NULL)";

    // creating modules table
    private static final String CREATE_TABLE_MODULES = "create table " +
            TABLE_NAME_MODULES + "(" + ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT NOT NULL, " +
            NIVEAU + " INTEGER NOT NULL)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_Etudiants);
        sqLiteDatabase.execSQL(CREATE_TABLE_Filieres);
        sqLiteDatabase.execSQL(CREATE_TABLE_MODULES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ETUDIANTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FILIERES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MODULES);
        onCreate(sqLiteDatabase);
    }

    // add etudiant
    public void addEtudiant(Etudiant etudiant) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, etudiant.getName());
        contentValues.put(DatabaseHelper.EMAIL, etudiant.getEmail());
        contentValues.put(DatabaseHelper.APPOGE, etudiant.getAppoge());
        contentValues.put(DatabaseHelper.AGE, etudiant.getAge());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME_ETUDIANTS, null, contentValues);
    }

    // recuperer la list des etudiants
    public List<Etudiant> getStudentsList() {
        String sql = "SELECT * FROM " + TABLE_NAME_ETUDIANTS;

        sqLiteDatabase = this.getReadableDatabase();
        List<Etudiant> storeEtudiant = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id=  Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String appoge = cursor.getString(3);
                int age = Integer.parseInt(cursor.getString(4));
//                int level = Integer.parseInt(cursor.getString(5));
                storeEtudiant.add(new Etudiant(id, name, email, appoge, age));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeEtudiant;
    }

    long updateStudent(String id, String name, String email, String appoge, String age) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(EMAIL, email);
        cv.put(APPOGE, appoge);
        cv.put(AGE, age);

        long result = sqLiteDatabase.update(TABLE_NAME_ETUDIANTS, cv, "id=?", new String[]{id});
        return result;
    }

    long deleteEtudiant(String id) {
        sqLiteDatabase = this.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_NAME_ETUDIANTS, "id=?", new String[]{id});
        return result;
    }

    // Add Module
    public void addModule(Module module) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, module.getName());
        contentValues.put(DatabaseHelper.NIVEAU, module.getNiveau());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME_MODULES, null, contentValues);
    }

    // recuperer la list des modules
    public List<Module> getModulesList() {
        String sql = "SELECT * FROM " + TABLE_NAME_MODULES;

        sqLiteDatabase = this.getReadableDatabase();
        List<Module> storeModule = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id=  Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                int niveau = Integer.parseInt(cursor.getString(2));

                storeModule.add(new Module(id, name, niveau));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeModule;
    }

    // Update module
    long updateModule(String id, String name, String niveau) {
        sqLiteDatabase = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NAME, name);
        cv.put(NIVEAU, niveau);

        long result = sqLiteDatabase.update(TABLE_NAME_MODULES, cv, "id=?", new String[]{id});
        return result;
    }

    // delete Module
    long deleteModule(String id) {
        sqLiteDatabase = this.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_NAME_MODULES, "id=?", new String[]{id});
        return result;
    }

}
