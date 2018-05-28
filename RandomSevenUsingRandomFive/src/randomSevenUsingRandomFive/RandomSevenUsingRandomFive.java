package randomSevenUsingRandomFive;

// Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. 
// Use random5() to implement random7().

public class RandomSevenUsingRandomFive {

	static class RandomFive {
		static int random5() {
			return (int) (Math.random() * 5);
		}
	}

	public int random7() {
		while (true) {
			int random = 5 * RandomFive.random5() + RandomFive.random5();
			if (random < 21) {
				return random % 7;
			}
		}
	}
	
}
