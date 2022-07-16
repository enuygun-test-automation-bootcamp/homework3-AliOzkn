import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPage extends BasePage {

    //BasePage'den kalitim alarak oradaki fonksiyonlar daha sade bir sekilde kullanildi.

    private final By loginBtn = By.id("ctx-LoginBtn");

    public LoginPage(List<WebDriver> driverList) {

        super(driverList);

    }

    public void openLoginPage() {

        clickBtn(loginBtn);
    }

    public void close() {

        quit();

    }
}
