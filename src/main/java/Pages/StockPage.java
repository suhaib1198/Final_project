package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StockPage {
	WebDriver driver;
	private WebElement put;

	public StockPage(WebDriver driver) {
		this.driver = driver;
		this.put = driver.findElement(By.xpath("//button[@aria-label=\"לחץ על הכפתור על מנת להוסיף לעגלת הקניות\"]"));
	}
	

	public WebElement getPut() {
		return put;
	}


	public void setPut(WebElement put) {
		this.put = put;
	}


	public void putInCart(){
		try {
			getPut().click();
		} catch (Exception e) {
			System.out.println("stock page");
		}
		
		
	}

}
