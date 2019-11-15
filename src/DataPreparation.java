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

		for (String v : strArray) {
			if (!v.equals("")) {
				cleanStringList.add(v);
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
		for (int i = 0; i < strArray.length - 4; i++) {
			if (strArray[i].equals("")
					&& (strArray[i++].equals("") && strArray[i + 2].equals("") && strArray[i + 3].equals("")
							&& strArray[i + 4].equals(""))
					&& (strArray[i - 1].equals("") && strArray[i - 2].equals("") && strArray[i - 4].equals("")
							&& strArray[i - 3].equals(""))) {

				strArray[i + 6] = "Null";
			}
		}
		return strArray;
	}
}
