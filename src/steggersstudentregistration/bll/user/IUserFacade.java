/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steggersstudentregistration.bll.user;

import steggersstudentregistration.be.User;

/**
 * @author pgn
 */
public interface IUserFacade {
    /**
     * Creates a new user with the given name, email and password. Method will encrypt password before sending to the database.
     *
     * @param name     Name of the user
     * @param email    Users email
     * @param password Users unencrypted password.
     * @return The newly created User object.
     */
    User createUser(String name, String email, String password, User.Role role);

    /**
     * Removes the given User from the system.
     *
     * @param user
     */
    void removeUser(User user);

    /**
     * Get an array of all users in the system.
     *
     * @return
     */
    User[] getAllUsers();

    /**
     * Gets all users by a specific role.
     *
     * @return
     */
    User[] getAllUsers(User.Role role);

    /**
     * Login a user with the given credentials.
     *
     * @param userName The user name.
     * @param password The unencrypted password.
     * @return The logged in User.
     */
    User logIn(String userName, String password);
}