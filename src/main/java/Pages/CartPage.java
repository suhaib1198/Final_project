package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	private WebElement close;
	private WebElement price;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.close = driver.findElement(By.xpath("//a[starts-with(@class,\"action\")]"));
		this.price = driver.findElement(By.xpath("//div[@id=\"totalPriceInFinishOrder\"]//span[2]"));
	}

	public WebElement getPrice() {
		return price;
	}

	public void setPrice(WebElement price) {
		this.price = price;
	}

	public WebElement getClose() {
		return close;
	}

	public void setClose(WebElement close) {
		this.close = close;
	}

	public String getPriceCart() {
		try {
			return getPrice().getText().substring(0, 5);
		} catch (Exception e) {
			System.out.println("cat page>>>price");
		}
		return null;

	}

	public void close(){

		try {
			getClose().click();
		} catch (Exception e) {
			System.out.println("cart page>>>>>closing");
		}
		

	}
}
