package com.example.demo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty age;

    Person(String fName, String lName, Integer age) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.age = new SimpleIntegerProperty(age);
    }

    public final StringProperty firstNameProperty() {
        return this.firstName;
    }

    public final java.lang.String getFirstName() {
        return this.firstNameProperty().get();
    }

    public final void setFirstName(final java.lang.String firstName) {
        this.firstNameProperty().set(firstName);
    }

    public final StringProperty lastNameProperty() {
        return this.lastName;
    }

    public final java.lang.String getLastName() {
        return this.lastNameProperty().get();
    }

    public final void setLastName(final java.lang.String lastName) {
        this.lastNameProperty().set(lastName);
    }

    public final IntegerProperty ageProperty() {
        return this.age;
    }

    public final int getAge() {
        return this.ageProperty().get();
    }

    public final void setAge(final int age) {
        this.ageProperty().set(age);
    }

}
