/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.facade;

import steggersstudentregistration.be.Student;
import steggersstudentregistration.bll.student.StudentManager;

/**
 *
 * @author pgn
 */
public class MockUserFacade implements IStundentRegistrationFacade
{

    private static IStundentRegistrationFacade INSTANCE;

    private StudentManager studentManager;

    /**
     * Constructs the MockUserFacade that implements the facade.
     */
    private MockUserFacade()
    {
        studentManager = new StudentManager();
    }

    /**
     * Singleton accessor/creater method...
     *
     * @return
     */
    public static synchronized IStundentRegistrationFacade getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new MockUserFacade();
        }
        return INSTANCE;
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
    
}