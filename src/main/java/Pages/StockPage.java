package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StockPage {
	WebDriver driver;
	WebElement put;
	WebElement exit;
	JavascriptExecutor js;

	public StockPage(WebDriver driver) {
		this.driver = driver;
		this.put = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div/div[1]/div[2]/button"));
		this.exit = driver.findElement(By.xpath("//*[@id=\"customized-dialog-title\"]/button"));
		this.js = (JavascriptExecutor) driver;
	}

	public void putInCart() throws InterruptedException {
		Thread.sleep(5000);
		put.click();
		Thread.sleep(5000);
	}

}
