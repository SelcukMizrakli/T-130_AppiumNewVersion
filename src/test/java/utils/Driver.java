package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver appiumDriver;

    private static IOSDriver iosDriver;

    static final String TELEFONADI="Galaxy Tab S2";
    static final String ANDROIDVERSION="7.0";
    static final String PLATFORM="Android";
    static final String OTOMASYON_ISMI="UiAutomator2";



    public static AndroidDriver getAndroidDriver()  {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {

            UiAutomator2Options options=new UiAutomator2Options();
            options


                    //   .setAppPackage("com.ailebutcem")
                    //  .setAppActivity("com.ailebutcem.MainActivity")
                    .setApp("C:\\Users\\ahmet\\IdeaProjects\\Appium_T130_NewVersion\\Apps\\Aile Bütçem_1.07_apkcombo.com.apk")
                    .setUdid("emulator-5556") // terminale "adb devices" yazarak cihazlarimizin tc kimlik nosuna ulasiriz kopyalayarak
                    // hangi cihaz uzerinde calismak istiyorsak onun udid sini burada gireriz
                    .setSkipUnlock(true)     // eger cihazinin ekran kilidi otomatik olarak eger kapaliysa ve acilsin istiyorsan true
                    // .setLanguage("En");   // uygulamanin dili
                    .setAutoGrantPermissions(true);// kullanici tarafindan verilmesi gereken izileri KABUL eder
            //  .setNoReset(false) //
            // .setFullReset(false);
            // .withBrowserName("chrome")
            // .setChromedriverExecutable("")
            // cihazin her calistirilmadan once sifilanip sifirlanmayacagi.Eger false ise sifirlanmaz




            if (ConfigReader.getProperty("platformName").equals("Android")) {

                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver(appiumServerURL,options);
                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            }else {

                assert appiumServerURL != null;
                iosDriver = new IOSDriver(appiumServerURL,options);
                iosDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

                throw new UnsupportedOperationException("Dostum Ios kullanmaya calisiyorsun YAPMA!!");

            }

        }

        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}


