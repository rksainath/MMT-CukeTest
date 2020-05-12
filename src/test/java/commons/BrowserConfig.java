package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserConfig {

	public static WebDriver driver;
	public String path = "src/test/resources/drivers/";

	public BrowserConfig(String browserName) {
		String browser = browserName.toLowerCase();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
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
