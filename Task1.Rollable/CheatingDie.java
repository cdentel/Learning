public class CheatingDie extends Die {


	public void roll() {
		super.roll();
		if (lastRoll ==  1)
			lastRoll = sides;
	}
}