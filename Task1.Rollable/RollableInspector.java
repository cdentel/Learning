/*
 * Provides methods for inspecting rollables
 */
public class RollableInspector {

  /*
   * Pre:   rollable != null, else throws IllegalArgumentException
   *        numberOfRolls > 1, else throws IllegalArgumentException
   *        0.0 < allowedDeviation < 1.0 else throws IllegalArgumentException
   *
   * Post:  Returns whether after numberOfRolls rolls, their exists a 
   *        disparity of frequency of rolls greater than allowedDeviation.
   */
  public static boolean isProbablyWeighted(
      Rollable rollable, 
      int numberOfRolls, 
      double allowedDeviation) {
    if (allowedDeviation <= 0.0 || allowedDeviation >= 1.0) {
      throw new IllegalArgumentException("0.0 < allowedDeviation < 1.0");
    }
    return computeDeviation(rollable, numberOfRolls) > allowedDeviation;
  }

  /*
   * Pre:   rollable != null, else throws IllegalArgumentException
   *        numberOfRolls > 1, else throws IllegalArgumentException
   *
   * Post:  returns the amount of the greatest disparity between results
   *        observed during numberOfRolls.
   *
   *        e.g. if rollable.sides() == 3, and rolls [1,2,3,1] are observed
   *        the percentage of rolls is [0.50,0.25,0.25] for sides [1,2,3]
   *        respectively.  The greatest disparity is that between sides 1 and 
   *        sides 2 or 3 at 0.25 (0.50 - 0.25)
   */
  public static double computeDeviation(Rollable rollable, 
  													 int numberOfRolls) {
    double rolls[] = new double[rollable.sides()];
	 for(int i = 0; i < numberOfRolls; i++) {
	 	rollable.roll();
		rolls[rollable.lastRoll() - 1]++;
	 }
	 
	 double first = (double) rolls[0]/numberOfRolls;
	 double min = first;
	 double max = first;
	 for (int j = 1; j < rollable.sides(); j++) {
	 	rolls[j] = (double) rolls[j]/numberOfRolls;
		if (rolls[j] > max) {
			max = rolls[j];
		} else if (rolls[j] < min) {
			min = rolls[j];
		}
	 }
    return max - min;
  }


}
