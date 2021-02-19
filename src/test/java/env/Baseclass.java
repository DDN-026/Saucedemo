package env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;




public class Baseclass {
	
	public static WebDriver driver;
	
	

	
	public static WebDriver InitialiseSelenium(String url) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\saucedemo\\src\\test\\resources\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		return driver;
			
		
	}
	public static void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("some exception occurred while quitting the browser");
		}
	}

	public static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("some exception occurred while closing the browser");
		}
	}
	
	public  static String getData(int rowno,int cellNo) throws Throwable {

		File loc= new File("C:\\Users\\DELL\\Desktop\\Datasheet.xlsx");
		
		FileInputStream stream = new FileInputStream(loc);
		
		Workbook w=new XSSFWorkbook(stream);
		
		Sheet s =w.getSheet("Sheet1");
		
		Row r= s.getRow(rowno);
		
		String c=r.getCell(cellNo).getStringCellValue();		
		System.out.println(c);
		
		return c;
		
	}
	public static void sendkeys(By by,String text) {
		waitforvisibilityofElement(by);
		WebElement ele = driver.findElement(by);
		ele.sendKeys(text);
	}
	
public static void waitforvisibilityofElement(By element) {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
public static void click(By by) {
	waitforvisibilityofElement(by);
	WebElement ele = driver.findElement(by);
	ele.click();
}

public static String Assert(String actual,String expected) {
	SoftAssert softassert = new SoftAssert();

	softassert.assertEquals(actual,expected);

	if(actual.equalsIgnoreCase(expected)) {
		System.out.println("Assertion passed");
	}else {
			System.out.println("Assertion failed");
		}
		return actual;
}
	
	
public static String getText(By by) {
	WebElement ele = driver.findElement(by);
	String text = ele.getText();
	System.out.println("text is" +text);
	return text;
	
}	
public static void maximize() {
	
	driver.manage().window().maximize();
}	

public static void javascriptclick(By by) {
	WebElement element = driver.findElement(by);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
}	

public static void takeSnapShot() throws Exception{

   

    TakesScreenshot scrShot =((TakesScreenshot)driver);

   

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);


            Date d = new Date();
            System.out.println(d.toString());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 

            File DestFile=new File("C:\\Users\\DELL\\eclipse-workspace\\saucedemo\\src\\test\\resources\\Screenshot\\durga1"+sdf.format(d)+".png");

           

            FileUtils.copyFile(SrcFile, DestFile);

}


}
