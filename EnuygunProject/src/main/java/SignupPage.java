import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SignupPage extends BasePage {

    //BasePage'den kalitim alarak oradaki fonksiyonlar daha sade bir sekilde kullanildi.

    private final By signupBtn = By.id("ctx-RegisterBtn");


    public SignupPage(List<WebDriver> driverList) {

        super(driverList);

    }

    public void openSignupPage() {

        clickBtn(signupBtn);

    }

    public void close() {

        quit();

    }
}
