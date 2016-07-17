package com.gmail.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class PageBase {
	  protected WebDriver driver= null;

	    public PageBase(WebDriver driver) {
	        this.driver = driver;

	    }
	    
	    public void delayFor(int secInMili) {
	        try {
	            Thread.sleep(secInMili);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    public WebElement waitForElement(final By locator) {
	        return waitForElement(locator, 20);
	    }

	    public WebElement waitForElement(final By locator, int timeToWaitInSec) {
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
	                .pollingEvery(100, TimeUnit.MILLISECONDS)
	                .ignoring(NoSuchElementException.class);

	        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        });
	        return foo;
	    }


	    public WebElement waitForElementDisplayed(final By locator) {
	        return waitForElementDisplayed(locator, 20);
	    }

	    public WebElement waitForElementDisplayed(final By locator, int timeToWaitInSec) {
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
	                .pollingEvery(100, TimeUnit.MILLISECONDS)
	                .ignoring(NoSuchElementException.class);

	        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                WebElement element = driver.findElement(locator);
	                if (element != null && element.isDisplayed()) {
	                    highlight(element);
	                    return element;
	                }
	                return null;
	            }
	        });
	        return foo;
	    }

	    public WebElement waitForElementEnabled(final By locator) {
	        return waitForElementEnabled(locator, 20);
	    }

	    public WebElement waitForElementEnabled(final By locator, int timeToWaitInSec) {
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
	                .pollingEvery(100, TimeUnit.MILLISECONDS)
	                .ignoring(NoSuchElementException.class);

	        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                WebElement element = driver.findElement(locator);
	                if (element != null && element.isEnabled()) {
	                    return element;
	                }
	                return null;
	            }
	        });
	        return foo;
	    }

	    public void jsClick(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click()", element);
	    }

	    public void highlight(WebElement element) {
	        for (int i = 0; i < 2; i++) {
	            JavascriptExecutor js = (JavascriptExecutor) driver;

	            js.executeScript(
	                    "arguments[0].setAttribute('style', arguments[1]);",
	                    element, "border: 4px solid red;");
	            delayFor(200);
	            js.executeScript(
	                    "arguments[0].setAttribute('style', arguments[1]);",
	                    element, "");
	            delayFor(200);
	        }
	    }

}
