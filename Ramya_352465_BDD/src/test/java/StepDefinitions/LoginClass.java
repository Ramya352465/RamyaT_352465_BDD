package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

public class LoginClass {

	public WebDriver driver= null;
	
	@Given("^I launch the gillette application using URL \"([^\"]*)\"$") 
	public void launch_the_application( String url) throws Throwable
	{
		System.setProperty("webdriver.chrome.driver", "C://Program Files//Selenium//chrome//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
     @Then("^I click on the login link$") 
     public void click_on_login_button() throws Throwable
     {
		  driver.findElement(By.xpath("//*[@title='SIGN IN']")).click();
	}
	 @And("^I enter my email and password$") 
	 public void enter_emailandpassword() throws Throwable
	 {
		 driver.findElement(By.xpath("//input[@name='phdesktopbody_0$phdesktopbody_0_username']")).sendKeys("nithiramyaa@gmail.com");
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ramya2325");
	 }
     
     /*@Then("^I enter my email \"([^\"]*)\" and password \"([^\"]*)\"$")
     public void i_enter_my_email_and_password(String arg1, String arg2) throws Throwable {
         // Write code here that turns the phrase above into concrete actions
        
     }*/
      @Then("^I click on the login button$") 
      public void click_on_submit_button() throws Throwable
      {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
      }
      
	@When("^I enter my credentials I do validate my users$") 
       public void validate_credentials() throws Throwable
       {
    	   
			String UserName=driver.findElement(By.xpath("//a[@href='/en-in/viewprofilepage']")).getText();
			System.out.println(UserName);
		    assertEquals(UserName, "RAMYA");
       }
	@And("^I logout of the application$")
	public void Logout_App() throws Throwable
    {
		driver.findElement(By.xpath("//*[@title='log out']")).click();
		driver.findElement(By.xpath("//*[@title='LOG OUT']")).click();
    }
		
       
}
