/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import steggersstudentregistration.be.Student;
import steggersstudentregistration.bll.facade.IStundentRegistrationFacade;

/**
 *
 * @author pgn
 */
public class MainModel
{

    /**
     * The facade exposing the combined functionality of the BLL.
     */
    private IStundentRegistrationFacade facade;

    /**
     * The list of all students known by the students.
     */
    private ObservableList<Student> students;

    /**
     * Main model constructor
     */
    public MainModel()
    {
        students = FXCollections.observableArrayList();
    }

    /**
     * Dependency injection method for the BLL facade.
     *
     * @param facade The facade to inject.
     */
    public void setStudentRegistrationFacade(IStundentRegistrationFacade facade)
    {
        this.facade = facade;
        students.addAll(facade.getAllStudents());
        String var = "It's almost 13:30 yay'";
    }

    /**
     * Gets the list of all students.
     *
     * @return
     */
    public ObservableList<Student> getStudents()
    {
        return students;
    }

    /**
     * Adds a student to the list of all students
     *
     * @param name Name of the student to add
     * @return The new Student object
     */
    public Student addStudent(String name)
    {
        Student student = facade.createStudent(name);
        students.add(student);
        return student;
    }

    /**
     * Removes a student from the list of all students
     *
     * @param student The student to remove
     */
    public void removeStudent(Student student)
    {
        facade.removeStudent(student);
        students.remove(student);
    }

}
