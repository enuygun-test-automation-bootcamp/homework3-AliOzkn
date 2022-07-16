import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BasePage {
    WebDriver driverChrome;
    WebDriver driverFirefox;

    /* Signup ve Login sayfalarinda ortak kullanilacak, Butona tiklama ve sayfayi kapatma fonksiyonlari burada tanimlanarak,
       ayni kodlarin Signup ve Login sayfalarinda tekrar yazilmasi engellendi.*/
    public BasePage(List<WebDriver> driverList) {
        this.driverChrome = driverList.get(0);
        this.driverFirefox = driverList.get(1);
    }

    public void clickBtn(By locator) {
        driverChrome.findElement(locator).click();
        driverFirefox.findElement(locator).click();

    }

    public void quit() {
        driverChrome.quit();
        driverFirefox.quit();

    }

}
