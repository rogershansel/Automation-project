package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        String title = home.getPageTitle();

        Assert.assertEquals(title, "Products");
    }
}