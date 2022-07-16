import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SignupPageTest extends BaseTest {
    DriverSetup driverSetup;
    SignupPage signupPage;
    List<WebDriver> driverSetupList;
    private final By checkBtn = By.name("_email");


    public SignupPageTest() {

        driverSetup = new DriverSetup();
        driverSetupList = new ArrayList<>();
        driverSetupList.add(driverSetup.chromeDriver);
        driverSetupList.add(driverSetup.firefoxDriver);
        signupPage = new SignupPage(driverSetupList);

    }

    // enuygun.com anasayfasi acildi.
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

    /* Signup sayfasi acilarak, email giris kisminin kullanilabilir olup olmadigi kontrol edildi.
       Dolayisiyla signup sayfasini ac komutu verdigimizde, dogru sayfanin acildigini gormus olduk.*/
    public boolean checkOpenSignupPage() {

        signupPage.openSignupPage();

        driverSetup.chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        boolean checkEmailBtn = driverSetup.chromeDriver.findElement(checkBtn).isEnabled();

        if (checkEmailBtn) {
            System.out.println("Correct page opened in Chrome!");
        } else {
            System.out.println("Wrong page opened in Chrome!");
        }

        driverSetup.firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        checkEmailBtn = driverSetup.firefoxDriver.findElement(checkBtn).isEnabled();

        if (checkEmailBtn) {
            System.out.println("Correct page opened in Firefox");
        } else {
            System.out.println("Wrong page opened in Firefox");
        }
        driverSetup.firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return checkEmailBtn;
    }

   public void close() {

        signupPage.close();
    }
}

