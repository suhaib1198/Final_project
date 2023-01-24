package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage {
	WebDriver driver;
	private WebElement clk;
	JavascriptExecutor js;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.clk = driver.findElement(
				By.xpath("//*[@id=\"select-root\"]/div[2]/div[2]/div/div[1]/div/div[1]/div/a/div[2]/img "));
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getClk() {
		return clk;
	}

	public void setClk(WebElement clk) {
		this.clk = clk;
	}

	public void Click() throws InterruptedException {
		try {
			js.executeScript("window.scrollBy(0,750)", "");
			getClk().click();
			js.executeScript("window.scrollBy(0,550)", "");
		} catch (Exception e) {
			System.out.println("result page");
		}

	}
}
