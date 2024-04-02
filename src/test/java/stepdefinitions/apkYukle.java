package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Point;
import utils.Driver;
import utils.ReusableMethods;

import java.net.MalformedURLException;
import java.time.Duration;

public class apkYukle {
    AndroidDriver driver=Driver.getAndroidDriver();

    @Given("Kullanici uygulamayi yukler")
    public void kullanici_uygulamayi_yukler() {
        Driver.getAndroidDriver();

    }

    @Given("Kullanici gerekli ekran ayarlarini yapar")
    public void kullanici_gerekli_ekran_ayarlarini_yapar() throws InterruptedException, MalformedURLException {
        Thread.sleep(2500);

        ReusableMethods.koordinatTiklamaMethodu(533,2000);
    }
}