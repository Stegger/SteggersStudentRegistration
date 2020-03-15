package steggersstudentregistration.bll.user;

import steggersstudentregistration.be.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserManager implements IUserFacade {

    private int mockId = 0;
    private List<User> allUsers;

    public MockUserManager() {
        allUsers = new ArrayList<>();
        allUsers.add(createUser("Stegger", "pgn@easv.dk", "PASSWORD", User.Role.Teacher));
        allUsers.add(createUser("Bilbo Baggins", "bb@easv365.dk", "ASSWORD", User.Role.Student));
        allUsers.add(createUser("Frodo Baggins", "fb@easv365.dk", "SASSWORD", User.Role.Student));
        allUsers.add(createUser("Samwise \"Sam\" Gamgee", "ssg@easv365.dk", "PASSDROW", User.Role.Student));
        allUsers.add(createUser("Meriadoc \"Merry\" Brandybuck", "mmb@easv365.dk", "SAPWORDS", User.Role.Student));
        allUsers.add(createUser("Peregrin \"Pippin\" Took", "ppt@easv365.dk", "SWORDASS", User.Role.Student));
        allUsers.add(createUser("Gandalf", "gandalf@easv.dk", "THAU-SHALL-NOT-PASSWORD", User.Role.Teacher));
    }

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
        User u = new User(++mockId, name, User.Role.Student);
        allUsers.add(u);
        return u;
    }

    /**
     * Removes the given User from the system.
     *
     * @param user
     */
    @Override
    public void removeUser(User user) {
        allUsers.remove(user);
    }

    /**
     * Get an array of all users in the system.
     *
     * @return
     */
    @Override
    public User[] getAllUsers() {
        return (User[]) allUsers.toArray();
    }

    /**
     * Gets all users by a specific role.
     *
     * @param role
     * @return
     */
    @Override
    public User[] getAllUsers(User.Role role) {
        return null;
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
        for (User user : allUsers) {
            if (user.getName().equals(userName))
                return user;
        }
        throw new UserNotFoundException("Could not find the user with the given credentials");
    }
}
