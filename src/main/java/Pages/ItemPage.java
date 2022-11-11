package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	WebDriver driver;
	WebElement cart;
	WebElement price;

	public ItemPage(WebDriver driver) {
		this.driver = driver;
		this.cart = driver.findElement(By.xpath("//*[@id=\"product-page-root\"]/div[2]/div[2]/div[5]/div/p/span/span"));
		this.price = driver.findElement(By.xpath("//*[@id=\"product-page-root\"]/div[2]/div[2]/div[3]/div[1]/div"));

	}

	public String getPriceItem() {
		return price.getText().substring(1, 6);
	}

	public void getCart() throws InterruptedException {
		Thread.sleep(5000);
		cart.click();
		Thread.sleep(5000);
	}

}
