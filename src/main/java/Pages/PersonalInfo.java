package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfo {
	WebDriver driver;
	private WebElement guest;

	public PersonalInfo(WebDriver driver) {
		this.driver = driver;
		this.guest = driver.findElement(By.xpath("//*[@id=\"user_bar\"]/div/span[2]"));
	}

	public WebElement getGuest() {
		return guest;
	}

	public void setGuest(WebElement guest) {
		this.guest = guest;
	}

	public String Hello() throws InterruptedException {
		try {
			return getGuest().getText();
		} catch (Exception e) {
			System.out.println("personal");
		}
		return null;

	}

}
