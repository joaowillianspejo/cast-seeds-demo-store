package configuracoes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class DriverFactory {
	private static WebDriver driver;
	private static final String DRIVER_CHROME = "chrome";
	private static final String DRIVER_IE = "ie";
	private static final String DRIVER_FIREFOX = "firefox";
	private static final String HEADLESS_CHROME = "chrome-headless";

	public static WebDriver createDriver(String browserName) {
	   
	   if (browserName.equals(DRIVER_CHROME)) {
	      System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	      driver = new ChromeDriver();
	   } 
	   
	   else if (browserName.equals(DRIVER_IE)) {
	      System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
	      driver = new InternetExplorerDriver();
	   } 
	   
	   else if (browserName.equals(DRIVER_FIREFOX)) {
	      System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
	      driver = new FirefoxDriver();
	   } 
	   
	   else if (browserName.equals(HEADLESS_CHROME)) {
	      System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	      ChromeOptions options = new ChromeOptions();
	      options.addArguments("--headless");
	      driver = new ChromeDriver(options);
	   } 
	   
	   return driver;
	   }

}
