import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Tests {

	@Test
	public void differenceFromStringTest() {

		Calculation calculation = new Calculation();

		assertEquals(1, calculation.differenceFromStrings("2", "1"));
		assertEquals(9, calculation.differenceFromStrings("99", "90"));
		assertEquals(4, calculation.differenceFromStrings("1", "-3"));
		assertEquals(-3, calculation.differenceFromStrings("2", "5"));
		assertEquals(-15, calculation.differenceFromStrings("-10", "5"));
		assertEquals(-5, calculation.differenceFromStrings("-10", "-5"));
		assertEquals(Integer.MIN_VALUE, calculation.differenceFromStrings("a", "-5"));
		assertEquals(Integer.MIN_VALUE, calculation.differenceFromStrings("6", "b"));
		assertEquals(Integer.MIN_VALUE, calculation.differenceFromStrings("a", "b"));
	}

	@Test
	public void cleanListTest() {

		DataPreparation dataPreparation = new DataPreparation();
		String[] strArray = { "a", "b", "", "?" };
		String[] strArray2 = { "", "", "", "" };
		String[] strArray3 = { "", "1", "2", "c" };

		assertEquals(3, dataPreparation.cleanList(strArray).size());
		assertEquals(false, dataPreparation.cleanList(strArray).contains(""));
		assertEquals(2, dataPreparation.cleanList(strArray).indexOf("?"));
		assertEquals(0, dataPreparation.cleanList(strArray2).size());
		assertEquals(false, dataPreparation.cleanList(strArray2).contains(""));
		assertEquals(3, dataPreparation.cleanList(strArray3).size());
		assertEquals(false, dataPreparation.cleanList(strArray3).contains(""));
		assertEquals(0, dataPreparation.cleanList(strArray3).indexOf("1"));

	}

	@Test
	public void readInFileTest() {

		FileInput fileInput = new FileInput();
		String file = "src/data/weather.dat";
		Boolean a = fileInput.readInFile(file).isEmpty();
		String file2 = "src/data/football.dat";
		boolean b = fileInput.readInFile(file2).isEmpty();

		assertFalse(Boolean.valueOf(a));
		assertFalse(b);
	}

	@Test
	public void weatherDataTest() {

		Weather weather = new Weather();

		assertEquals("On day 14 is the smallest temperature spread with 2 degrees.", weather.weatherData());
	}

	@Test
	public void footballTableTest() {

		Football football = new Football();

		assertEquals(
				"The team Aston_Villa has the smallest difference in 'for' and 'against' goals with difference of -1.",
				football.footballTable());
	}

	@Test
	public void replaceAndSplitTest() {

		DataPreparation dataPreparation = new DataPreparation();
		String str = "*-a";
		String str2 = "";
		String str3 = "w r*4-";
		String[] strArray = { "", "", "a" };
		String[] strArray2 = { "" };
		String[] strArray3 = { "w", "r", "4" };

		assertArrayEquals(strArray, dataPreparation.replaceAndSplit(str));
		assertArrayEquals(strArray2, dataPreparation.replaceAndSplit(str2));
		assertArrayEquals(strArray3, dataPreparation.replaceAndSplit(str3));
	}

	@Test
	public void getSmallestDifferenceTest() {

		Weather weather = new Weather();
		List<String> cleanedStringList = Arrays.asList("1", "2", "1", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
		List<String> cleanedStringList2 = Arrays.asList("2", "100", "-10", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
		List<String> cleanedStringList3 = Arrays.asList("3", "-4", "2", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

		assertEquals(1, weather.getSmallestDifference(cleanedStringList));
		assertEquals(110, weather.getSmallestDifference(cleanedStringList2));
		assertEquals(-6, weather.getSmallestDifference(cleanedStringList3));
	}

	@Test
	public void getSmallestDifferenceInfoTest() {

		Weather weather = new Weather();
		List<String> cleanedStringList = Arrays.asList("1", "2", "1", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
		List<String> cleanedStringList2 = Arrays.asList("2", "100", "-10", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
		List<String> cleanedStringList3 = Arrays.asList("3", "-4", "2", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");

		assertEquals("1", weather.getSmallestDifferenceInfo(cleanedStringList));
		assertEquals("2", weather.getSmallestDifferenceInfo(cleanedStringList2));
		assertEquals("3", weather.getSmallestDifferenceInfo(cleanedStringList3));
	}
}
