package com.example.myapplication;

public class Etudiant {

    private int id;
    private String name;
    private String email;
    private String appoge;
    private int age;
    private int level;

    public Etudiant(String name, String email, String appoge, int age, int level) {
        this.name = name;
        this.email = email;
        this.appoge = appoge;
        this.age = age;
        this.level = level;
    }

    public Etudiant(String name, String email, String appoge, int age) {
        this.name = name;
        this.email = email;
        this.appoge = appoge;
        this.age = age;
        this.level = level;
    }

    public Etudiant(int id, String name, String email, String appoge, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.appoge = appoge;
        this.age = age;
        this.level = level;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Etudiant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppoge() {
        return appoge;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAppoge(String appoge) {
        this.appoge = appoge;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
