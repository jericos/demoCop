package com.pacifico.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class DriverContext {

    public static WebDriver Driver;

    public static com.pacifico.framework.Browser Browser;


    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public  static WebElement WaitForElementVisible(final WebElement elementFindBy){

        WebDriverWait wait= new WebDriverWait(Driver, 60);
        try {
            return wait.until(ExpectedConditions.visibilityOf(elementFindBy));
        }catch(Exception e){
            System.out.println("Don't found element "+e.getMessage());
            return null;
        }

    }

//    public static void WaitElementEnabled(final By elementFindBy){
//        WebDriverWait wait = new WebDriverWait(Driver,5);
//        wait.until(webDriver -> webDriver.findElement(elementFindBy).isEnabled());
//    }

    public static void ChangeWindows(int tabNumber){
        ArrayList<String> tabs = new ArrayList<String> (Driver.getWindowHandles());
        Driver.switchTo().window(tabs.get(tabNumber));
    }
}
