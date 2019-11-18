import java.util.ArrayList;
import java.util.List;

public class DataPreparation {

	/*
	 * Replaces special characters and splits the String into String arrays
	 * 
	 * @param: String array to be initialized, String to be worked on
	 * 
	 * @return: the initialized String array
	 */
	public String[] replaceAndSplit(String str) {
		return str.replace('*', ' ').replace('-', ' ').split(" ");
	}

	/*
	 * Cleans a String array from unnecessary entries and adds the remaining Strings
	 * to a list
	 * 
	 * @param: the String array to be cleaned
	 * 
	 * @return: returns a list of Strings
	 */
	public List<String> cleanList(String[] strArray) {

		List<String> cleanStringList = new ArrayList<String>();

		for (String arrayEntry : strArray) {
			if (!arrayEntry.equals("")) {
				cleanStringList.add(arrayEntry);
			}
		}
		return cleanStringList;
	}

	/*
	 * Looks for Gaps in Data, where there are no entries for 8 digits and replaces
	 * one digit with String "Null"
	 * 
	 * @param: String array to be looked at
	 * 
	 * @return: return String array with replacements
	 */
	public String[] replaceGapsInData(String[] strArray) {
		for (int index = 0; index < strArray.length - 4; index++) {
			if (strArray[index].equals("")
					&& (strArray[index++].equals("") && strArray[index + 2].equals("") && strArray[index + 3].equals("")
							&& strArray[index + 4].equals(""))
					&& (strArray[index - 1].equals("") && strArray[index - 2].equals("")
							&& strArray[index - 4].equals("") && strArray[index - 3].equals(""))) {

				strArray[index + 6] = "Null";
			}
		}
		return strArray;
	}
}
