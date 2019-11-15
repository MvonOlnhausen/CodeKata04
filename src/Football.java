import java.util.ArrayList;
import java.util.List;

public class Football {

	private FileInput commonCode = new FileInput();
	private DataPreparation dataPreparation = new DataPreparation();
	private Calculation calculation = new Calculation();
	private List<String> cleanString = new ArrayList<String>();
	private int diff = Integer.MAX_VALUE;
	private int difference = Integer.MAX_VALUE;
	private int diffNeg = Integer.MIN_VALUE;
	private String smallest = "";
	private String smallest2 = "";
	private String small = "";

	/*
	 * prints the name of the team with the smallest difference in ‘for’ and
	 * ‘against’ goals
	 * 
	 * @return: a String with the final answer
	 */
	public String footballTable() {

		List<String[]> strArrayList2 = commonCode.readInFile("src/data/football.dat");

		for (String[] strArray : strArrayList2) {

			cleanString.addAll(dataPreparation.cleanList(strArray));
		}

		for (int i = 0; i < cleanString.size(); i += 9) {
			List<String> subList = cleanString.subList(i, i + 9);

			int goalDiff = calculation.differenceFromStrings(subList.get(6), subList.get(7));

			if (goalDiff < diff && goalDiff >= 0) {

				diff = goalDiff;
				smallest = subList.get(1);

			} else if (goalDiff > diffNeg && goalDiff <= 0) {

				diffNeg = goalDiff;
				smallest2 = subList.get(1);
			}

			difference = calculation.getAbsoluteDifference(diff, diffNeg);
			small = calculation.getAbsoluteDifferenceInfo(diff, diffNeg, smallest, smallest2);
		}

		return "The team " + small + " has the smallest difference in 'for' and 'against' goals with difference of "
				+ difference + ".";
	}
}
