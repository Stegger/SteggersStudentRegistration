/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.dal.facade;

import steggersstudentregistration.be.Student;

/**
 *
 * @author pgn
 */
public interface IStudentRegistrationRepository
{
    Student createStudent(String name);
}
