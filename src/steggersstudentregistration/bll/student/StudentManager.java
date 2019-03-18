/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.student;

import steggersstudentregistration.be.Student;

/**
 *
 * @author pgn
 */
public class StudentManager
{

    private static int ID = 1;

    public Student createStudent(String name)
    {
        Student student = new Student(ID, name);
        incrementID();
        return student;
    }

    /**
     * Increments the static student ID.
     */
    public static void incrementID()
    {
        ID++;
    }
    
}
