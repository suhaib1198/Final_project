package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
	WebDriver driver;
	private WebElement cart;
	private WebElement price;

	public ItemPage(WebDriver driver) {
		this.driver = driver;
		this.cart = driver.findElement(By.xpath("//h2[@aria-label=\"זמינות המוצר בסניפי KSP \"]//following-sibling::div/p"));
		this.price = driver.findElement(By.xpath("//div[@data-id=\"top-product-page\"]//following-sibling::div[2]/div[1]/div"));

	}
	

	public WebElement getPrice() {
		return price;
	}
	public void setPrice(WebElement price) {
		this.price = price;
	}


	public void setCart(WebElement cart) {
		this.cart = cart;
	}


	public String getPriceItem() {
		try {
			return getPrice().getText().substring(1, 6);
		} catch (Exception e) {
			System.out.println("item page price");
		}
		return null;
		
	}

	public void getCart(){
		try {
		cart.click();
		}
		catch (Exception e) {
		System.out.println("item page click");
		}
		
	}

}
