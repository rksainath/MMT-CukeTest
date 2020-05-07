package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage{
	public WebDriver driver;
	private static String url = "https://www.makemytrip.com/";
	
	@FindBy(how = How.XPATH, using="//li[@data-cy='oneWayTrip']")
	private static WebElement oneWayTrip;
	
	@FindBy(how = How.XPATH, using="//input[@id='fromCity']")
	private static WebElement fromCity;

	@FindBy(how = How.XPATH, using="//input[@id='toCity']")
	private static WebElement toCity;

	@FindBy(how = How.XPATH, using ="//div[@class='hsw_autocomplePopup autoSuggestPlugin']//input")
	private WebElement writeCity;

	@FindBy(how = How.XPATH, using ="//li[@id='react-autowhatever-1-section-0-item-0']")
	private WebElement selectCity;

	@FindBy(how = How.XPATH, using ="//span[text()='DEPARTURE']")
	private WebElement departure;

	@FindBy(how = How.XPATH, using ="//div[text()='May 2020']/following::div//div[@aria-disabled='false']//p[text()='1']")
	private WebElement departureDate;

	@FindBy(how = How.XPATH, using ="//span[text()='RETURN']")
	private WebElement returnJourney;

	@FindBy(how = How.XPATH, using ="//div[text()='May']/following::div[@aria-disabled='false']//p[text()='6']")
	private WebElement returnDate;

	@FindBy(how = How.XPATH, using ="//a[text()='Search']")
	private static WebElement search;
	
	public void navigateToMMT() {
		driver.get(url);		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Search']")));
		oneWayTrip.click();
	}

	public void setFromCity(String from) {

		fromCity.sendKeys(from);
		selectCity.click();
	}

	public void setToCity(String to) {

		writeCity.sendKeys(to);
		selectCity.click();
	}

	public void setDeparture(String date) {
		departure.click();
//		departureDate.click();
		driver.findElement(By.xpath("//div[text()='May 2020']/following::div//div[@aria-disabled='false']//p[text()='"+date+"']")).click();
	}

	public void setReturn(String date) {
		returnJourney.click();
//		returnDate.click();
		driver.findElement(By.xpath("//div[text()='May']/following::div[@aria-disabled='false']//p[text()='"+date+"']"));
	}


	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void search() {
		 search.click();
		
	}

}
