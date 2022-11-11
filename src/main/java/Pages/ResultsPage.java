package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
	WebDriver driver;
	WebElement clk;
	JavascriptExecutor js;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.clk = driver.findElement(By.xpath("//*[@id=\"select-root\"]/div[2]/div[2]/div/div[1]/div/div[5]/a"));
		this.js = (JavascriptExecutor) driver;

	}

	public void Click() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(15000);
		clk.click();
		Thread.sleep(15000);
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
	}

}
