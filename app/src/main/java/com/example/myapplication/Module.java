package com.example.myapplication;

public class Module {
    private int id;
    private String name;
    private int niveau;

    public Module(int id, String name, int niveau) {
        this.id = id;
        this.name = name;
        this.niveau = niveau;
    }

    public Module() {
        this.name = "";
        this.id = 1;
        this.niveau = 1;
    }

    public Module(String name, int niveau) {
        this.name = name;
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
