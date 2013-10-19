public class ShadiesTrickyDie extends Die implements Rollable {

	int count = 0;
	boolean cheat = false;

	public ShadiesTrickyDie() {
		super();
	}

	public ShadiesTrickyDie(int sides) {
		super(sides);
	}
	
	public void roll() {
		super.roll();
		if (lastRoll == 1) {
			if (cheat) {
				lastRoll = sides;
				cheat = false;
			}
		}
		if (count % 18 == 0)
			cheat = true;
		count++;
	}
}