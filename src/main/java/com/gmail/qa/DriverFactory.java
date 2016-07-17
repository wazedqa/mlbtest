package com.gmail.qa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

   /* private DriverFactory(){
   
        
    }*/
    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance()
    {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        @Override
        protected WebDriver initialValue()
        {

            

            String driverName = ResourceFactory.getInstance().getProperty("DRIVER").toString();
            if(driverName.toUpperCase().contentEquals("CHROME")){

            String chromeBinayPath;
        	chromeBinayPath =  System.getProperty("user.dir") + "/src/main/resources/driver/32********";
            System.setProperty("webdriver.chrome.driver", chromeBinayPath);
            return new ChromeDriver();
               
            }
           
            else if(driverName.toUpperCase().contentEquals("FIREFOX")){
                return new FirefoxDriver();
              
            }
          
          
            else {
                return new FirefoxDriver(); 
            }
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() 
    {
        //driver.get().quit();
        //driver.remove();
    }
}
