package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

	WebDriver driver;
	private WebElement submit;
	private WebElement em;
	private WebElement pass;
	private WebElement fc;
	private WebElement sc;

	public Login(WebDriver driver) {
		this.driver = driver;
		this.em = driver.findElement(By.id("login_email"));
		this.pass = driver.findElement(By.id("login_password"));
		this.submit = driver.findElement(By.xpath("//*[@id=\"login_using_email\"]/button"));
		this.fc = driver.findElement(By.xpath("//span[@aria-label=\"לחצו לכניסה לחשבון קיים\"]"));
		this.sc = driver.findElement(By.xpath("//span[@class=\"button_icon btn-login icon-email\"]"));
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	public WebElement getEm() {
		return em;
	}

	public void setEm(WebElement em) {
		this.em = em;
	}

	public WebElement getPass() {
		return pass;
	}

	public void setPass(WebElement pass) {
		this.pass = pass;
	}

	public WebElement getFc() {
		return fc;
	}

	public void setFc(WebElement fc) {
		this.fc = fc;
	}

	public WebElement getSc() {
		return sc;
	}

	public void setSc(WebElement sc) {
		this.sc = sc;
	}

	public void login(String email, String password) {
		try {
			getFc().click();
			getSc().click();
			getEm().sendKeys(email);
			getPass().sendKeys(password);
			getSubmit().click();
		} catch (Exception e) {
			System.out.println("login ");
		}

	}

}
