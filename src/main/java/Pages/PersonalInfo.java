package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfo {
	WebDriver driver;
	WebElement guest;
	public PersonalInfo(WebDriver driver) {
		this.driver = driver;
		this.guest = driver.findElement(By.xpath("//*[@id=\"user_bar\"]/div/span[2]"));
	}

	public String Hello() {
		return guest.getText();
	}

}
