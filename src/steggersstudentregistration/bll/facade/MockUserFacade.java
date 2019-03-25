/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.facade;

import steggersstudentregistration.be.Student;
import steggersstudentregistration.be.User;
import steggersstudentregistration.bll.student.StudentManager;

/**
 *
 * @author pgn
 */
public class MockUserFacade implements IStundentRegistrationFacade
{

    private StudentManager studentManager;

    static
    {
        StudentRegistrationFacadeFactory.instance().registerFacade(StudentRegistrationFacadeFactory.StudentRegistrationFacadeTypes.MOCK, new MockUserFacade());
    }

    /**
     * Constructs the MockUserFacade that implements the facade.
     */
    private MockUserFacade()
    {
        studentManager = new StudentManager();
    }

    @Override
    public Student createStudent(String name)
    {
        return studentManager.createStudent(name);
    }

    @Override
    public void removeStudent(Student student)
    {
        System.out.println("Student removed...");
    }

    @Override
    public Student[] getAllStudents()
    {
        Student[] studs =
        {
            new Student(101, "Jeppe the Student"), new Student(102, "Silent Bob"), new Student(103, "Chatty Cat"), new Student(104, "Borris"), new Student(105, "Lil' Donald")
        };
        return studs;
    }

    @Override
    public User logIn(String userName, String password)
    {
        User user = new User(1, userName);
        return user;
    }

}
