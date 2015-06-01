package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import factory.Factory;

public class GameSities extends Players implements IBeginer {

	public static char lastLetter;

	@Override
	public void writeWord() {
		Random random = new Random();
		int firstRandomCity = random.nextInt(Factory.cities.size());

		System.out.println(Factory.cities.get(firstRandomCity));

		lastLetter = checkLastLetter(Factory.cities.get(firstRandomCity));
		delete(Factory.cities.get(firstRandomCity));
	}

	public void startGame() {
		int usersCount = 0;
		System.out.println("Введите кличество игроков:");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			usersCount = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			System.err.print("(NumberFormatException");
		} catch (IOException e) {
			System.err.print("(IOException");
		}

		User user = new User(usersCount);
		Mashine mash = new Mashine();

		user.addUsers();
		writeWord();

		while (Factory.cities.size() != 0 && (checkNextWord(lastLetter))) {

			for (User eachUser : user.users)
				eachUser.writeWord();
			
			mash.writeWord();
		}
		System.out.println("GAME OVER!");
	}

}
