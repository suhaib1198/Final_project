package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;
	WebElement searchTxtBox;
	WebElement searchBtn;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.searchTxtBox = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div[2]/input"));
		this.searchBtn = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div[2]/button"));
	}

	public void searchItem(String txt) throws InterruptedException {
		this.searchTxtBox.sendKeys(txt);
		Thread.sleep(5000);
		this.searchBtn.click();
		Thread.sleep(5000);

	}

}
