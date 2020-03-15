/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.be;

import javafx.beans.property.*;

/**
 * @author pgn
 */
public class User {

    private final ReadOnlyIntegerWrapper idProperty;
    private final StringProperty nameProperty;
    private final ObjectProperty<Role> roleProperty;

    public User(int id, String name, Role role) {
        idProperty = new ReadOnlyIntegerWrapper(id);
        nameProperty = new SimpleStringProperty(name);
        roleProperty = new SimpleObjectProperty<Role>(role);
    }

    public String getName() {
        return nameProperty.get();
    }

    public void setName(String name) {
        nameProperty.setValue(name);
    }

    public StringProperty nameProperty() {
        return nameProperty;
    }

    public int getId() {
        return idProperty.get();
    }

    public ReadOnlyIntegerProperty idProperty() {
        return idProperty;
    }

    public Role getRole() {
        return roleProperty.get();
    }

    public ObjectProperty<Role> rolePropertyProperty() {
        return roleProperty;
    }

    /**
     * The role of a User. Defines access to areas of the application.
     */
    public enum Role {
        Student, Teacher
    }
}