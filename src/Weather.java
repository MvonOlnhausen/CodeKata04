import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String smallest = "";
	private int diff = Integer.MAX_VALUE;
	private List<String> cleanedString = new ArrayList<String>();
	private FileInput fileInput = new FileInput();
	private DataPreparation dataPreparation = new DataPreparation();
	private Calculation calculation = new Calculation();

	/*
	 * outputs the day number with the smallest temperature spread
	 * 
	 * @return: a String with the final answer
	 */
	public String weatherData() {
		List<String[]> strArrayList = fileInput.readInFile("src/data/weather.dat");

		for (String[] strArray : strArrayList) {
			strArray = dataPreparation.replaceGapsInData(strArray);
			cleanedString.addAll(dataPreparation.cleanList(strArray));
		}

		cleanedString.subList(cleanedString.indexOf("mo"), cleanedString.size()).clear();

		diff = getSmallestDifference(cleanedString);
		smallest = getSmallestDay(cleanedString);

		return "On day " + smallest + " is the smallest temperature spread with " + diff + " degrees.";
	}

	/*
	 * Gets the smallest difference between two entries for each sublist
	 * 
	 * @param: the list of Strings to be looked at
	 * 
	 * @return: the smallest difference over all sublists
	 */
	public int getSmallestDifference(List<String> cleanedString) {
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < cleanedString.size() - 16; i += 16) {

			List<String> subList = cleanedString.subList(i, i + 16);

			int differ = calculation.differenceFromString(subList.get(1), subList.get(2));

			if (differ < diff) {

				diff = differ;
			}
		}
		return diff;
	}

	/*
	 * Gets the smallest difference between two entries for each sublist
	 * 
	 * @param: the list of Strings to be looked at
	 * 
	 * @return: the day of the smallest difference
	 */
	public String getSmallestDay(List<String> cleanedString) {
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < cleanedString.size() - 16; i += 16) {

			List<String> subList = cleanedString.subList(i, i + 16);

			int differ = calculation.differenceFromString(subList.get(1), subList.get(2));

			if (differ < diff) {

				diff = differ;
				smallest = subList.get(0);
			}
		}
		return smallest;
	}
}
