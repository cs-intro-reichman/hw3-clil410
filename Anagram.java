/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		System.out.println("abc and " + randomAnagram("abc") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
		}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcessWithoutSpaces(str1);
		str2 = preProcessWithoutSpaces(str2);
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			for (int j =0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					j = str2.length();
				} 
				if (j == str2.length() -1) {
					return false;
				}
			}
		}
		return true; 
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int i =0;
		String ans = "";
		while ( i < str.length()) {
			char c = (char) (str.charAt(i));
			if (c == 32) {
				ans = ans + " ";
			}
			if ((c >= 97) && (c <= 122)) { 
				ans = ans + c;
				i++;
			} 
			else {
				if ((c >= 65) && (c <= 90)) { 
					c = (char) (c+32);
					ans = ans + c;
					i++;
				} else {
					i++;
				}
			} 
		}
		return ans;
	} 
	   
	public static String preProcessWithoutSpaces(String str) {
		int i =0;
		String ans = "";
		while ( i < str.length()) {
			char c = (char) (str.charAt(i));
			if ((c >= 97) && (c <= 122)) { 
				ans = ans + c;
				i++;
			} 
			else {
				if ((c >= 65) && (c <= 90)) { 
					c = (char) (c+32);
					ans = ans + c;
					i++;
				} else {
					i++;
				}
			} 
		}
		return ans;
	} 
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randStr = ""; 
		String remainStr = str;
		while (remainStr. length() > 0) {		
			int rand = (int) (Math.random() * remainStr.length());
			randStr += (char) (remainStr.charAt(rand));
			String newRemain = "";
			for (int i=0; i < remainStr.length(); i++) {
				if (i != rand) {
					newRemain += remainStr.charAt(i);
				}
			}
			remainStr = newRemain;
		}
		return randStr;
	}
}