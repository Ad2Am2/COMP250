package assignment3;

import java.awt.Color;

public class PerimeterGoal extends Goal{

	public PerimeterGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {

		int output = 0;

		Color[][] colorBoard = board.flatten();

		for (int i = 0; i < colorBoard.length; i++) {

			if (colorBoard[0][i].equals(targetGoal)) output += 1;
			if (colorBoard[i][0].equals(targetGoal)) output += 1;
			if (colorBoard[colorBoard.length-1][i].equals(targetGoal)) output += 1;
			if (colorBoard[i][colorBoard.length-1].equals(targetGoal)) output += 1;

		}
		return output;
	}

	@Override
	public String description() {
		return "Place the highest number of " + GameColors.colorToString(targetGoal) 
		+ " unit cells along the outer perimeter of the board. Corner cell count twice toward the final score!";
	}

}
