package game;

import java.util.Iterator;
import java.util.List;

import factory.Factory;

public class Mashine extends Players {

	@Override
	public void writeWord() {
		System.out.println("Mashine:");
		String mashineWriteCity = getFirstWordOnTheUsersLastLetter();
		if (mashineWriteCity != null) {
			delete(mashineWriteCity);
			GameSities.lastLetter = Players.checkLastLetter(mashineWriteCity);
			System.out.println(mashineWriteCity);
		} else {
			Factory.cities.clear();
			System.out.println("User win!");
		}
	}

	public static String getFirstWordOnTheUsersLastLetter() {
		String cityIterator;
		Iterator<String> itr = Factory.cities.iterator();
		while (itr.hasNext()) {
			 cityIterator = (String) itr.next();
			if (cityIterator.charAt(0) == GameSities.lastLetter)
				return cityIterator;
		}
		return null;
	}
}
