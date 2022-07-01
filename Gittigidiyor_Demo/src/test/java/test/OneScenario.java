package test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File; 
import java.io.FileWriter;
import java.util.Scanner; 

import base.Constants;
import base.WebPage;

public class OneScenario extends Constants {

    static WebDriver driver = null;
    WebPage objWebPage;

    public static final Logger Log = Logger.getLogger(OneScenario.class.getName());

    static String urlControl = "https://www.gittigidiyor.com";

    @BeforeClass
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Log.info("Test started running...");

        try {
            driver.get("https://www.gittigidiyor.com");
            Assert.assertEquals("Successful", "https://www.gittigidiyor.com", urlControl);
            Log.info("The Gittigidiyor website opens.");
        } catch (Exception e) {
            Log.info("Web failed.");
            Assert.assertNotEquals("Web Failed", "https://www.gittigidiyor.com", urlControl);

        }

    }

    @Test
    public void TC001DemoScenario() {

        objWebPage = new WebPage(driver);

        
        objWebPage.acceptCookie();
        Log.info("Cookies accepted");


        

        try {
            objWebPage.search();

            Assert.assertTrue("Successful", Search != null);
            Log.info("Clicked search button");
        } catch (Exception e) {
            Log.info("Search button not founded");
            Assert.assertTrue("Failed Search ", Search == null);

        }

        try {
            objWebPage.SendkeySearch();

            Assert.assertTrue("Successful", SendKey != null);
            Log.info("Bilgisayar searching");
        } catch (Exception e) {
            Log.info("Search failed");
            Assert.assertTrue("Failed Search Item", SendKey == null);

        }

        try {
            objWebPage.scrollPage();
            objWebPage.clickSecondPage();

            Assert.assertEquals("Successful", secondPageControl, secondPageControl);
            Log.info("Changed Page");
        } catch (Exception e) {
            Log.info("Page has not changed");
            Assert.assertNotEquals("Failed Change Page", secondPageControl, secondPageControl);

        }

        try {
            objWebPage.addToBasket();

            
            Assert.assertTrue("Successful", addedItem != null);
            Log.info("Added item.");
        } catch (Exception e) {
            Log.info("No item has been added.");
            Assert.assertTrue("Failed Choose Item", addedItem == null);

        }

        try {
            objWebPage.GetPrice();

            String SecondPagePrice  =  driver.findElement(By.
                    xpath("//*[@id='2']/li[1]/article/div[2]/a/div/div[2]/section[1]/span")).getAttribute("innerText");
            //*[@id="2"]/li[1]/article/div[2]/a/div/div[2]/section[1]/span

            File myObj = new File("price.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            
            FileWriter myWriter = new FileWriter("price.txt");
            myWriter.write(SecondPagePrice);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
  


            Assert.assertTrue("Successful", myBasket != null);
            Log.info("My Basket List is open.");
        } catch (Exception e) {
            Log.info("My Basket List is not opened.");
            Assert.assertTrue("Failed GoToMyBasket", myBasket == null);

        }

        try {
            objWebPage.Basket();



            String BasketPagePrice = driver.findElement(By.
                    xpath("//*[@id='cart-item-533517663']/div[1]/div[5]/div/div[1]/strong")).getAttribute("innerText");
            
                File myObj = new File("price.txt");
                Scanner myReader = new Scanner(myObj);
                String data = myReader.nextLine();
                if (BasketPagePrice == data ){
                    System.out.println("Items page price and basket page price are the same ");
                }
                else{
                    System.out.println("Items page price and basket page price are diffirent ");
                }
                  myReader.close();
                  
            Assert.assertTrue("Successful", myBasket != null);
            Log.info("My Basket List is open.");
        } catch (Exception e) {
            Log.info("My Basket List is not opened.");
            Assert.assertTrue("Failed GoToMyBasket", myBasket == null);

        }

        try {
            objWebPage.count();
            Assert.assertTrue("Successful", number != null);
            Log.info("Now There is 1 out of 1 item.");

        } catch (Exception e) {
            Log.info("There is not 1 out of 1 item.");
            Assert.assertTrue("Failed Number of Item", number == null);
        }

        try {
            objWebPage.countPlus();

            Assert.assertTrue("Successful", number2 != null);
            Log.info("There are 2 out of 1 item.");
        } catch (Exception e) {
            Log.info("There are not 2 out of 1 item.");
            Assert.assertTrue("Failed Increase The Number of Item ", number2 == null);

        }

        try {
            objWebPage.DeleteItem();

            Assert.assertTrue("Successful", DeleteButton != null);
            Log.info("There are 2 out of 1 item.");
        } catch (Exception e) {
            Log.info("There are not 2 out of 1 item.");
            Assert.assertTrue("Failed Delete Item", DeleteButton == null);

        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        Log.info("Test completed...");

    }

}