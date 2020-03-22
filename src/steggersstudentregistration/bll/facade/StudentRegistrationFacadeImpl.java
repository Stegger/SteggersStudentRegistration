package steggersstudentregistration.bll.facade;

import steggersstudentregistration.be.User;
import steggersstudentregistration.bll.security.ISecurityManager;
import steggersstudentregistration.bll.security.SecurityManager;
import steggersstudentregistration.bll.user.IUserFacade;

import java.util.List;

public class StudentRegistrationFacadeImpl implements IStudentRegistrationFacade {

    private IUserFacade userSystem;
    private ISecurityManager securitySystem;

    public StudentRegistrationFacadeImpl(IUserFacade userFacade) {
        this.userSystem = userFacade;
        securitySystem = new SecurityManager();
    }

    /**
     * Creates a new user with the given name, email and password. Method will encrypt password before sending to the database.
     *
     * @param name     Name of the user
     * @param email    Users email
     * @param password Users unencrypted password.
     * @param role
     * @return The newly created User object.
     */
    @Override
    public User createUser(String name, String email, String password, User.Role role) {
        return userSystem.createUser(name, email, password, role);
    }

    /**
     * Removes the given User from the system.
     *
     * @param user
     */
    @Override
    public void removeUser(User user) {
        userSystem.removeUser(user);
    }

    /**
     * Get an array of all users in the system.
     *
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return userSystem.getAllUsers();
    }

    /**
     * Gets all users by a specific role.
     *
     * @param role
     * @return
     */
    @Override
    public User[] getAllUsers(User.Role role) {
        return userSystem.getAllUsers(role);
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
        return userSystem.logIn(userName, password);
    }

    @Override
    public String hashPassword(String password) {
        return securitySystem.hashPassword(password);
    }
}
