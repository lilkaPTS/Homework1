package com.company.other;

import java.util.Objects;

public class Author {
    private String name;
    private String email;
    private Gender gender;

    public Author(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Author[name=%s, email=%s, gender=%s]", name,email,gender.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) && email.equals(author.email) && gender == author.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, gender);
    }
}
