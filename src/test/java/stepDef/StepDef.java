package stepDef;

import commons.BrowserConfig;
import commons.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDef {
	public BrowserConfig browser = new BrowserConfig("chrome");
	public HomePage homePage = new HomePage(BrowserConfig.driver);
	
	@Given("I have landed in the MMT page")
	public void i_have_landed_in_the_MMT_page() {
		homePage.navigateToMMT();
	}

	@Then("I choose my {string} departure place")
	public void i_choose_my_departure_place(String departure) {
		homePage.setFromCity(departure);
	}

	@Then("I choose my {string} arrival place")
	public void i_choose_my_arrival_place(String arrival) {
		homePage.setToCity(arrival);
	}

	@Then("I choose my {string} for onward journey")
	public void i_choose_my_for_onward_journey(String datefrom) {
		homePage.setDeparture(datefrom);
	}

	@Then("Search for the availability of flights")
	public void search_for_the_availability_of_flights() {
		homePage.search();  
	}

	@Then("Close the browser")
	public void close_the_browser() {
		browser.closeBrowser();
	}




}
