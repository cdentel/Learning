import java.util.*;

public class Die implements Rollable {
	
	private int sides = 6; // default sides
	private int lastRoll = 0;
	
	
	public int sides() {
		return sides;
	}
	
	public int criticalValue() {
		return sides;
	}
	
	public void roll() {
		Random r = new Random();
		lastRoll = r.nextInt(sides) + 1;
	}
	
	public int lastRoll() {
		return lastRoll();
	}

}