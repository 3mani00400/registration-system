import org.junit.Before;
import org.junit.jupiter.api.Test;

public class RegistrationLogicTest {

    private RegistrationLogic reg;

    @Before
    public void setUp() {
        reg = new RegistrationLogic();
    }

    @Test
    public void testUsernameValid() {
        assertTrue(reg.checkusername("kyl_1"));
    }

    @Test
    public void testUsernameInvalid() {
        assertFalse(reg.checkusername("kyle!!!!!!"));
    }

    @Test
    public void testPhoneValid() {
        assertTrue(reg.checkphoneNumber("0123456789"));
    }

    @Test
    public void testPhoneInvalid() {
        assertFalse(reg.checkphoneNumber("12345"));
    }

    @Test
    public void testPasswordValid() {
        assertTrue(reg.checkPassword("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordInvalid() {
        assertFalse(reg.checkPassword("password"));
    }

    @Test
    public void testRegisterUserValid() {
        assertEquals("User registered successfully!", reg.registerUser("kyl_1", "Ch&&sec@ke99!", "0123456789"));
    }

    @Test
    public void testRegisterUserInvalidUsername() {
        assertEquals("Username is not correctly formatted", reg.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "0123456789"));
    }

    @Test
    public void testLoginSuccess() {
        reg.registerUser("kyl_1", "Ch&&sec@ke99!", "0123456789");
        assertEquals("Welcome <first name>, <last name> it is great to see you!", reg.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailPassword() {
        reg.registerUser("kyl_1", "Ch&&sec@ke99!", "0123456789");
        assertEquals("Incorrect password", reg.loginUser("kyl_1", "wrongPass1!"));
    }

    @Test
    public void testLoginFailUsername() {
        assertEquals("Username or password incorrect", reg.loginUser("wrong_user", "Ch&&sec@ke99!"));
    }
}