package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddingToCart {
	WebDriver driver;
	private WebElement add;

	public AddingToCart(WebDriver driver) {
		this.driver = driver;
		this.add = driver
				.findElement(By.xpath("//*[@data-test=\"sentinelEnd\"]//following::div[4]/div/div/div/div/button[2]"));
	}

	public WebElement getAdd() {
		return add;
	}

	public void setAdd(WebElement add) {
		this.add = add;
	}

	public void add() {
		try {
			getAdd().click();
		} catch (Exception e) {
			System.out.println("adding to cart problem");
		}

	}
}
