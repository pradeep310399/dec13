package november22;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		//click the button to display the alert box
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Alertbox is displayed!!");
		System.out.println("************");

		
		//click the button to display the confirm box
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='result']")).getText();// to get thye text displayed after the button clicked
		System.out.println(text);
		System.out.println("Confirmbox is displayed!!");
		System.out.println("************");
		
		//click the button to display the prompt box
        driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		alert.sendKeys("Testleaf"); alert.accept();
		String text2 = driver.findElement(By.xpath("//p[@id='result1']")).getText();// to get thye text displayed after the button clicked
		System.out.println(text2);
		System.out.println("Promptbox is displayed!!");
		System.out.println("************");

		 
		//click the button to display learn linebreaks in an alert 
	    WebElement lineBreak = driver.findElement(By.xpath("//button[text()='Line Breaks?']"));
	    lineBreak.click();
	    alert.accept();
	    String text3 = lineBreak.getText();// to get thye text displayed after the button clicked
	    System.out.println(text3);
		System.out.println("************");

	   
		
		//click the button for sweet alert
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		System.out.println("sweet alert is handled");
		
	}

}
