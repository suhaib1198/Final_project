package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;
	private WebElement loginlogo;
	private WebElement searchTxtBox;
	private WebElement searchBtn;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.loginlogo = driver.findElement(By.xpath("//a[@target=\"_self\"]"));
		this.searchTxtBox = driver.findElement(By.xpath("//div[@id=\"site-header\"]/div[2]/div[2]/input"));
		this.searchBtn = driver.findElement(By.xpath("//button[@aria-label=\"לחץ לחיפוש\"]"));
	}

	public WebElement getLoginlogo() {
		return loginlogo;
	}

	public void setLoginlogo(WebElement loginlogo) {
		this.loginlogo = loginlogo;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public void setSearchTxtBox(WebElement searchTxtBox) {
		this.searchTxtBox = searchTxtBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	public void searchItem(String txt) throws InterruptedException {
		try {
			getSearchTxtBox().sendKeys(txt);
			getSearchBtn().click();
		} catch (Exception e) {
			System.out.println("home page search item");
		}
	}

	public void togo() throws InterruptedException {
		try {
			getLoginlogo().click();
		} catch (Exception e) {
			System.out.println("home page togo");
		}
	}
}
