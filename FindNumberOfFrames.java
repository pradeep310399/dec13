package november30;

import java.awt.Frame;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.model.FrameScheduledNavigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class FindNumberOfFrames {
	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.leafground.com/pages/frame.html");
		// FIND THE NUMBER OF FRAMES
		List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
		int size = outerframe.size();
		System.out.println(size+" frames are in outerframes");
		for(int i=0;i<outerframe.size();i++) {
			
	
			driver.switchTo().frame(outerframe.get(i));//0,1,2
			List<WebElement> innerFrame = driver.findElements(By.tagName("iframe"));//0,1,1
					size = size + innerFrame.size();//3+0=3+1=4+1=5
					driver.switchTo().defaultContent();
	}
		System.out.println("Totally "+size+" frames are in page");
		
	}

}
