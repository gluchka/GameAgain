package parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTParser {

	public static List<String> txtParser() {
		List<String> city = new ArrayList<String>();
		try {
			Scanner read = new Scanner(new File(
					"src\\main\\resources\\parser.txt"));

			while (read.hasNextLine()) {
				city.add(read.nextLine());
			}

			read.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return city;
	}

}
