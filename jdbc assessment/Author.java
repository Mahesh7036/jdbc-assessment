package com.dxc.assessment.dao;

public class Author {

    private int id;

    private String first_Name;

    private String last_Name;

    private String genre;

    private String email;

    public Author() {}

    public Author(int id, String first_Name, String last_Name, String genre, String email) {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.genre = genre;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public String getFirst_Name() {
        return first_Name;
    }
    public String getLast_Name() {
        return last_Name;
    }
    public String getGenre() {
        return genre;
    }
    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Author [email=%s, first_Name=%s, genre=%s, id=%s, last_Name=%s]", email,
                first_Name, genre, id, last_Name);
    }


}