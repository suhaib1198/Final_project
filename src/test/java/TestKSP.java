import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Core.OpenBrowsers;
import Core.ReadCsvFile;
import Core.TakeScreenShot;
import Core.WriteCsvFile;
import Pages.AddingToCart;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ItemPage;
import Pages.Login;
import Pages.PersonalInfo;
import Pages.ResultsPage;
import Pages.StockPage;

public class TestKSP {
	WebDriver driver;
	ResultsPage result;
	ItemPage items;
	StockPage stock;
	AddingToCart add;
	CartPage cart;
	ArrayList<String> outputHeaders = new ArrayList<String>();
	ArrayList<String[]> outputData = new ArrayList<String[]>();
	HomePage home;
	Properties prop;
	Login log;
	PersonalInfo info;
	String myName;
	String givenName;
	TakeScreenShot takeScr;

	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		driver = OpenBrowsers.openBrowser("chrome");
		outputHeaders.add("item");
		outputHeaders.add("price from search");
		outputHeaders.add("price from cart");
		driver.manage().window().maximize();
		

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://ksp.co.il/web/");
		takeScr = new TakeScreenShot(driver);
		home = new HomePage(driver);
	}

	@DataProvider(name = "Data")
	public static Object[][] getData() throws Exception {
		List<String[]> lines = ReadCsvFile.readAllLines("./files/input.csv");
		lines.remove(0);
		Object[][] data = new Object[lines.size()][lines.get(0).length];
		int index = 0;
		for (String[] line : lines) {
			data[index] = line;
			index++;
		}
		return data;
	}

	@Test(dataProvider = "Data")
	public void test1(String item) throws InterruptedException, IOException {
		home.searchItem(item);
		result = new ResultsPage(driver);
		result.Click();
		takeScr.takeScreenShot("./ScreenShots/"+item+"Search"+".png");
		items = new ItemPage(driver);
		items.getCart();
		takeScr.takeScreenShot("./ScreenShots/"+item+"Avilable"+".png");
		String listItem = items.getPriceItem();
		stock = new StockPage(driver);
		stock.putInCart();
		add = new AddingToCart(driver);
		add.add();
		cart = new CartPage(driver);
		String listCard = cart.getPriceCart();
		takeScr.takeScreenShot("./ScreenShots/"+item+"Card"+".png");
		cart.close();
		String[] data = { item, listItem, listCard };
		outputData.add(data);
		Assert.assertEquals(listItem, listCard);

	}

	@Test(dependsOnMethods = "test1")
	public void test2() throws IOException, InterruptedException {
		prop = new Properties();
		FileReader readFile = new FileReader("./files/cred.properities");
		prop.load(readFile);
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		home.togo();
		log = new Login(driver);
		log.login(email, password);
		info = new PersonalInfo(driver);
		myName="suhaib";
		givenName=info.Hello().substring(0, myName.length());
		Assert.assertEquals(givenName,myName );
		
	}
	@AfterSuite
	public void afterSuite() {
		driver.quit();
		String[] headers = new String[outputHeaders.size()];
		for (int i = 0; i < outputHeaders.size(); i++) {
			headers[i] = outputHeaders.get(i);
		}
		WriteCsvFile.writeDataLineByLine("./files/output.csv", outputData, headers);
	}

}
