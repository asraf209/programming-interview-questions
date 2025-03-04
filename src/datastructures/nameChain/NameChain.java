package datastructures.nameChain;

import java.util.HashMap;
import java.util.Map;

public class NameChain {
	public static int getMaxNameChainLength(String[] firstNames, String[] lastNames) {
		Map<String, String> nameMap = new HashMap<>();
		for (int i=0; i<firstNames.length; i++) {
			nameMap.put(firstNames[i], lastNames[i]);
		}

		int maxLength = 1;
		for (String firstName : nameMap.keySet()) {
			maxLength = Math.max(maxLength, getMaxLengthFrom(nameMap, firstName));
		}

		return maxLength;
	}

	public static int getMaxLengthFrom(Map<String, String> nameMap, String firstName) {
		int length = 0;
		while(nameMap.get(firstName)!=null) {
			length++;
			firstName = nameMap.get(firstName);
		}

		return length;
	}

	public static void main(String[] args) {
		String[] firstNames = {"bob", "ross", "lary", "taylor"};
		String[] lastNames = {"ross", "taylor", "page", "griffin"};
		System.out.println(getMaxNameChainLength(firstNames, lastNames));
	}
}
