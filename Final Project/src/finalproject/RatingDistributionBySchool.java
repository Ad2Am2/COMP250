package finalproject;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class RatingDistributionBySchool extends DataAnalyzer {

	private MyHashTable<String, MyHashTable<String, double[]>> schoolProfs;

	public RatingDistributionBySchool(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {

		keyword = keyword.toLowerCase().trim();

		MyHashTable<String, Integer> output = new MyHashTable<>();


		MyHashTable<String, double[]> profRatings = schoolProfs.get(keyword);
		if (profRatings == null) return null;
		ArrayList<String> profNames = profRatings.getKeySet();

		for (int i = 0; i < profNames.size(); i++){

			String profName = profNames.get(i);

			double[] profRating = profRatings.get(profName);

			double average = profRating[0]/profRating[1];
			int reviewCount = (int) profRating[1];

			String outputString = profName + "\n" + average;

			output.put(outputString, reviewCount);

		}

		return output;
	}

	@Override
	public void extractInformation() {

		this.schoolProfs = new MyHashTable<>();

		for (int i = 0; i < parser.data.size(); i++){

			String schoolName = parser.data.get(i)[parser.fields.get("school_name")].toLowerCase().trim();

			if (schoolProfs.get(schoolName) == null) schoolProfs.put(schoolName, new MyHashTable<>());

			MyHashTable<String, double[]> profRatings = schoolProfs.get(schoolName);

			String professorName = parser.data.get(i)[parser.fields.get("professor_name")].toLowerCase().trim();

			if (profRatings.get(professorName) == null) profRatings.put(professorName, new double[] {0.0, 0.0});

			double[] profRating = profRatings.get(professorName); // First element is total count of rating stars, second is number of ratings, so average is [0]/[1]

			double rating = Double.parseDouble(parser.data.get(i)[parser.fields.get("student_star")]);

			profRating[0] += rating;
			profRating[1]++;


		}

	}
}
