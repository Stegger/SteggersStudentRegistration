package steggersstudentregistration.bll.user;

import org.junit.jupiter.api.Test;
import steggersstudentregistration.be.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MockUserManagerTest {

    @Test
    void testCreateUser() {
        //Arranging the test:
        MockUserManager instance = new MockUserManager();
        String name = "Jeppe";
        String email = "jml@easv.dk";
        String password = "PASSWORD";
        User.Role role = User.Role.Teacher;

        //Acting out the test:
        User user = instance.createUser(name, email, password, role);

        //Assert the result:
        assertEquals(name, user.getName(), "User name not the same as provided");
        assertEquals(role, user.getRole(), "User role not the same as provided");
    }

    @Test
    void testRemoveUser() {
        //Arranging:
        MockUserManager instance = new MockUserManager();
        instance.createUser("Peter", "pgn@easv.dk", "ASSWORD", User.Role.Teacher);
        instance.createUser("Jeppe", "jml@easv.dk", "PASSWORD", User.Role.Teacher);
        User target = instance.createUser("Henrik", "hk@easv.dk", "SWORD", User.Role.Teacher);

        //Act
        instance.removeUser(target);

        //Assert
        List<User> users = instance.getAllUsers();
        assertFalse(users.contains(target), "User model still contains deleted user");
    }

    @Test
    void testGetAllUsers() {
    }

    @Test
    void testGetAllUsers1() {
    }
}