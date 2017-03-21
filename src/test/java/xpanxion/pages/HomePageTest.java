package xpanxion.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

	HomePage homepage;
	
	@Parameters({ "path" })
	@BeforeClass
	public void testInit(String path) {

		// Load the page in the browser
		webDriver.get(websiteUrl + path);
		homepage = PageFactory.initElements(webDriver, HomePage.class);
	}

	@Test
	public void testTitle() throws InterruptedException {
		Assert.assertTrue(homepage.getTitle().equals("Xpanxion"), "Title is : " + homepage.getTitle());
	}

}
