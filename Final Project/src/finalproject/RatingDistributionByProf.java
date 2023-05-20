package finalproject;

import javafx.util.Pair;

public class RatingDistributionByProf extends DataAnalyzer {

	private MyHashTable<String, int[]> profRatings;

	public RatingDistributionByProf(Parser p) {
        super(p);
    }

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {

		keyword = keyword.toLowerCase().trim();

		MyHashTable<String, Integer> data = new MyHashTable<>();
		if (profRatings.get(keyword) == null) return null;
		int[] ratings = profRatings.get(keyword);

		data.put("1", ratings[0]);
		data.put("2", ratings[1]);
		data.put("3", ratings[2]);
		data.put("4", ratings[3]);
		data.put("5", ratings[4]);

		return data;

	}

	@Override
	public void extractInformation() {

		this.profRatings = new MyHashTable<>();

		for (int i = 0; i < parser.data.size(); i++) {
			String professorName = parser.data.get(i)[parser.fields.get("professor_name")].toLowerCase().trim();
			int rating = (int) Double.parseDouble(parser.data.get(i)[parser.fields.get("student_star")]);

			if (profRatings.get(professorName) == null) profRatings.put(professorName,new int[] {0,0,0,0,0});

			profRatings.get(professorName)[rating-1]++;
		}

	}

}
