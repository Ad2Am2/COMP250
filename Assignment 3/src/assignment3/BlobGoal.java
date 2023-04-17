package assignment3;

import java.awt.Color;

public class BlobGoal extends Goal{

	public BlobGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {

		int largestScore = 0;

		int currentScore;

		Color[][] flatBoard = board.flatten();

		for (int i = 0; i < flatBoard.length; i++){
			for (int j = 0; j < flatBoard[i].length; j++) {
				currentScore = undiscoveredBlobSize(i, j, flatBoard, new boolean[flatBoard.length][flatBoard.length]);
				if (currentScore > largestScore) largestScore = currentScore;
			}
		}

		return largestScore;

	}

	@Override
	public String description() {
		return "Create the largest connected blob of " + GameColors.colorToString(targetGoal) 
		+ " blocks, anywhere within the block";
	}


	public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {

		if (i < 0 || j < 0 || unitCells.length != visited.length || unitCells[i].length != visited[i].length) throw new IllegalArgumentException("Invalid input!");
		if (i >= unitCells.length || j >= unitCells[i].length) throw new IllegalArgumentException("Invalid input!");

		if (!unitCells[i][j].equals(targetGoal)) return 0;

		visited[i][j] = true;

		int output = 1;

		if (i+1 < unitCells.length) {
			if (!visited[i+1][j]) output += undiscoveredBlobSize(i+1, j, unitCells, visited);
		}
		if (j+1 < unitCells[i].length) {
			if (!visited[i][j+1]) output += undiscoveredBlobSize(i, j+1, unitCells, visited);
		}
		if (i-1 >= 0) {
			if (!visited[i-1][j]) output += undiscoveredBlobSize(i-1, j, unitCells, visited);
		}
		if (j-1 >= 0) {
			if (!visited[i][j-1]) output += undiscoveredBlobSize(i, j-1, unitCells, visited);
		}

		return output;

	}

}
