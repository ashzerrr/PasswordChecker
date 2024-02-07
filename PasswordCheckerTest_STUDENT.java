package projectOne;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 



public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String password1, password2;

	@Before
	public void setUp() throws Exception {
		String[] p = { "57384AA#", "arman5SSS!", "2Bob!", "amir68", "may80", "c7bJs", "BananazannKKmm!", "dd87Kc",
				"armanLovesSchool", "JJJ@bn10!" };
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p)); 
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Tests if the password is less than 6 characters long and throw an exception if not
	 * 	
	 *  
	 */
	@Test
	public void testIsValidPasswordLength() throws NoUpperAlphaException, NoLowerAlphaException, NoDigitException,
			NoSpecialCharacterException, InvalidSequenceException, LengthException {
		
		assertTrue(PasswordCheckerUtility.isValidPassword​("Ashtonjosh@2002"));

				try {
			PasswordCheckerUtility.isValidPassword​("abc");
			fail("Expected LengthException");
		} catch (LengthException e) {
					}
	}

	/**
	 * Test if the password has at least one uppercase alpha and throw an exception if not
	 
	 */
	@Test
	public void testIsValidPasswordUppercase() throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
			NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
				assertTrue(PasswordCheckerUtility.isValidPassword​("Rtifhg!493"));

		try {
			PasswordCheckerUtility.isValidPassword​("5758492");
			fail("Expected NoUpperAlphaException");
		} catch (NoUpperAlphaException e) {
			
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha and throw an exception if not
	 */
	@Test
	public void testIsValidPasswordLowercase() throws LengthException, NoUpperAlphaException, NoDigitException,
			NoSpecialCharacterException, InvalidSequenceException, NoLowerAlphaException {
				assertTrue(PasswordCheckerUtility.isValidPassword​("Oplktg!861"));

		try {
			PasswordCheckerUtility.isValidPassword​("754834T");
			fail("Expected NoLowerAlphaException");
		} catch (NoLowerAlphaException e) {

		}
	}

	
	@Test
	public void testIsValidPasswordSpecialCharacter() throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, InvalidSequenceException, NoSpecialCharacterException {

		assertTrue(PasswordCheckerUtility.isValidPassword​("Klengb!789"));

		try {
			PasswordCheckerUtility.isValidPassword​("Rtnkjv640");
			fail("Expected NoSpecialCharacterException");
		} catch (NoSpecialCharacterException e) {

		}
	}

	/**
	 * This test the isWeakPassword method
	 */
	@Test
	public void testIsWeakPassword() {
		try {

			PasswordCheckerUtility.isWeakPassword("4321V$h");
			assertTrue("Did not throw WeakPassword", false);
		} catch (WeakPasswordException e) {
			assertTrue("NoLowerAlphaExcepetion", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect one", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence and throw an exception if so
	 
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("321JJJ!g3"));
			assertTrue("Expected InvalidSequenceException but dont throw that", false);
		} catch (InvalidSequenceException e) {
			
			assertTrue("threw a InvalidSequenceException", true);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			assertTrue("Threw some other exception", false);
		}
	}

	/**
	 * Test if the password has at least one digit and throw an exception if not
	 */
	@Test
	public void testIsValidPasswordNoDigit() throws LengthException, NoUpperAlphaException, NoLowerAlphaException,
			NoSpecialCharacterException, InvalidSequenceException {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Awelyt!LJG"));
			assertTrue("Expected NoDigitException, but didn't throw it", false);
		} catch (NoDigitException e) {
			
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception", false);
		}

		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Ahfcng!"));

			assertTrue("Expected NoDigitException, but didn't throw it", false);
		} catch (NoDigitException e) {
			
			assertTrue("Successfully threw a NoDigitException", true);
		} catch (Exception e) {
			
			
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception", false);
		}
	}

	/**
	 * Test correct passwords and throw an exception if incorrect
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		// Test multiple valid passwords that should not throw exceptions
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword​("Azntrg&671"));
			assertTrue(PasswordCheckerUtility.isValidPassword​("ArmanB$874"));
			assertTrue(PasswordCheckerUtility.isValidPassword​("GoodPSDPss1!"));
			assertTrue(PasswordCheckerUtility.isValidPassword​("ArmanPwd123!"));
		} catch (Exception e) {
			
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	/**
	 * Test the invalidPasswords method Check the results of the ArrayList returned 
	 */
	@Test
	public void testGetInvalidPasswords() {

		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords​(passwords);

		Scanner scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "57384AA#");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));

		scan = new Scanner(results.get(1));
		assertEquals(scan.next(), "arman5SSS!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence"));

		scan = new Scanner(results.get(2));
		assertEquals(scan.next(), "2Bob!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));

		scan = new Scanner(results.get(3));
		assertEquals(scan.next(), "amir68");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));

		scan = new Scanner(results.get(5));
		assertEquals(scan.next(), "c7bJs");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));

		scan = new Scanner(results.get(6));
		assertEquals(scan.next(), "BananazannKKmm!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));

		scan = new Scanner(results.get(7));
		assertEquals(scan.next(), "dd87Kc");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));

		scan = new Scanner(results.get(8));
		assertEquals(scan.next(), "armanLovesSchool");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));

		scan = new Scanner(results.get(9));
		assertEquals(scan.next(), "JJJ@bn10!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence"));

	}

}