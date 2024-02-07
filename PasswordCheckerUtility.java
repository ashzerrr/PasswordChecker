package projectOne;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ashton kabou
 * CMSC 204 
 * prof Aygun
 * @date 02/05/2024
 */
public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {

	}

	// This method compares the equality of two passwords
	/**
	 * 
	 */
	public static void comparePasswords(java.lang.String password, java.lang.String passwordConfirm)
			throws UnmatchedException {

		if (!password.equals(passwordConfirm)) { 			throw new UnmatchedException();
		}

	}

	// This method compares equality but returns true if equal and false

	public static boolean comparePasswordsWithReturn(java.lang.String password, java.lang.String passwordConfirm) {

		if (password.equals(passwordConfirm)) { // If equal return true else return false
			return true;
		} else {

			return false;
		}

	}

	// This method checks if the password has a valid length
	/**
	 * 
	 */
	public static boolean isValidLength(java.lang.String password) throws LengthException {

		if (password.length() >= 6) {			return true; 
		}
		throw new LengthException(); 
	}

	//This method checks if there is at least an Upper case character
	/**
	 * 
	 */
	public static boolean hasUpperAlpha​(java.lang.String password) throws NoUpperAlphaException {

		for (int i = 0; i < password.length(); i++) { 
			if (Character.isUpperCase(password.charAt(i))) { 
				return true; 
			}

		}
		throw new NoUpperAlphaException(); 

	}

	// This method checks if there is  at least one lower case character
	/**
	 * 
	 */
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException {

		for (int i = 0; i < password.length(); i++) { 
			if (Character.isLowerCase(password.charAt(i))) { 
				return true; 
			}

		}
		throw new NoLowerAlphaException(); 

	}

	// This method checks if within the string there is at least a digit
	/**
	 * 
	 */
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++) { 
			if (Character.isDigit(password.charAt(i))) { 
				return true; 
			}
		}
		throw new NoDigitException(); 
	}

	

	// This method checks if the password contains a special character
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*"); 
		Matcher matcher = pattern.matcher(password); 
		if ((!matcher.matches())) { 
			return true;
		} else {
			throw new NoSpecialCharacterException(); 
		}

	}

	// This method checks if there is more than 2 same characters in
	// the same sequence
	/**
	 * 
	 */
	public static boolean NoSameCharInSequence​(java.lang.String password) throws InvalidSequenceException {
		int counter = 0; 

		for (int i = 0; i < password.length(); i++) { 			if (i > 0) { 			
			if (password.charAt(i) == password.charAt(i - 1)) { 
				counter++; 
					if (counter >= 2) { 
						throw new InvalidSequenceException();
					}

				} else { 
					counter = 0;
				}
			}
		}

		return true;

	}

		//This method checks to see if other methods conditions are true
	public static boolean isValidPassword​(java.lang.String password) throws LengthException, NoUpperAlphaException,
			NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		boolean passwordIsValid = true; 
		if (!PasswordCheckerUtility.isValidLength(password)) { 
			passwordIsValid = false; 
			throw new LengthException(); 
		}

		if (!PasswordCheckerUtility.hasUpperAlpha​(password)) {
			passwordIsValid = false;
			throw new NoUpperAlphaException();
		}
		if (!PasswordCheckerUtility.hasLowerAlpha​(password)) {
			passwordIsValid = false;
			throw new NoLowerAlphaException();
		}
		if (!PasswordCheckerUtility.hasDigit​(password)) {
			passwordIsValid = false;
			throw new NoDigitException();
		}
		if (!PasswordCheckerUtility.hasSpecialChar(password)) {
			passwordIsValid = false;
			throw new NoSpecialCharacterException();
		}
		if (!PasswordCheckerUtility.NoSameCharInSequence​(password)) {
			passwordIsValid = false;
			throw new InvalidSequenceException();
		}

		return passwordIsValid; 

	}
	
	// This method checks if the password is within the 6-9 character requirement
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password) {
		if (password.length() >= 6 && password.length() <= 9) { 
			return true; 
		}
		return false;
	}

	
	// This method checks if the password is weak
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		try {
			if (PasswordCheckerUtility.isValidPassword​(password)
					&& PasswordCheckerUtility.hasBetweenSixAndNineChars​(password)) { 
																						
				throw new WeakPasswordException(); 
			}
		} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
				| NoSpecialCharacterException | InvalidSequenceException e) {

		} 

		return false; 
	}

	
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords​(
			java.util.ArrayList<java.lang.String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>(); // Create new arraylist called invalidpasswords
		for (int i = 0; i < passwords.size(); i++) { 
			try {
				PasswordCheckerUtility.isValidPassword​(passwords.get(i)); 
			} catch (Exception e) {
				invalidPasswords.add(passwords.get(i) + " " + e.getMessage()); 

			}
		}
		return invalidPasswords; 

	}

}