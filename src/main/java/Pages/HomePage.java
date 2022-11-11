package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;
	WebElement loginlogo;
	WebElement searchTxtBox;
	WebElement searchBtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.loginlogo = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div[3]/a[1]/button/span[1]/div"));
	this.searchTxtBox = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div[2]/input"));
	this.searchBtn = driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div[2]/button"));
	}
	


public void searchItem(String txt) throws InterruptedException {
	this.searchTxtBox.sendKeys(txt);
	Thread.sleep(5000);
	this.searchBtn.click();
	Thread.sleep(5000);

}

	public void togo() throws InterruptedException {
		Thread.sleep(5000);
		loginlogo.click();
		Thread.sleep(5000);
	}

}
