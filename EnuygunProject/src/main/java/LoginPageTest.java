import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPageTest extends BaseTest {
    DriverSetup driverSetup;
    LoginPage loginPage;
    List<WebDriver> driverSetupList;
    private final By checkBtn = By.name("_password");

    public LoginPageTest() {

        driverSetup = new DriverSetup();
        driverSetupList = new ArrayList<>();
        driverSetupList.add(driverSetup.chromeDriver);
        driverSetupList.add(driverSetup.firefoxDriver);
        loginPage = new LoginPage(driverSetupList);

    }
    // enuygun.com anasayfasi acildi. Acilan sayfanin url'i ile, istedigimiz url'nin uyumlulugu kontrol edildi.
    public void checkOpenMainPage() {

        driverSetup.open("https://www.enuygun.com/");

        String openedWebApp = driverSetup.chromeDriver.getCurrentUrl();

        if (openedWebApp.equals("https://www.enuygun.com/")) {
            System.out.println("passed for chrome");
        }
        openedWebApp = driverSetup.firefoxDriver.getCurrentUrl();

        if (openedWebApp.equals("https://www.enuygun.com/")) {
            System.out.println("passed for firefox");
        }

    }

    /* Login sayfasi acildi. Sifre kutusunun kullanilabilir olup olmadigini kontrol ederek
       dogru sayfada oldugumuzu onayladik.*/
    public boolean checkOpenLoginPage() {

        loginPage.openLoginPage();

        driverSetup.chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        boolean checkPassBtn = driverSetup.chromeDriver.findElement(checkBtn).isEnabled();

        if (checkPassBtn) {
            System.out.println("Correct page opened in Chrome!");
        } else {
            System.out.println("Wrong page opened in Chrome!");
        }

        driverSetup.firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        checkPassBtn = driverSetup.firefoxDriver.findElement(checkBtn).isEnabled();

        if (checkPassBtn) {
            System.out.println("Correct page opened in Firefox");
        } else {
            System.out.println("Wrong page opened in Firefox");
        }
        return checkPassBtn;
    }

    public void close() {

        loginPage.close();

    }
}

