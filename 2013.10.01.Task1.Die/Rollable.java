/*
 * Defines a Rollable - an Object which has a number of sides and can be 
 * rolled to change the current value. A rollable has sides() > 1.
 */
public interface Rollable {
  
  /*
   * Returns the critical value of this Rollable - the critical value is equal 
   * to the highest rollable value.
   */
  public int criticalValue();

  /*
   * Post: returns the number of sides this rollable has.
   */
  public int sides();

  /*
   * Rolls the Rollable, determining a new value to be returned by
   * lastRoll().
   *
   */
  public void roll();

  /*
   * The last rolled value.
   *
   * Post: Returns the value of the last roll.  Does not mutate state.
   */
   public int lastRoll();

}
