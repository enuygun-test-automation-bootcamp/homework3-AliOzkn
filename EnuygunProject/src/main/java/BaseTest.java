import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

    public WebDriver chromeDriver;
    public WebDriver firefoxDriver;


    public static void setDriverProps(Enum driverType) {
        try {
            if (driverType.equals(DriverType.CHROME)) {

                WebDriverManager.chromedriver().setup();

            }
            if (driverType.equals(DriverType.FIREFOX)) {

                WebDriverManager.firefoxdriver().setup();

            }
        } catch (SessionNotCreatedException e) {
            System.out.println(" sesssion not created version error  during chromedriver instance in open method\n" + e.getLocalizedMessage());
        }
    }

    public WebDriver DriverChrome() {
        setDriverProps(DriverType.CHROME);
        this.chromeDriver = new ChromeDriver();
        return chromeDriver;
    }

    public WebDriver DriverFirefox() {
        setDriverProps(DriverType.FIREFOX);
        this.firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }


}
