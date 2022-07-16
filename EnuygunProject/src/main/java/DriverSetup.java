
public class DriverSetup extends BaseTest {

    public DriverSetup() {

        chromeDriver = new BaseTest().DriverChrome();
        firefoxDriver = new BaseTest().DriverFirefox();

    }

    public void open(String url) {
        chromeDriver.manage().window().maximize();
        firefoxDriver.manage().window().maximize();

        chromeDriver.get(url);
        firefoxDriver.get(url);

    }


}

