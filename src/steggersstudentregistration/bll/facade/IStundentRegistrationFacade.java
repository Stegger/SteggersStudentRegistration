/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.facade;

import steggersstudentregistration.be.Student;
import steggersstudentregistration.be.User;

/**
 *
 * @author pgn
 */
public interface IStundentRegistrationFacade
{
    Student createStudent(String name);

    public void removeStudent(Student student);

    public Student[] getAllStudents();

    public User logIn(String userName, String password);
}