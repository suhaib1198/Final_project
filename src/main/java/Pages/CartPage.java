package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement close;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.close = driver.findElement(By.xpath("//*[@id=\"site-main\"]/div[6]/div[1]/div/div[2]/ol/li/div/div[1]/a"));
	}

	public String getPriceCart() {

		WebElement price = driver.findElement(
				By.xpath("//*[@id=\"site-main\"]/div[6]/div[1]/div/div[2]/ol/li[1]/div/div[2]/div/div/div[3]/span[2]"));
		return price.getText().substring(0, 5);
	}

	public void close() throws InterruptedException {
		Thread.sleep(5000);
		close.click();
		Thread.sleep(5000);
	}
}
