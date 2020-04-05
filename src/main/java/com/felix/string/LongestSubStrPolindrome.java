package com.felix.string;

/**
 * @author ravudari
 *
 */
public class LongestSubStrPolindrome {
	int startIndex = 0;
	int endIndex = 0;

	public static void main(String[] args) {
		var obj = new LongestSubStrPolindrome();

		var string = "abacamadamfedldeljldleaabba1122332211";
		obj.findLongestSubStrPolindrome(string);

		string = "11rajujar";
		obj.findLongestSubStrPolindrome(string);
	}

	private String findLongestSubStrPolindrome(String string) {
		System.out.println("Checking Polindromes in " + string);
		for (int i = 0; i < string.length(); i++) {
			findPolindromeIndices(string, i, i);
			findPolindromeIndices(string, i, i + 1);
		}
		var polindromeStr = string.substring(startIndex, endIndex);
		System.out.println("Longest Polindrome in '" + string + "' is: '" + polindromeStr + "'");

		this.resetIndices();
		return polindromeStr;
	}

	private void findPolindromeIndices(String string, int leftIndex, int rightIndex) {
		while (leftIndex >= 0 && rightIndex < string.length()) {
			if (string.charAt(leftIndex) != string.charAt(rightIndex)) {
				break;
			}
			leftIndex--;
			rightIndex++;
		}

		if (endIndex - startIndex < rightIndex - leftIndex - 1) {
			startIndex = leftIndex + 1;
			endIndex = rightIndex;
		}
	}

	private void resetIndices() {
		startIndex = 0;
		endIndex = 0;
	}
}
