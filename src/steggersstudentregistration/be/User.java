/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.be;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pgn
 */
public class User
{

    private final ReadOnlyIntegerWrapper id;
    private final StringProperty name = new SimpleStringProperty();
    
    
    public User(int id, String name)
    {
        this.id = new ReadOnlyIntegerWrapper(id);
        this.name.setValue(name);
    }
    
    public String getName()
    {
        return name.get();
    }

    public void setName(String value)
    {
        name.set(value);
    }

    public StringProperty nameProperty()
    {
        return name;
    }
    
    public int getId()
    {
        return id.get();
    }

    public ReadOnlyIntegerProperty idProperty()
    {
        return id;
    }

}
