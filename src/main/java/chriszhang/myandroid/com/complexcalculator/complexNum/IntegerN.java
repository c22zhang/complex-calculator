/**
 * Represents an integer number, or a whole number - corresponds to the int type of Java
 * @author Chris Zhang
 */

package complexNum;

public class IntegerN extends RationalN {
 
  /**
   * Creates a new instance of class IntegerN
   * @param integer The whole number that this instance of the class is representing
   */
  public IntegerN(int integer){
    super(integer, 1);
  }
  
  /**
   * returns a string representation of the integer
   * @return Returns a string representation of the Integer
   */
  @Override
  public String toString(){
    return getNumerator() + "";
  }
  
}