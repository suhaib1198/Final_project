package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

	WebDriver driver;
	JavascriptExecutor js;
	WebElement submit;
	WebElement em;
	WebElement pass;

	public Login(WebDriver driver) {
		this.driver = driver;
		this.em = driver.findElement(By.id("login_email"));
		this.pass = driver.findElement(By.id("login_password"));
		this.submit = driver.findElement(By.xpath("//*[@id=\"login_using_email\"]/button"));
	}

	public void login(String email, String password) throws InterruptedException {
		em.sendKeys(email);
		Thread.sleep(5000);
		pass.sendKeys(password);
		Thread.sleep(5000);
		submit.click();
		Thread.sleep(5000);
	}

}
