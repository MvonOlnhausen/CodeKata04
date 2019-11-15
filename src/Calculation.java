
public class Calculation {

	/*
	 * Parses two Strings to Integer and gets the difference between them
	 * 
	 * @param: two Strings
	 * 
	 * @return: difference Integer or Integer MIN VALUE when illegal argument
	 */
	public int differenceFromStrings(String stringA, String stringB) {

		int difference = Integer.MAX_VALUE;

		try {
			difference = Integer.parseInt(stringA) - Integer.parseInt(stringB);
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
	public int getAbsoluteDifference(int diff, int diffNeg) {

		int difference;

		if (Math.abs(diff) > Math.abs(diffNeg)) {

			difference = diffNeg;

		} else {

			difference = diff;
		}
		return difference;
	}

	/*
	 * Determines, if the absolute difference needs to be used
	 * 
	 * @param: the positive and negative difference and the strings to save the
	 * corresponding entries
	 * 
	 * @return: the entry of the absolute difference
	 */
	public String getAbsoluteDifferenceInfo(int diff, int diffNeg, String smallest, String smallest2) {

		String small;

		if (Math.abs(diff) > Math.abs(diffNeg)) {

			small = smallest2;

		} else {

			small = smallest;
		}
		return small;
	}

}
