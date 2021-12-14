package december2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/frame.html");
		
		//	inside frame
	    WebElement frame1 = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[1]"));
	    driver.switchTo().frame(frame1);
	    driver.findElement(By.xpath("//button[@id='Click']")).click();
	    String text = driver.findElement(By.xpath("//button[@id='Click']")).getText();
	    System.out.println(text);
	    driver.switchTo().defaultContent();
	    System.out.println("I AM INSIDE A FRAME");
	    System.out.println("*******************");
	
	
	    // Nested Frames

			WebElement frame2 = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[2]"));
			driver.switchTo().frame(frame2);

			// into the nested frame
			driver.switchTo().frame("frame2");
			driver.findElement(By.id("Click1")).click();
			String text2 = driver.findElement(By.xpath("//button[@id='Click1']")).getText();
			System.out.println(text2);
			driver.switchTo().defaultContent();

			WebElement frame3 = driver.findElement(By.xpath("(//div[@id='wrapframe']/iframe)[3]"));
			driver.switchTo().frame(frame3);
			// Nested frame
			driver.switchTo().frame("frame2");
			System.out.println("I AM INSIDE A NESTED FRAME");
			System.out.println("***************************");
			
			
	
		
	}

}
