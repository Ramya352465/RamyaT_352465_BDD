package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TripClass {
	
	public WebDriver driver= null;

	@Given("^Enter the URL \"([^\"]*)\"$")
	public void enter_the_URL(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C://Program Files//Selenium//chrome//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Then("^Choose a trip and select from and To place$")
	public void choose_a_trip_and_select_from_and_To_place() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("roundTrip")).click();
	    driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("Madura, India(IXM)");
	    WebDriverWait wait=new WebDriverWait(driver,20);
	    WebElement element=wait. until(ExpectedConditions.elementToBeClickable(By. xpath("//*[@class='blueGrey padR5 ico18 hypflt-from ']")));
	    element.click();
	    driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Chennai, India(MAA)");
	    WebDriverWait wait1=new WebDriverWait(driver,20);
	    WebElement element1=wait1. until(ExpectedConditions.elementToBeClickable(By. xpath("//*[@class='blueGrey padR5 ico18 hypflt-destination ']")));
	    element1.click();
	    driver.findElement(By.xpath("//*[@class='blueGrey padR5 ico18 hypflt-destination ']")).click();
	    driver.findElement(By.id("departureCalendar")).click();
	   
	}

	@And("^Choose a departure and return date$")
	public void choose_a_departure_and_return_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String DepartDate="5";
	    String ReturnDate="10";
	    String DepartMonth="July 2020";
	    while(true)
	        {
	        String month=driver.findElement(By.xpath("//*[@class='DayPicker-Caption']")).getText();
	        System.out.println(month);
	        if(month.equalsIgnoreCase(DepartMonth)) 
	        {
	              break;
	        }
	        else
	        {
	        driver.findElement(By.xpath("//*[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	        }
	        }
	         List<WebElement> date= driver.findElements(By.xpath("//*[@class='DayPicker-Day']"));
	         //for selecting departure date
	         for(WebElement e:date)
	         {
	             if(e.getText().contains(DepartDate)) {
	                 e.click();
	                 break;
	             }
	         }
	         //for selecting return date.
	         for(WebElement e:date)
	         {
	             if(e.getText().contains(ReturnDate)) {
	                 e.click();
	                 break;
	             }
	         }

	}

	@Then("^Click on the search button$")
	public void click_on_the_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("gi_search_btn")).click();
	}

	@And("^Select flight and book a ticket$")
	public void select_flight_and_book_a_ticket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@value='BOOK']")).click();
		
	}

	@And("^Verify the booking ticket$")
	public void verify_the_booking_ticket() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	     System.out.println("No. of tabs: " + tabs.size());
	     if(tabs.size()>1)
	     System.out.println("review page is opened!");
	     else
	     System.out.println("review page is not opened!");
	     driver.quit();   
	     
	}


}
