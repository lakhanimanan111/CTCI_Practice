/*

Assumptions:
1. String is an ASCII string i.e. there are total 128 unique characters
2. n is the length of input string

*/
package com.ctci.arrayString;

class IsUnique {

	public static void main(String [] args) {
		String test = "Man";
		System.out.println("Time complexity O(n), Space complexity O(n): " + isUnique(test));	
		System.out.println("Time complexity O(n^2), Space complexity O(1): " + isUniqueTwo(test));	
	}
	
	public static boolean isUnique(String test) {
		if(test.length() > 128)
			return false;
		
		boolean exist[] = new boolean[128];
		
		for(int i = 0; i < test.length(); i++) {
			int ascVal = test.charAt(i);
			if(exist[ascVal])
				return false;
			exist[ascVal] = true;
		}
	
		return true;
	}
	
	public static boolean isUniqueTwo(String test) {
		int length = test.length();
		if(length == 0 || length == 1)
			return true;
		
		for(int i = 0; i < length; i++) {
			char a = test.charAt(i);
			String subStr = test.substring(i+1, length);
			if(subStr != null && subStr.indexOf(a) != -1)
				return false;
			else if(subStr.isEmpty()) 
				return true;
		}
		return true;
	}

}