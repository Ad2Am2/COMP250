package finalproject;

import java.util.ArrayList;
import java.util.HashMap;

public class RatingByKeyword extends DataAnalyzer {

	private MyHashTable<String, int[]> wordByRating;
	
    public RatingByKeyword(Parser p) {
        super(p);
    }

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {

		keyword = keyword.toLowerCase().trim();

		MyHashTable<String, Integer> output = new MyHashTable<>();

		int[] ratingArray = wordByRating.get(keyword);
		if (ratingArray == null) return null;

		output.put("1", ratingArray[0]);
		output.put("2", ratingArray[1]);
		output.put("3", ratingArray[2]);
		output.put("4", ratingArray[3]);
		output.put("5", ratingArray[4]);

		return output;

	}

	@Override
	public void extractInformation() {

		this.wordByRating = new MyHashTable<>();

		for (int i = 0; i < parser.data.size(); i++) {

			ArrayList<String> wordsInComment = wordsInString(parser.data.get(i)[parser.fields.get("comments")]);
			int rating = (int) Double.parseDouble(this.parser.data.get(i)[parser.fields.get("student_star")]);

			for (String word : wordsInComment){

				if (wordByRating.get(word) == null) wordByRating.put(word, new int[] {0,0,0,0,0});

				if (rating == 1) wordByRating.get(word)[0]++;
				else if (rating == 2) wordByRating.get(word)[1]++;
				else if (rating == 3) wordByRating.get(word)[2]++;
				else if (rating == 4) wordByRating.get(word)[3]++;
				else if (rating == 5) wordByRating.get(word)[4]++;
				else throw new IllegalArgumentException("Wrong rating");

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
