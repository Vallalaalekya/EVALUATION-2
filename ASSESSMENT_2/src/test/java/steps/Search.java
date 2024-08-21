package steps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	WebDriver driver;
	@Given("open browser, enter the ebay URL")
	public void open_browser_enter_the_ebay_url() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}

	@When("user should access the advanced search page")
	public void user_should_access_the_advanced_search_page() {
		driver.findElement(By.cssSelector("[title=\"Advanced Search\"]")).click();
		
	}

	@When("user should select the appropriate search options")
	public void user_should_select_the_appropriate_search_options() {
		driver.findElement(By.cssSelector("[data-testid=\"_nkw\"]")).sendKeys("Shoes adidas");
		WebElement dropdownELement = driver.findElement(By.cssSelector("[name=\"_in_kw\"]"));
		Select dropdown = new Select(dropdownELement);
		dropdown.selectByValue("3");
		driver.findElement(By.cssSelector("[class=\"textbox field__control\"]")).sendKeys("adidas,S,L,M");
		
		WebElement dropdownElement2= driver.findElement(By.cssSelector("[data-testid=\"_nkw\"]"));
		Select dropdown1 = new Select(dropdownElement2);
		dropdown1.selectByValue("1");
	}

	@When("user click on  the search options link")
	public void user_click_on_the_search_options_link() {
	    driver.findElement(By.linkText("using advanced search options")).click();
	}

	@When("user should handle the new window and assert it and back to parent window")
	public void user_should_handle_the_new_window_and_assert_it_and_back_to_parent_window() {
		
		String parentid = driver.getWindowHandle();
		Set<String>allids =driver.getWindowHandles();
		
		
		String expectedtitle = "Customer Service\n";

				for(String id : allids) {
					
					
					driver.switchTo().window(id);
					if(driver.getTitle().equals(expectedtitle)) {
						
					Assert.assertEquals(expectedtitle, driver.getTitle());
					driver.switchTo().window(parentid);
				}
				}
	}

	@When("user should enter the search details")
	public void user_should_enter_the_search_details() {
	    driver.findElement(By.cssSelector("id=\"s0-1-17-5[1]-[1]-LH_Complete\"]")).click();
	
	    driver.findElement(By.cssSelector("[class=\"textbox\"]")).sendKeys("300");
	driver.findElement(By.cssSelector("[name=\"_udhi\"]")).sendKeys("1000");
	driver.findElement(By.cssSelector("[id=\"s0-1-17-6[4]-[2]-LH_ItemCondition\"]")).click();
	driver.findElement(By.cssSelector("[value=\"LH_BIN\"]")).click();
	
	}

	@When("user should click on search button")
	public void user_should_click_on_search_button() {
	  driver.findElement(By.cssSelector("[id=\"gh-btn\"]")).click();  
	}

	@Then("User should see  {string}")
	public void user_should_see(String string) {
		Alert A = driver.switchTo().alert();
		String Act = A.getText();
		String ms = "No Exact Matches Found";
		Assert.assertEquals(ms, Act);
	    
	}

	@Then("user should close the browser")
	public void user_should_close_the_browser() {
	    driver.close();
	}




}
