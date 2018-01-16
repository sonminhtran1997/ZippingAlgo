import cse332.types.AlphabeticString;
import datastructures.dictionaries.HashTrieMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTrieMap<Character, AlphabeticString, String> STUDENT;
		STUDENT = new HashTrieMap<>(AlphabeticString.class);
		// AlphabeticString keyA = new AlphabeticString("keyboard");
		// AlphabeticString keyB = new AlphabeticString("keyesian");
		// AlphabeticString keyC = new AlphabeticString("bayesian");
		// STUDENT.insert(keyA, "KEYBOARD");
		// STUDENT.insert(keyB, "KEYESIAN");
		// STUDENT.insert(keyC, "BAYESIAN");
		// STUDENT.delete(keyA);
		// STUDENT.delete(keyB);
		// STUDENT.delete(keyC);
		STUDENT.insert(new AlphabeticString("a"), "A");
        STUDENT.insert(new AlphabeticString("b"), "B");

        STUDENT.delete(new AlphabeticString("a"));
        STUDENT.insert(new AlphabeticString("b"), "BB");
		System.out.println("");

	}

}
