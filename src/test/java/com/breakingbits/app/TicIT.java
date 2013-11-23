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

public class TicIT {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:4567/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testTie() throws Exception {
		selenium.open("/");
		selenium.type("id=player1", "test1");
		selenium.click("id=enterPlayer1");
		selenium.type("id=player2", "test2");
		selenium.click("id=enterPlayer2");
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

	@Test
	public void testPlayer1Wins() throws Exception {
		selenium.open("/");
		selenium.type("id=player1", "test1");
		selenium.click("id=enterPlayer1");
		selenium.type("id=player2", "test2");
		selenium.click("id=enterPlayer2");
		selenium.click("id=field0");
		selenium.click("id=field1");
		selenium.click("id=field4");
		selenium.click("id=field5");
		selenium.click("id=field8");
		assertEquals("test1 Vann leikinn, in yo face sucka!", selenium.getAlert());
	}
	
	@Test
	public void testPlayer2Wins() throws Exception {
		selenium.open("/");
		selenium.type("id=player1", "test1");
		selenium.click("id=enterPlayer1");
		selenium.type("id=player2", "test2");
		selenium.click("id=enterPlayer2");
		selenium.click("id=field0");
		selenium.click("id=field1");
		selenium.click("id=field5");
		selenium.click("id=field4");
		selenium.click("id=field6");
		selenium.click("id=field7");
		assertEquals("test2 Vann leikinn, in yo face sucka!", selenium.getAlert());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
