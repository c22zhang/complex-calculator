/**
 * represents a natural number, also known as a positive integer
 * @author Chris Zhang
 */

package complexNum;

public class NaturalN extends IntegerN{
  
  /**
   * Creates a new instance of class NaturalN
   * @param number The natural class that this instance represents.
   * @exception ArithmeticException if the natural number is negative
   */
  public NaturalN (int number) throws ArithmeticException{
    super(number);
    if(number<0)
      throw new ArithmeticException("Natural numbers cannot be negative");
  }
}