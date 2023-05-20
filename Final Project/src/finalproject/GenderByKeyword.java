package finalproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GenderByKeyword extends DataAnalyzer {

	private MyHashTable<String, int[]> wordByGender;

	public GenderByKeyword(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {

		keyword = keyword.toLowerCase().trim();

		MyHashTable<String, Integer> output = new MyHashTable<>();

		int[] genderArray = wordByGender.get(keyword);
		if (genderArray == null) return null;

		output.put("M", genderArray[0]);
		output.put("F", genderArray[1]);
		output.put("X", genderArray[2]);

		return output;

	}

	@Override
	public void extractInformation() {

		this.wordByGender = new MyHashTable<>();

		for (int i = 0; i < parser.data.size(); i++) {

			ArrayList<String> wordsInComment = wordsInString(parser.data.get(i)[parser.fields.get("comments")]);
			String gender = this.parser.data.get(i)[parser.fields.get("gender")];

			for (String word : wordsInComment){

				if (wordByGender.get(word) == null) wordByGender.put(word, new int[] {0,0,0});

				if (gender.equals("M")) wordByGender.get(word)[0]++;
				else if (gender.equals("F")) wordByGender.get(word)[1]++;
				else if (gender.equals("X")) wordByGender.get(word)[2]++;
				else throw new IllegalArgumentException("Wrong gender");

			}

		}


	}


	private ArrayList<String> wordsInString(String input) {

		String newString = "";
		input = input.toLowerCase();
		ArrayList<String> words = new ArrayList<>();

		for (int i = 0; i < input.length(); i++) {
			if (!Character.isLetter(input.charAt(i)) && input.charAt(i) != '\'') newString += " ";
			else newString += input.charAt(i);
		}

		String currentWord = "";

		for (int i = 0; i < newString.length(); i++) {

			if (newString.charAt(i) == ' ') {
				if (!currentWord.equals("")) words.add(currentWord);
				currentWord = "";
			}
			else currentWord += newString.charAt(i);

		}

		if (!currentWord.equals("")) words.add(currentWord);
		return words;

	}

}
