package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddingToCart {
	WebDriver driver;
	WebElement add;

	public AddingToCart(WebDriver driver) {
		this.driver = driver;
		this.add = driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]/div[2]/div/button[2]/span[1]"));
	}

	public void add() throws InterruptedException {
		Thread.sleep(5000);
		add.click();
		Thread.sleep(5000);
	}

}
