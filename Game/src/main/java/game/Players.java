package game;

import java.util.Iterator;
import java.util.List;

import factory.Factory;

public abstract class Players {

	public abstract void writeWord();

	public static void delete(String word) {
		Factory.cities.remove(word);
	}

	public static boolean checkNextWord(char last) {
		Boolean nextWord = false;
		Iterator<String> itr = Factory.cities.iterator();
		while (itr.hasNext()) {
			String cityItr = (String) itr.next();
			if (cityItr.charAt(0) == last)
				nextWord = true;
		}
		return nextWord;
	}

	public static char checkLastLetter(String word) {
		int last = word.length() - 1;
		char lastChar = word.toUpperCase().charAt(last);
		if (word.toUpperCase().charAt(last) == 'É') {
			return 'È';
		} else if (lastChar == 'Ü' || lastChar == 'Û' || lastChar == 'Ú') {
			last--;
		}
		return word.toUpperCase().charAt(last);
	}
	
}
