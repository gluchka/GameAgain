package game;

import static org.easymock.EasyMock.createMock;

import java.io.BufferedReader;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainMethodsTest {

	private static final Logger log = Logger.getLogger(User.class);

	User user;

	@DataProvider
	public Object[][] testLastLetter() {
		return new Object[][] { new Object[] { 'В', "Харьков" },
				new Object[] { 'Г', "Кременчуг" }, };
	}

	@Test(dataProvider = "testLastLetter")
	public void getLastTest(char last, String word) {
		char expected = last;
		char actual = Players.checkLastLetter(word);
		Assert.assertEquals(expected, actual);
		log.info("assertion true for testLastLetter");
	}

	@DataProvider
	public Object[][] checkUsersInList() {
		return new Object[][] { new Object[] { 2, 2 }, new Object[] { 5, 7 }, };
	}

	@Test(dataProvider = "checkUsersInList")
	public void checkWordInList(int countOfUsers, int exp) {
		user = new User(countOfUsers);
		int expected = exp;
		user.addUsers();
		int actual = user.users.size();
		Assert.assertEquals(expected, actual);
		log.info("assertion true for checkWordInList");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		user = null;
	}
}