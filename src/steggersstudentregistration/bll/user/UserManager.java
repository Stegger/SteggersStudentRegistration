package steggersstudentregistration.bll.user;

import steggersstudentregistration.be.User;

public class UserManager implements IUserFacade {

    /**
     * Creates a new user with the given name, email and password. Method will encrypt password before sending to the database.
     *
     * @param name     Name of the user
     * @param email    Users email
     * @param password Users unencrypted password.
     * @return The newly created User object.
     */
    @Override
    public User createUser(String name, String email, String password, User.Role role) {
        return null;
    }

    /**
     * Removes the given User from the system.
     *
     * @param user
     */
    @Override
    public void removeUser(User user) {

    }

    /**
     * Get an array of all users in the system.
     *
     * @return
     */
    @Override
    public User[] getAllUsers() {
        return new User[0];
    }

    /**
     * Gets all users by a specific role.
     *
     * @param role
     * @return
     */
    @Override
    public User[] getAllUsers(User.Role role) {
        return new User[0];
    }

    /**
     * Login a user with the given credentials.
     *
     * @param userName The user name.
     * @param password The unencrypted password.
     * @return The logged in User.
     */
    @Override
    public User logIn(String userName, String password) {
        return null;
    }
}
