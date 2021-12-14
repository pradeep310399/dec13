package december13;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandles {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		
		Set<String> winSet = driver.getWindowHandles();//return type of getwindowhandles is Set
		List<String> name = new ArrayList<String>(winSet);
		String title = driver.getTitle();
		System.out.println("Before Title:"+title);
		
		//get or we can access the windows either by creating variable or directly we should give in the bracket
		/*
		 * String windows = name.get(1); driver.switchTo().window(windows);
		 */
		// driver.switchTo().window(null) --> accepts the window hanlde
		driver.switchTo().window(name.get(1));
		String title2 = driver.getTitle();
		System.out.println("AFter Title:"+title2);
		driver.switchTo().window(name.get(0));
		String title3 = driver.getTitle();
		System.out.println("coming back to title:"+title3);
		System.out.println("Number of windows:" +winSet.size());
		
		driver.close();
		System.out.println("closed the window except current one");
		driver.quit();
		System.out.println("closed all the windows");
	}

}
