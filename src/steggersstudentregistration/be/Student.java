package steggersstudentregistration.be;

import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student
{

    private final StringProperty name;
    private final ReadOnlyIntegerWrapper id;

    public Student(int id, String name)
    {
        this.id = new ReadOnlyIntegerWrapper(id);
        this.name = new SimpleStringProperty(name);
    }

    public int getId()
    {
        return id.get();
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

    public ReadOnlyIntegerProperty idProperty()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "#" + id + ": " + name.getValue();
    }
    
}
