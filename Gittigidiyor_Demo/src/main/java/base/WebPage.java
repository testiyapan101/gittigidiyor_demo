package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class WebPage {

    WebDriver driver;

    public WebPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCookie() {
        driver.findElement(By.xpath("//*[@id='__next']/main/div[3]/section[1]/section[2]/a/span")).click();

    }


    public void search() {
        driver.findElement(By.xpath("//*[@id='main-header']/div[3]/div/div/div[2]/div/form/div/div[1]/div[2]/input")).click();

    }

    public void SendkeySearch() {
        driver.findElement(By.xpath("//*[@id='main-header']/div[3]/div/div/div[2]/div/form/div/div[1]/div[2]/input")).sendKeys("bilgisayar"); ;

    }

    public void ClickSearch() {
        driver.findElement(By.xpath("//*[@id='main-header']/div[3]/div/div/div[2]/div/form/div/div[2]/button")).click();

    }


    public void clickSecondPage() {
        driver.findElement(By
                .xpath("//*[@id='__next']/main/div[2]/div/div/div[2]/div/div[3]/div[4]/nav/ul/li[3]/a")).click();

    }

    public void chooseItem() {
        driver.findElement(By.xpath("//*[@id='2']/li[1]/article/div[2]/a/div/div[1]/div/div[1]/img")).click();

    }

    public void addToBasket() {
        driver.findElement(By.cssSelector("//*[@id='2']/li[1]/article/div[2]/footer/button/span")).click();

    }

    public void GetPrice() {
        driver.findElement(By
                .xpath("//*[@id='2']/li[1]/article/div[2]/a/div/div[2]/section[1]/span")).getAttribute("innerText");

    }

    public void Basket() {
        driver.findElement(By
                .xpath("//*[@id='main-header']/div[3]/div/div/div[1]/div[3]/div/div[3]/a/div/div[2]")).click();

    }

    public void count() {
        driver.findElement(By.xpath("//*[@id='cart-item-533517663']/div[1]/div[4]/div/div[2]/select")).click();

    }

    public void countPlus() {
        driver.findElement(By.xpath("//*[@id='cart-item-533517663']/div[1]/div[4]/div/div[2]/select/option[2]")).click();

    }

    public void DeleteItem() {
        driver.findElement(By.xpath("//*[@id='cart-item-533517663']/div[1]/div[3]/div/div[3]/div/div/a")).click();

    }


    public void scrollPage() {
        String scroll = "window.scrollTo(100, 5500)";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scroll);

    }

}
