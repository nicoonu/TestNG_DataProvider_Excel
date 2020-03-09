package org.dataP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTGo {

    WebDriver driver;

    @BeforeClass
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("https://tgo.gointegro.com/gosocial/company/stream");
        driver.manage().window().maximize();
    }

    @DataProvider(name = "test")
    public static Object[][] getData(){
        ExcelDataProvider excel = new ExcelDataProvider();
        Object data[][] = excel.testData("Hoja1");
        return data;
    }

    @Test(dataProvider = "test")
    public void logInTGO(String userName, String password){
        driver.findElement(By.xpath("//*[@id=\"ember12-input\"]")).sendKeys(userName);
        driver.findElement(By.id("ember17-input")).sendKeys(password);
        driver.findElement(By.className("primary")).click();
    }

    @AfterClass
    public void close() { driver.quit(); }
}