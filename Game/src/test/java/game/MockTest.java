package game;

import java.io.BufferedReader;

import static org.easymock.EasyMock.*;

import org.easymock.IExpectationSetters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MockTest {

	BufferedReader mock;
	User user;

	@BeforeMethod
	public void setUp() throws Exception {
		mock = createMock(BufferedReader.class);
		user = new User(2);
	}

	@Test
	public void checkBuffer() throws Exception {
		String word = "Харьков";
		expect(mock.readLine()).andReturn(word);
	
		replay(mock);
		
		Assert.assertEquals('В', Players.checkLastLetter(word));
		
		verify(mock);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		user = null;
		mock = null;
	}
}
