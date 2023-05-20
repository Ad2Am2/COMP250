package finalproject;

import java.util.ArrayList;

public class RatingByGender extends DataAnalyzer{

	private MyHashTable<String, int[]> genderByQuality;
	private MyHashTable<String, int[]> genderByDifficulty;

	private MyHashTable<String, int[]> wordByGender;

	public RatingByGender(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {

		keyword = keyword.toLowerCase().trim();

		MyHashTable<String, Integer> output = new MyHashTable<>();

		int[] ratingCounts = {0,0,0,0,0};

		ArrayList<String> words = wordsInString(keyword);

		if (!(words.get(0).equals("m") || words.get(0).equals("f"))) return null;
		else if (words.get(0).equals("m")) {
			if (!(words.get(1).equals("quality") || words.get(1).equals("difficulty"))) return null;
			else if (words.get(1).equals("quality")) ratingCounts = genderByQuality.get("M");
			else if (words.get(1).equals("difficulty")) ratingCounts = genderByDifficulty.get("M");
		}
		else if (words.get(0).equals("f")) {
			if (!(words.get(1).equals("quality") || words.get(1).equals("difficulty"))) return null;
			else if (words.get(1).equals("quality")) ratingCounts = genderByQuality.get("F");
			else if (words.get(1).equals("difficulty")) ratingCounts = genderByDifficulty.get("F");
		}

		output.put("1", ratingCounts[0]);
		output.put("2", ratingCounts[1]);
		output.put("3", ratingCounts[2]);
		output.put("4", ratingCounts[3]);
		output.put("5", ratingCounts[4]);

		return output;

	}

	@Override
	public void extractInformation() {

		this.genderByQuality = new MyHashTable<>();

		for (int i = 0; i < parser.data.size(); i++) {

			String gender = parser.data.get(i)[parser.fields.get("gender")];
			int rating = (int) Double.parseDouble(this.parser.data.get(i)[parser.fields.get("student_star")]);

			if (genderByQuality.get(gender) == null) genderByQuality.put(gender, new int[] {0,0,0,0,0});
			int[] genderRatings = genderByQuality.get(gender);

			if (rating == 1) genderRatings[0]++;
			if (rating == 2) genderRatings[1]++;
			if (rating == 3) genderRatings[2]++;
			if (rating == 4) genderRatings[3]++;
			if (rating == 5) genderRatings[4]++;


		}

		this.genderByDifficulty = new MyHashTable<>();

		for (int i = 0; i < parser.data.size(); i++) {

			String gender = parser.data.get(i)[parser.fields.get("gender")];
			int rating = (int) Double.parseDouble(this.parser.data.get(i)[parser.fields.get("student_difficult")]);

			if (genderByDifficulty.get(gender) == null) genderByDifficulty.put(gender, new int[] {0,0,0,0,0});
			int[] genderRatings = genderByDifficulty.get(gender);

			if (rating == 1) genderRatings[0]++;
			if (rating == 2) genderRatings[1]++;
			if (rating == 3) genderRatings[2]++;
			if (rating == 4) genderRatings[3]++;
			if (rating == 5) genderRatings[4]++;


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
