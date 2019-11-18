
public class Calculation {

	/*
	 * Parses two Strings to Integer and gets the difference between them
	 * 
	 * @param: two Strings
	 * 
	 * @return: difference Integer or Integer MIN VALUE when illegal argument
	 */
	public int differenceFromStrings(String numberAsStringA, String numberAsStringB) {

		int difference = Integer.MAX_VALUE;

		try {
			difference = Integer.parseInt(numberAsStringA) - Integer.parseInt(numberAsStringB);
		} catch (IllegalArgumentException e) {
			difference = Integer.MIN_VALUE;
			e.printStackTrace();
		}

		return difference;
	}

	/*
	 * Determines, if the absolute difference needs to be used
	 * 
	 * @param: the positive and negative difference
	 * 
	 * @return: the absolute difference
	 */
	public int getOverallDifference(int positiveDifference, int negativeDifference) {

		int overallDifference;

		if (Math.abs(positiveDifference) > Math.abs(negativeDifference)) {

			overallDifference = negativeDifference;

		} else {

			overallDifference = positiveDifference;
		}
		return overallDifference;
	}

	/*
	 * Determines, if the absolute difference needs to be used
	 * 
	 * @param: the positive and negative difference and the strings to save the
	 * corresponding entries
	 * 
	 * @return: the entry of the absolute difference
	 */
	public String getOverallDifferenceInfo(int positiveDifference, int negativeDifference,
			String positiveDifferenceInfo, String negativeDifferenceInfo) {

		String overallDifferenceInfo;

		if (Math.abs(positiveDifference) > Math.abs(negativeDifference)) {

			overallDifferenceInfo = negativeDifferenceInfo;

		} else {

			overallDifferenceInfo = positiveDifferenceInfo;
		}
		return overallDifferenceInfo;
	}

}
