package ku.cs.models;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList userList;

    @BeforeEach
    void init() {
        userList = new UserList();
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        userList.addUser("Sarun", "00000000");
        userList.addUser("b", "12345678");
        userList.addUser("c", "password");

        // TODO: find one of them
        assertNotNull(userList.findUserByUsername("c"));

        // TODO: assert that UserList found User
         String expected = "Sarun";
         String actual = userList.findUserByUsername("Sarun").getUsername();
         assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // Add 3 users to UserList
        userList.addUser("a", "1234");
        userList.addUser("b", "12345678");
        userList.addUser("c", "password");

        // Change password of one user
        boolean actual = userList.changePassword("a", "1234", "1111");

        // Assert that user can change password
        assertTrue(actual);

    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("Sarun", "00000000");
        userList.addUser("b", "12345678");
        userList.addUser("c", "password");

        // TODO: call login() with correct username and password
        User actual = userList.login("Sarun", "00000000");

        // TODO: assert that User object is found
        assertNull(actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        userList.addUser("Sarun", "00000000");
        userList.addUser("b", "12345678");
        userList.addUser("c", "password");

        // TODO: call login() with incorrect username or incorrect password
        User actual = userList.login("Sarun", "00000001");

        // TODO: assert that the method return null
        assertNull(actual);
    }

}