package Dangnhap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationTestNG {
    private UserRegistrationUI ui;

    @BeforeClass
    public void setUp() {
        ui = new UserRegistrationUI();
    }

    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][] {
                {"existingUser", "WeakPass1", "Username already exists"},
                {"newUser", "weak", "Password is too weak"},
                {"newUser", "StrongPass1", "Registration successful"},
        };
    }

    @Test(dataProvider = "registrationData")
    public void testUserRegistration(String username, String password, String expectedMessage) {
        ui.setUsername(username);
        ui.setPassword(password);
        ui.clickRegister();
        String actualMessage = ui.getResult();
        Assert.assertEquals(actualMessage, expectedMessage, "Registration message should match expected message");
    }
}

