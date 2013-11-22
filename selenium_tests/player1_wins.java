package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class player1_wins {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:4567/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testPlayer1_wins() throws Exception {
		selenium.open("/");
		selenium.click("id=field2");
		selenium.click("id=field1");
		selenium.click("id=field0");
		selenium.click("id=field3");
		selenium.click("id=field5");
		selenium.click("id=field8");
		selenium.click("id=field7");
		selenium.click("id=field4");
		selenium.click("id=field6");
		assertEquals("Jafntefli, skammist ykkar!", selenium.getAlert());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
