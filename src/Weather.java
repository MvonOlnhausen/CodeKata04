import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String differenceInfo = "";
	private int difference = Integer.MAX_VALUE;
	private List<String> cleanedStringList = new ArrayList<String>();
	private FileInput fileInput = new FileInput();
	private DataPreparation dataPreparation = new DataPreparation();
	private Calculation calculation = new Calculation();

	/*
	 * outputs the day number with the smallest temperature spread
	 * 
	 * @return: a String with the final answer
	 */
	public String weatherData() {
		List<String[]> arrayStringList = fileInput.readInFile("src/data/weather.dat");

		for (String[] strArray : arrayStringList) {
			strArray = dataPreparation.replaceGapsInData(strArray);
			cleanedStringList.addAll(dataPreparation.cleanList(strArray));
		}

		cleanedStringList.subList(cleanedStringList.indexOf("mo"), cleanedStringList.size()).clear();

		difference = getSmallestDifference(cleanedStringList);
		differenceInfo = getSmallestDifferenceInfo(cleanedStringList);

		return "On day " + differenceInfo + " is the smallest temperature spread with " + difference + " degrees.";
	}

	/*
	 * Gets the smallest difference between two entries for each sublist
	 * 
	 * @param: the list of Strings to be looked at
	 * 
	 * @return: the smallest difference over all sublists
	 */
	public int getSmallestDifference(List<String> cleanedStringList) {
		int difference = Integer.MAX_VALUE;

		for (int index = 0; index < cleanedStringList.size() - 16; index += 16) {

			List<String> subListPerTableRow = cleanedStringList.subList(index, index + 16);

			int calculatedDifference = calculation.differenceFromStrings(subListPerTableRow.get(1), subListPerTableRow.get(2));

			if (calculatedDifference < difference) {

				difference = calculatedDifference;
			}
		}
		return difference;
	}

	/*
	 * Gets the smallest difference between two entries for each sublist
	 * 
	 * @param: the list of Strings to be looked at
	 * 
	 * @return: the day of the smallest difference
	 */
	public String getSmallestDifferenceInfo(List<String> cleanedStringList) {
		int difference = Integer.MAX_VALUE;

		for (int index = 0; index < cleanedStringList.size() - 16; index += 16) {

			List<String> subListPerTableRow = cleanedStringList.subList(index, index + 16);

			int calculatedDifference = calculation.differenceFromStrings(subListPerTableRow.get(1), subListPerTableRow.get(2));

			if (calculatedDifference < difference) {

				difference = calculatedDifference;
				differenceInfo = subListPerTableRow.get(0);
			}
		}
		return differenceInfo;
	}
}
