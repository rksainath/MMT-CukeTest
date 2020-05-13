package commons;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserConfig {

	public static WebDriver driver;
	public String path = "src/test/resources/drivers/";
	public static String chromepath = "/usr/local/bin/chromedriver";

	public BrowserConfig(String browserName) throws MalformedURLException {
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			DesiredCapabilities dcap = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", chromepath);
			System.setProperty("webdriver.chrome.logfile", path+"chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			ChromeOptions options = new ChromeOptions();
//			options.setBinary("/usr/bin/google-chrome-stable");
			options.addArguments("--no-sandbox");
			options.addArguments("--headless"); //should be enabled for Jenkins
			options.addArguments("--remote-debugging-port=9222");
			options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
//			options.addArguments("--window-size=1920x1080"); //should be enabled for Jenkins
			URL gamelan = new URL("http://localhost:4111/wd/hub");
			WebDriver driver = new RemoteWebDriver(gamelan,dcap);
//			WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver();
//			driver.manage().window().maximize();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", path + "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", path + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", path + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		}
	}

	public void closeBrowser(){
		driver.quit();
	}

	public void closeWindow(){
		driver.close();
	}

}
