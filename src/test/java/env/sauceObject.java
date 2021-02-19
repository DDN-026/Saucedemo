package env;
import org.openqa.selenium.By;

public class sauceObject {

	
	
	public static final By username =By.xpath("//input[@id='user-name']");
			
	public static final By password =By.xpath("//input[@id='password']");
	
	public static final By login_btn =By.xpath("//input[@id='login-button']");
	
	public static final By Addtocart_1 =By.xpath("//button[@class='btn_primary btn_inventory'][1]");
	public static final By Addtocart_2 =By.xpath("//button[@class='btn_primary btn_inventory'][2]");
	
	public static final By shop_baskt =By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
	public static final By checkout =By.xpath("//a[@class='btn_action checkout_button']");
	public static final By first_name =By.xpath("//input[@id='first-name']");
	public static final By postal_code =By.xpath("//input[@id='postal-code']");
	public static final By last_name =By.xpath("//input[@id='last-name']");
	public static final By continue_btn =By.xpath("//input[@class='btn_primary cart_button']");
	public static final By finish_btn =By.xpath("//a[text()='FINISH']");
	public static final By shipping_info =By.xpath("//div[text()='Shipping Information:']");
	public static final By home_btn =By.xpath("//button[text()='Open Menu']");
	public static final By logout_btn =By.xpath("//a[@id='logout_sidebar_link']");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
