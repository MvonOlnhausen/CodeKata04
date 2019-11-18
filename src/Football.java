import java.util.ArrayList;
import java.util.List;

public class Football {

	private FileInput commonCode = new FileInput();
	private DataPreparation dataPreparation = new DataPreparation();
	private Calculation calculation = new Calculation();
	private List<String> cleanStringList = new ArrayList<String>();
	private int positiveDifference = Integer.MAX_VALUE;
	private int difference = Integer.MAX_VALUE;
	private int negativeDifference = Integer.MIN_VALUE;
	private String positiveDifferenceInfo = "";
	private String negativeDifferenceInfo = "";
	private String differenceInfo = "";

	/*
	 * prints the name of the team with the smallest difference in ‘for’ and
	 * ‘against’ goals
	 * 
	 * @return: a String with the final answer
	 */
	public String footballTable() {

		List<String[]> strArrayList2 = commonCode.readInFile("src/data/football.dat");

		for (String[] strArray : strArrayList2) {

			cleanStringList.addAll(dataPreparation.cleanList(strArray));
		}

		for (int index = 0; index < cleanStringList.size(); index += 9) {
			List<String> subListPerDataRow = cleanStringList.subList(index, index + 9);

			int goalDifference = calculation.differenceFromStrings(subListPerDataRow.get(6), subListPerDataRow.get(7));

			if (goalDifference < positiveDifference && goalDifference >= 0) {

				positiveDifference = goalDifference;
				positiveDifferenceInfo = subListPerDataRow.get(1);

			} else if (goalDifference > negativeDifference && goalDifference <= 0) {

				negativeDifference = goalDifference;
				negativeDifferenceInfo = subListPerDataRow.get(1);
			}

			difference = calculation.getOverallDifference(positiveDifference, negativeDifference);
			differenceInfo = calculation.getOverallDifferenceInfo(positiveDifference, negativeDifference,
					positiveDifferenceInfo, negativeDifferenceInfo);
		}

		return "The team " + differenceInfo
				+ " has the smallest difference in 'for' and 'against' goals with difference of " + difference + ".";
	}
}
