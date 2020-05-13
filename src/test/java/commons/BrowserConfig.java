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

	public BrowserConfig(String browserName) {
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromepath);
			System.setProperty("webdriver.chrome.logfile", path+"chromedriver.log");
			System.setProperty("webdriver.chrome.verboseLogging", "true");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("/usr/bin/google-chrome-stable");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-extensions");
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.addArguments("--start-maximized");
			options.addArguments("--headless");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--ignore-certificate-errors");

			driver = new ChromeDriver(options);
			//			driver = new ChromeDriver();
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
