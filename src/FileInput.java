import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileInput {

	/*
	 * Reads in file as String by line and adds them to a list
	 * 
	 * @param: the file as a String url
	 * 
	 * @return: returns a list of String arrays
	 */
	public List<String[]> readInFile(String file) {

		String[] strArray = {};
		List<String[]> arrayStringList = new LinkedList<String[]>();
		DataPreparation dataPreparation = new DataPreparation();

		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str = in.readLine();

			while ((str = in.readLine()) != null) {
				strArray = dataPreparation.replaceAndSplit(str);
				arrayStringList.add(strArray);
			}

			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return arrayStringList;
	}
}
