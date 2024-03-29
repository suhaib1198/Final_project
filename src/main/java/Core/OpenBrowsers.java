package Core;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class OpenBrowsers {
	public static WebDriver openFFWithOptions() {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		String downloadFilepath = "downloads";
		File file = new File(downloadFilepath);
		
		FirefoxProfile profile = new FirefoxProfile();
		 
        // Instructing firefox to use custom download location
        profile.setPreference("browser.download.folderList", 2);
 
        // Setting custom download directory
        profile.setPreference("browser.download.dir", file.getAbsolutePath());
 
        // Skipping Save As dialog box for types of files with their MIME
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
 
        // Creating FirefoxOptions to set profile
        FirefoxOptions option = new FirefoxOptions();
        option.setProfile(profile);
        option.setHeadless(true);
        // Launching browser with desired capabilities

		driver = new FirefoxDriver(option);
		return driver;
	}
	
	public static WebDriver openBrowser(String browser) {

		WebDriver driver;
		if(browser.equals("firefox")) {
			//Setting webdriver.gecko.driver property
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

			//Instantiating driver object and launching browser
			driver = new FirefoxDriver();
		}else if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

			//Instantiating driver object
			driver = new ChromeDriver();
		}else if(browser.equals("edge")) {
			System.setProperty(
					"webdriver.edge.driver",
					"./drivers/msedgedriver.exe");
			// Instantiate a ChromeDriver class.
			driver = new EdgeDriver();
		}else {
			driver = null;
		}

		return driver;
	}

	public static void main(String[] args) throws InterruptedException, IOException {
	}
}