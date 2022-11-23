package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.UtilitiesMain;

public class LoginTest extends UtilitiesMain {
    String basUrl ="https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(basUrl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // enter   username
        sendTextToElement(By.name("user-name"),"standard_user");

        // enter password
        sendTextToElement(By.id("password"),"secret_sauce");

        // click on login button
        clickOnElement(By.xpath("//input[@type='submit']"));

        // //span[@class='title']

        String expectMessage= "PRODUCTS";

        //Find the login button and click on it

        WebElement actualTextMessageElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextMessageElement.getText();


        //validate actual and expected message
        Assert.assertEquals("",expectMessage,actualMessage);


    }

    @Test
    public void  verifyThatSixProductsAreDisplayedOnPage(){

        // enter   username
        sendTextToElement(By.name("user-name"),"standard_user");

        // enter password
        sendTextToElement(By.id("password"),"secret_sauce");

        // click on login button
        clickOnElement(By.xpath("//input[@type='submit']"));

        boolean isInventoryDisplayed = driver.findElement(By.id("inventory_container")).isDisplayed();
        System.out.println("all six item displayed" +isInventoryDisplayed);










    }
    @After
    public void TearDown(){
     //   closeBrowser();
    }




}
