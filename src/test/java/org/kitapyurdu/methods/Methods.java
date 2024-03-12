package org.kitapyurdu.methods;


import com.thoughtworks.gauge.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kitapyurdu.base.HookImp;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.*;

public class Methods extends HookImp {

    AppiumDriver driver;
    FluentWait<AppiumDriver> wait;
    Actions actions;
    Logger logger = LogManager.getLogger(Methods.class);
    private Map<By, String> savedId = new HashMap<>();

    public Methods() {

        driver = appiumDriver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);

        actions = new Actions(driver);
    }

    public MobileElement findElement(By by) {
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<MobileElement> findElements(By by) {
        return wait.until(new ExpectedCondition<List<MobileElement>>() {
            @Nullable
            @Override
            public List<MobileElement> apply(@Nullable WebDriver driver) {
                List<MobileElement> elements = driver.findElements(by);
                return elements.size() > 0 ? elements : null;
            }
        });
    }

    public MobileElement findElementBykey(String key, String selector) {
        if (selector.equals("xpath")) {
            return findElement(By.xpath(key));
        } else {
            return findElement(By.id(key));
        }
    }

    public void click(String key, String selector) {

        findElementBykey(key, selector).click();
        logger.info(key + " Butonuna tiklandi");
    }

    public void sendKeys(String key, String text, String selector) {

        logger.info(key + " ya " + text + " yazildi");
        findElementBykey(key, selector).sendKeys(text);
    }

    public String getText(String key, String selector) {
        logger.info(key + " deki text alindi");
        return findElementBykey(key, selector).getText();
    }

    public void keyEnter() {
        actions.sendKeys(Keys.ENTER).build().perform();
    }


    public String getText(By element) {
        return findElement(element).getText();
    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }


    public void waitToXpath(String key) {
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath(key)));
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public boolean isTextPresent(By by, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        } catch (TimeoutException e) {
            return false;
        } catch (WebDriverException e) {
            logger.error("Hata olustu ", e);
            return false;
        }
    }

    public void chooseRandomProduct() {

        List<MobileElement> productList = new ArrayList<>();
        List<MobileElement> elements = findElements(By.xpath("//android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup"));
        int elementsSize = elements.size();
        int height = appiumDriver.manage().window().getSize().height;
        for (int i = 0; i < elementsSize; i++) {
            MobileElement element = elements.get(i);
            int y = element.getCenter().getY();
            if (y > 0 && y < (height - 100)) {
                productList.add(element);
            }
        }
        Random random = new Random();
        int randomNumber = random.nextInt(productList.size());
        productList.get(randomNumber).click();
    }

    public void saveElementId(By key, String text) {
        savedId.put(key, text);
        logger.info("ID kaydedildi: Anahtar = " + text + ", id = " + key);
    }


    }







