package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //Set up method and tear down method
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        //calling Method to open the browser with URL
        openBrowser(baseUrl);
    }

    @Test
    public void verityUserShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),' Sign In')]")).click(); //Find the X-path & Click on login button
        String expectedMessage = "Welcome Back!";                                              //Expected message
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[@class='page__heading']")); //find x-path for the dashboard
        String actualMessage = actualTextElement.getText();                         //matching actual with the expected
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Verifying the error message
        driver.findElement(By.xpath("//a[contains(text(),' Sign In')]")).click(); //Find the X-path & Click on login button
        driver.findElement(By.name("user[email]")).sendKeys("user123");    //Find the login link and enter user ID
        driver.findElement(By.id("user[password]")).sendKeys("abc132");   //Find the password link and enter password
        driver.findElement(By.xpath("//button[@type='submit']")).click(); //Find the X-path & Click on login button
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
