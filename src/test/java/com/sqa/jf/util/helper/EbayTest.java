package com.sqa.jf.util.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

import com.sqa.jf.util.helper.SelUtil.*;

public class EbayTest {

	final static String BASE_URL = "http://ebay.com";

	WebDriver driver;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@Test
	public void ebayTest() {
		WebDriver driver = new FirefoxDriver();
		this.driver.get(BASE_URL + "/");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.id("userid")).clear();
		this.driver.findElement(By.id("userid")).sendKeys("mallaprechristian@gmail.com");
		this.driver.findElement(By.id("pass")).clear();
		this.driver.findElement(By.id("pass")).sendKeys("dummy123");
		SelUtil.gotoAndClick(driver, "csi");
		SelUtil.superClick(driver,
				"csi:sgnBt:gh-cart-i:Fossil Dean Chronograph Black Dial Men's Brown Leather Watch FS4828:gh-eb:My eBay:a.vip.item-title:gh-eb:My eBay:Wish list:ttl_172102243053:html"
						.split(":"),
				new SelUtil.STRATEGY[] { STRATEGY.ID, STRATEGY.ID, STRATEGY.ID, STRATEGY.TEXT, STRATEGY.ID,
						STRATEGY.TEXT, STRATEGY.CSS, STRATEGY.ID, STRATEGY.TEXT, STRATEGY.TEXT, STRATEGY.ID,
						STRATEGY.CSS });
	}
}
