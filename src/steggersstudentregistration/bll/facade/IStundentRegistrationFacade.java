/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.facade;

import steggersstudentregistration.be.Student;

/**
 *
 * @author pgn
 */
public interface IStundentRegistrationFacade
{
    Student createStudent(String name);

    public void removeStudent(Student student);

    public Student[] getAllStudents();
}