/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.dal.facade;

import steggersstudentregistration.be.User;

/**
 * @author pgn
 */
public interface IUserRepository {

    User createUser(String name, String email, String hashedPassword, User.Role role);

    User[] getAllUsersByRole(User.Role role);

    User logIn(String email, String hashedPassword);

}