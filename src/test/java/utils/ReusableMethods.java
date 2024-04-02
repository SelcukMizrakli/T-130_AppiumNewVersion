package utils;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static io.appium.java_client.AppiumBy.androidUIAutomator;


public class ReusableMethods {
    static AndroidDriver driver=Driver.getAndroidDriver();
    public static void koordinatTiklamaMethodu(int x,int y) throws InterruptedException {
        TouchAction action=new TouchAction(driver);
        action.press(PointOption.point(x,y)).release().perform();
        Thread.sleep(1000);
    }

    public static void scrollWithUiScrollableAndClick(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
        driver.findElement(By.xpath("//*[@text='" + elementText + "']")).click();



    }


    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElement(androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));

    }



    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }


    public static void ekranKaydirmaMethodu(int xPress,int yPress,int wait,int xMove,int yMove){
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(xPress,yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(xMove,yMove))
                .release()
                .perform();
    }

    public static void wait(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void screenScroll(int xPress,int yPress,int wait,int moveX,int moveY) throws MalformedURLException, InterruptedException {


        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(xPress, yPress))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(750)))
                .moveTo(PointOption.point(moveX, moveY))
                .release()
                .perform();

    }
}