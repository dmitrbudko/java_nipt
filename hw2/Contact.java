package edu.phystech.hw2;

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    public static final String UNKNOWN_EMAIL = "Unknown";

    private String username;
    private String email;

    public Contact(String username, String email) throws InvalidContactFieldException {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidContactFieldException("username");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new InvalidContactFieldException("email");
        }
        this.username = username;
        this.email = email;
    }

    public Contact(String username) {
        this.username = username;
        this.email = UNKNOWN_EMAIL;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    @Override
    public int compareTo(Contact other) {
        return this.username.compareTo(other.username);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(username, contact.username) && Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, email);
    }
}
